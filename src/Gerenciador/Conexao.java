package Gerenciador;

import java.sql.*;

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

}


