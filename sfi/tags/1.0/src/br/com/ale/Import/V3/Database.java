package br.com.ale.Import.V3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/PraticaEmJava", "root", "123456");
		return connection;

	}

}
