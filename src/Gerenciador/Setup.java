package Gerenciador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Setup {

	public static void main(String[] args) {
	try {

        // Criar conexão com o banco. Dicas: Connection, Drivermanager.getConnection
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "L0p3s09@";

        Connection conexaoBanco = DriverManager.getConnection(url, user, password);

        System.out.println("Conectado com sucesso!");

        // Criar o objeto statement

        Statement statement = conexaoBanco.createStatement();

        // Usar o objeto statement para criar o banco escola
        statement.execute("DROP DATABASE IF EXISTS controlefinanceiro");
        statement.execute("CREATE DATABASE controlefinanceiro");
        System.out.println("Banco criado com sucesso!");

        statement.execute("USE controlefinanceiro");
        String createTableusuarios = 
                "CREATE TABLE usuarios (" +
                "id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "nome_usuario VARCHAR(255) NOT NULL, " +
                "cpf_usuario CHAR(11) NOT NULL UNIQUE, " +
                "usuario_login VARCHAR(255) NOT NULL, " +
                "senha_login VARCHAR(255) NOT NULL, " +
                "CONSTRAINT cpf_user CHECK (LENGTH(cpf_usuario) = 11 AND cpf_usuario REGEXP '^[0-9]{11}$')" + ")";
        
        
        String createTabledespesas = "CREATE TABLE despesas ("
        	    + "id_depesa INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
        	    + "id_usuario INT NOT NULL, "
        	    + "data_despesa VARCHAR(255) NOT NULL, "
        	    + "nome_despesa VARCHAR(255) NOT NULL, "
        	    + "valor_despesa DECIMAL(10, 2) NOT NULL, "
        	    + "CONSTRAINT fk_usuario_gasto FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)"
        	    + ");";

      
        
        String createTableusreceitas = "CREATE TABLE receitas ("
                + "id_receita INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "id_usuario INT NOT NULL, "
        		+ "data_receita VARCHAR(255) NOT NULL, "
                + "nome_receita VARCHAR(255) NOT NULL, "
                + "valor_receita DECIMAL(10, 2) NOT NULL, "
                + "CONSTRAINT fk_usuario_receita FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) "
                + ");";
        

		statement.execute(createTableusuarios);
		statement.execute(createTabledespesas);
		statement.execute(createTableusreceitas);

        System.out.println("Tabelas criada com sucesso!");
        statement.close();
        conexaoBanco.close();

    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }

}

}



