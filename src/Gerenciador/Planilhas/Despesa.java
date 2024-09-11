package Gerenciador.Planilhas;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Despesa {
	
	private int id_despesa;
	private int id_usuario;
	private String nome_usuario;
	private String data_despesa;
	private String nome_despesa;
	private String valor_despesa;
	
	public Despesa(int id_despesa, int id_usuario, String nome_usuario, String data_despesa, String nome_despesa, String valor_despesa) {
		
		this.id_despesa = id_despesa;
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
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
	

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
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
                 ", nome_usuario='" + nome_usuario + '\'' +
                ", data_despesa='" + data_despesa + '\'' +
                ", nome_despesa='" + nome_despesa + '\'' +
                ", valor_despesa=" + valor_despesa +
               
                '}';
    }
	
	
	public String formatodataBR() {
		 String dataBR = null;
		 SimpleDateFormat formatoBR = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatoISO = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(getData_despesa());
		 Date data = null;
		 try {
			data = formatoISO.parse(getData_despesa());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return formatoBR.format(data);
		
	}
	
}