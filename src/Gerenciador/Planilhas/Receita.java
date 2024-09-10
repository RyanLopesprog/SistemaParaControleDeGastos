package Gerenciador.Planilhas;

public class Receita {

	private int id_receita;
	private int id_usuario;
	private String data_receita;
	private String nome_receita;
	private String valor_receita;
	private String nome_usuario;
	
	
	public Receita(int id_receita, int id_usuario, String nome_usuario,  String data_receita, String nome_receita, String valor_receita) {
		
		this.id_receita = id_receita;
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.data_receita = data_receita;
		this.nome_receita = nome_receita;
		this.valor_receita = valor_receita;
		
}

	public int getId_receita() {
		return id_receita;
	}

	public void setId_receita(int id_receita) {
		this.id_receita = id_receita;
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

	public String getData_receita() {
		return data_receita;
	}

	public void setData_receita(String data_receita) {
		this.data_receita = data_receita;
	}

	public String getNome_receita() {
		return nome_receita;
	}

	public void setNome_receita(String nome_receita) {
		this.nome_receita = nome_receita;
	}

	public String getValor_receita() {
		return valor_receita;
	}

	public void setValor_receita(String valor_receita) {
		this.valor_receita = valor_receita;
	}


	public String toString() {
        return "Receitas{" +
                "id_receita=" + id_receita +
                ", id_usuario='" + id_usuario + '\'' +
                ", data_receita='" + data_receita + '\'' +
                ", valor_receita=" + valor_receita +
                '}';
    }
	
	
}
