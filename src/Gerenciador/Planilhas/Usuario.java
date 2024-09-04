package Gerenciador.Planilhas;

public class Usuario {
	
	private int id_usuario;
	private String nome_usuario;
	private String cpf_usuario;
	private String usuario_login;
	private String senha_login;
	
	public Usuario(int id_usuario, String nome_usuario, String cpf_usuario, String usuario_login, String senha_login) {
		
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.cpf_usuario = cpf_usuario;
		this.usuario_login = usuario_login;
		this.senha_login = senha_login;
		
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	
	public String getUsuario_login() {
		return usuario_login;
	}

	public void setUsuario_login(String usuario_login) {
		this.usuario_login = usuario_login;
	}

	public String getSenha_login() {
		return senha_login;
	}

	public void setSenha_login(String senha_login) {
		this.senha_login = senha_login;
	}

	public String toString() {
        return "Usuarios{" +
                "id_usuario=" + id_usuario +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", cpf_usuario=" + cpf_usuario +
                '}';
    }
	
}
