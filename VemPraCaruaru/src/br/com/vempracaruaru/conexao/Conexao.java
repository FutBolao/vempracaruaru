package br.com.vempracaruaru.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection connection;

	//método de conexão.
	public static Connection getConexao(int sistema) throws Exception {
		String conexao = "";
    	String usuario = "";
    	String senha = "";
    	
    	//condições para selecionar o tipo de banco.
    	if (sistema == DataBase.MYSQL) {
    		conexao = "jdbc:mysql://vempracaruaru.com.br:3306/vempraca_bd";
    		usuario = "vempraca_user";
    		senha = "fivetech";
    	}else if (sistema == DataBase.SQLSERVER) {
    		conexao = "jdbc:sqlserver://localhost:1433;databaseName=aula08";
    		usuario = "root";
    		senha = "root";
    	}else if (sistema == DataBase.ORACLE) {
    		conexao = "jdbc:oracle:thin:@localhost:8080:XE";
    		usuario = "root";
    		senha = "root";
    	}else if (sistema == DataBase.POSTGRESQL) {
    		conexao = "jdbc:postgresql://totvs11:5432/aula08";
    		usuario = "postgres";
    		senha = "root";
    	}else {
    		throw new IllegalArgumentException("Tipo de banco não suportado");
    	}
    	//se não houver uma conexão, faço uma.
    	if (connection == null) {
            try {
            	connection = DriverManager.getConnection(conexao, usuario, senha);
	    	} catch(SQLException e) {
	    		throw new Exception("SQLException => ConnectionManager: " + e.getMessage());
	    	}
        }
    	return connection;
	}
	//metódo para fechar a conexão.
	public static void close() throws Exception {
    	connection.close();
    }
}