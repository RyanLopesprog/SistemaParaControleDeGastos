package Gerenciador.Planilhas;

public class Usuarios {
	
	private int id_usuario;
	private String nome_usuario;
	private String cpf_usuario;
	
	public Usuarios(int id_usuario, String nome_usuario, String cpf_usuario) {
		
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.cpf_usuario = cpf_usuario;
		
	}

	private int getId_usuario() {
		return id_usuario;
	}

	private void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	private String getNome_usuario() {
		return nome_usuario;
	}

	private void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	private String getCpf_usuario() {
		return cpf_usuario;
	}

	private void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	
	

}
