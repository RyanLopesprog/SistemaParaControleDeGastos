package Gerenciador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Gerenciador.Planilhas.Despesa;
import Gerenciador.Planilhas.Receita;
import Gerenciador.Planilhas.Usuario;


public class Conexao {
	
	private String url;
	private String user;
	private String password;
	
	private Connection con = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Conexao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void conectar() {

        try {
            if (this.con == null || this.con.isClosed()) {
                this.con = DriverManager.getConnection(this.url, this.user, this.password);
                System.out.println("Conexão criada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public void desconectar(){
    	if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void verTabelacontrolefinanceiro(){
        conectar();

        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * FROM controlefinanceiro");
            while (rs.next()) {
            
            System.out.println(rs.getInt(0)+". "+rs.getString(1));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        desconectar();

    }
    
    public static void main(String[] args) {
        Conexao conexaoBanco = new Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "Aluno");
        
        conexaoBanco.verTabelacontrolefinanceiro();
    }
    
public void inserirNovoUsuario(Usuario usuario){
	conectar();
        
        try {
            pst = con.prepareStatement("INSERT INTO usuario VALUES (DEFAULT, ?, ?, ?, ?)");
            pst.setString(1, usuario.getNome_usuario());
            pst.setString(2, usuario.getCpf_usuario());
            pst.setString(3, usuario.getUsuario_login());
            pst.setString(4, usuario.getSenha_login());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
    }

public Usuario buscarUsuarioPorNome(String Nome_usuario){
    Usuario usuario = null;
    conectar();
    try {
        pst = con.prepareStatement("SELECT * FROM controlefinancerio WHERE nome_usuario = ?");
        pst.setString(1, Nome_usuario);
        rs = pst.executeQuery();

        if (rs.next()){
            usuario = new Usuario(0, Nome_usuario, Nome_usuario, Nome_usuario, Nome_usuario);
            usuario.setId_usuario(rs.getInt(0));
            usuario.setNome_usuario(rs.getString(1));
            usuario.setCpf_usuario(rs.getString(2));
            usuario.setUsuario_login(rs.getString(4));
            usuario.setSenha_login(rs.getString(5));
        }
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    desconectar();
    return usuario;
}

public List<Despesa> buscarTodasDespesas() {
	List<Despesa> despesas = new ArrayList<Despesa>();
	conectar();
	
	try {
		// SELECT * FROM usuarios
		st = con.createStatement();
		
		rs = st.executeQuery("SELECT * FROM despesas");
		
		while(rs.next()) {
			Despesa despesa = new Despesa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
			despesas.add(despesa);
		}
		
		
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	
	desconectar();
	return despesas;
}

public List<Receita> buscarTodasReceitas() {
    List<Receita> receitas = new ArrayList<Receita>();
    conectar();

    try {
        // SELECT * FROM receitas
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM receitas");

        while(rs.next()) {
            Receita receita = new Receita(
                rs.getInt(1),       // id_receita
                rs.getInt(2),       // id_usuario
                rs.getString(3),   // data_receita
                rs.getString(4),   // nome_receita
                rs.getString(5) // valor_receita   
            );

            receitas.add(receita);
        }

    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }

    desconectar();
    return receitas;
}

public List<Usuario> buscarTodosUsuarios() {
    List<Usuario> usuarios = new ArrayList<Usuario>();
    conectar();

    try {
        // SELECT * FROM usuarios
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM usuarios");

        while(rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt(1),         // id_usuario
                rs.getString(2),      // nome_usuario
                rs.getString(3),      // cpf_usuario
                rs.getString(4),      // usuario_login
                rs.getString(5)       // senha_login
            );

            usuarios.add(usuario);
        }

    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }

    desconectar();
    return usuarios;
}


public void inserirNovaReceita(Receita receita) {
    conectar();
    
    try {
        // Prepara o comando SQL para inserir uma nova receita
        pst = con.prepareStatement("INSERT INTO receitas (id_usuario, data_receita, nome_receita, valor_receita) VALUES (?, ?, ?, ?)");
        
        pst.setInt(1, receita.getId_usuario());
        pst.setString(2, receita.getData_receita()); // Assumindo que data_receita é um String no formato 'YYYY-MM-DD'
        pst.setString(3, receita.getNome_receita());
        pst.setString(4, receita.getValor_receita());

        // Executa o comando SQL
        pst.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    
    desconectar();
}



}


