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

	public void desconectar() {
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

	public void verTabelacontrolefinanceiro() {
		conectar();

		try {
			st = con.createStatement();
			rs = st.executeQuery("Select * FROM controlefinanceiro");
			while (rs.next()) {

				System.out.println(rs.getInt(0) + ". " + rs.getString(1));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		desconectar();

	}

	public void inserirNovoUsuario(Usuario usuario) {
		conectar();

		try {
			pst = con.prepareStatement("INSERT INTO usuarios (nome_usuario, cpf_usuario, senha_login)VALUES (?, ?, ?)");

			pst.setString(1, usuario.getNome_usuario());
			pst.setString(2, usuario.getCpf_usuario());
			pst.setString(3, usuario.getSenha_login());

			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	public Usuario buscarUsuarioPorCpf(String Cpf_usuario) {
		Usuario usuario = null;
		conectar();
		try {
			pst = con.prepareStatement("SELECT * FROM controlefinanceiro.usuarios WHERE cpf_usuario = ?");
			pst.setString(1, Cpf_usuario);
			rs = pst.executeQuery();

			if (rs.next()) {
				usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		desconectar();
		return usuario;
	}

	public List<Usuario> buscarTodosUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		conectar();

		try {
			// SELECT * FROM usuarios
			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getInt(1), // id_usuario
						rs.getString(2), // nome_usuario
						rs.getString(3), // cpf_usuario
						rs.getString(4) // senha_login
				);

				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		desconectar();
		return usuarios;
	}

	public List<Despesa> buscarTodasDespesas() {
		List<Despesa> despesas = new ArrayList<Despesa>();
		conectar();

		try {
			// SELECT * FROM usuarios
			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM despesas");

			while (rs.next()) {
				Despesa despesa = new Despesa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				despesas.add(despesa);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		desconectar();
		return despesas;
	}

	public List<Despesa> buscarDespesasUsuario(int id_usuario) {

		List<Despesa> despesas = new ArrayList<Despesa>();
		conectar();

		try {
			// SELECT * FROM usuarios
			pst = con.prepareStatement("SELECT * FROM controlefinanceiro.despesas WHERE id_usuario ?");
			pst.setInt(1, id_usuario);
			rs = pst.executeQuery();

			if (rs.next()) {
				Despesa despesa = new Despesa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

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

			while (rs.next()) {
				Receita receita = new Receita(rs.getInt(1), // id_receita
						rs.getInt(2), // id_usuario
						rs.getString(3), //nome_usuario
						rs.getString(4), // data_receita
						rs.getString(5), // nome_receita
						rs.getString(6) // valor_receita
				);

				receitas.add(receita);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		desconectar();
		return receitas;
	}

	public void inserirNovaReceita(Receita receita) {
		conectar();

		try {
			// Prepara o comando SQL para inserir uma nova receita
			pst = con.prepareStatement(
					"INSERT INTO receitas (id_usuario, data_receita, nome_receita, valor_receita) VALUES (?, ?, ?, ?)");

			pst.setInt(1, receita.getId_usuario());
			pst.setString(2, receita.getData_receita()); // Assumindo que data_receita é um String no formato
															// 'YYYY-MM-DD'
			pst.setString(3, receita.getNome_receita());
			pst.setString(4, receita.getValor_receita());

			// Executa o comando SQL
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		desconectar();
	}

	public void inserirNovaDespesa(Despesa despesa) {
		conectar();

		try {
			// Prepara o comando SQL para inserir uma nova receita
			pst = con.prepareStatement(
					"INSERT INTO despesas (id_usuario, data_despesa, nome_despesa, valor_despesa) VALUES (?, ?, ?, ?)");

			pst.setInt(1, despesa.getId_usuario());
			pst.setString(2, despesa.getData_despesa()); // Assumindo que data_receita é um String no formato
															// 'YYYY-MM-DD'
			pst.setString(3, despesa.getNome_despesa());
			pst.setString(4, despesa.getValor_despesa());

			// Executa o comando SQL
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		desconectar();
	}

	public static void main(String[] args) {
		Conexao con = new Conexao("jdbc:mysql://localhost:3306/controlefinanceiro", "root", "Aluno");
		System.out.println(con.buscarTodosUsuarios());
	}

}
