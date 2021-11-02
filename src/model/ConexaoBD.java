package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/inovup", "root", "");
			System.out.println("Conectado com sucesso!");
		}catch (ClassNotFoundException e) {
			System.err.println("Erro ao carregar o driver, verifique o arquivo mysql.jar em Java Build Path da IDE!");
			e.printStackTrace();
		}catch (SQLException e){
			System.err.println("Erro ao realizar conexão com o banco verifique a url de conexão!");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Erro ao fechar a conexão com o banco!");
			e.printStackTrace();
		}
	}
}
