package Gerenciador;

import java.sql.*;

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
            rs = st.executeQuery("Select * FROM paciente");
            while (rs.next()) {
            
            System.out.println(rs.getInt(1)+". "+rs.getString(2));
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

}


