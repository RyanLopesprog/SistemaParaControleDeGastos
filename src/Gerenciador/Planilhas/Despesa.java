package Gerenciador.Planilhas;

public class Despesa {
	
	private int id_despesa;
	private int id_usuario;
	private String data_despesa;
	private String nome_despesa;
	private String valor_despesa;
	
	public Despesa(int id_despesa, int id_usuario, String data_despesa, String nome_despesa, String valor_despesa) {
		
		this.id_despesa = id_despesa;
		this.id_usuario = id_usuario;
		this.data_despesa = data_despesa;
		this.nome_despesa = nome_despesa;
		this.valor_despesa = valor_despesa;

}

	public int getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(int id_despesa) {
		this.id_despesa = id_despesa;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getData_despesa() {
		return data_despesa;
	}

	public void setData_despesa(String data_despesa) {
		this.data_despesa = data_despesa;
	}

	public String getNome_despesa() {
		return nome_despesa;
	}

	public void setNome_despesa(String nome_despesa) {
		this.nome_despesa = nome_despesa;
	}

	public String getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(String valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	
	
	public String toString() {
        return "Despesas{" +
                "id_despesa=" + id_despesa +
                ", id_usuario='" + id_usuario + '\'' +
                ", data_despesa='" + data_despesa + '\'' +
                ", nome_despesa='" + nome_despesa + '\'' +
                ", valor_despesa=" + valor_despesa +
               
                '}';
    }
	
}