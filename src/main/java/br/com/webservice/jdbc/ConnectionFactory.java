package br.com.webservice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/dengue";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
