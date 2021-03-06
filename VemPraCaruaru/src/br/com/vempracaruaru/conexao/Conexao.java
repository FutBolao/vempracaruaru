package br.com.vempracaruaru.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexao {

	public static Connection connection;

	//m�todo de conex�o.
	public static Connection getConexao(int sistema) throws Exception {
		if (connection == null) {
			try {
				InitialContext context = new InitialContext();
				DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/vempracaruaru");
				connection = ds.getConnection();
				System.out.println("conectou");
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return connection;
		}
//		String driverName = "com.mysql.jdbc.Driver";                        
//		Class.forName(driverName);
//		String conexao = "";
//    	String usuario = "";
//    	String senha = "";
//    	
//    	//condi��es para selecionar o tipo de banco.
//    	if (sistema == DataBase.MYSQL) {
//    		conexao = "jdbc:mysql://vempracaruaru.com.br:3306/vempraca_bd";
//    		usuario = "vempraca_user";
//    		senha = "fivetech";
//    	}else if (sistema == DataBase.SQLSERVER) {
//    		conexao = "jdbc:sqlserver://localhost:1433;databaseName=aula08";
//    		usuario = "root";
//    		senha = "root";
//    	}else if (sistema == DataBase.ORACLE) {
//    		conexao = "jdbc:oracle:thin:@localhost:8080:XE";
//    		usuario = "root";
//    		senha = "root";
//    	}else if (sistema == DataBase.POSTGRESQL) {
//    		conexao = "jdbc:postgresql://totvs11:5432/aula08";
//    		usuario = "postgres";
//    		senha = "root";
//    	}else {
//    		throw new IllegalArgumentException("Tipo de banco n�o suportado");
//    	}
//    	//se n�o houver uma conex�o, fa�o uma.
//    	if (connection == null) {
//            try {
//            	connection = DriverManager.getConnection(conexao, usuario, senha);
//	    	} catch(SQLException e) {
//	    		throw new Exception("SQLException => ConnectionManager: " + e.getMessage());
//	    	}
//        }
//    	return connection;
	}
	//met�do para fechar a conex�o.
	public static void close() throws Exception {
    	connection.close();
    }
}