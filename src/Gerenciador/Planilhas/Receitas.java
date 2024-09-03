package Gerenciador.Planilhas;

public class Receitas {

	private int id_receita;
	private int id_usuario;
	private String data_receita;
	private String nome_receita;
	private String valor_receita;
	private String tipo_receita;
	
	public Receitas(int id_receita, int id_usuario, String data_receita, String nome_receita, String valor_receita, String tipo_receita) {
		
		this.id_receita = id_receita;
		this.id_usuario = id_usuario;
		this.data_receita = data_receita;
		this.nome_receita = nome_receita;
		this.valor_receita = valor_receita;
		this.tipo_receita = tipo_receita;
		
}

	private int getId_receita() {
		return id_receita;
	}

	private void setId_receita(int id_receita) {
		this.id_receita = id_receita;
	}

	private int getId_usuario() {
		return id_usuario;
	}

	private void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	private String getData_receita() {
		return data_receita;
	}

	private void setData_receita(String data_receita) {
		this.data_receita = data_receita;
	}

	private String getNome_receita() {
		return nome_receita;
	}

	private void setNome_receita(String nome_receita) {
		this.nome_receita = nome_receita;
	}

	private String getValor_receita() {
		return valor_receita;
	}

	private void setValor_receita(String valor_receita) {
		this.valor_receita = valor_receita;
	}

	private String getTipo_receita() {
		return tipo_receita;
	}

	private void setTipo_receita(String tipo_receita) {
		this.tipo_receita = tipo_receita;
	}

	
	
}
