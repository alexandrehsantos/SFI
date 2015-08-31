package br.com.ale.Import.V2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	static ConfigurationReader config;
	static private String databaseAdress;
	static private String databaseName;
	static private String databaseUserName;
	static private String databasePassword;
	
	static {
		
		Database.setDatabaseAdress(ConfigurationReader.getDatabaseAdress());
		Database.setDatabaseName(ConfigurationReader.getDatabaseName());
		Database.setDatabaseUserName(ConfigurationReader.getDatabaseUser());
		Database.setDatabasePassword(ConfigurationReader.getDatabasePassword());
		
	}


	public static Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://"
				+ getDatabaseAdress() + "/" + getDatabaseName(),
				getDatabaseUserName(), getDatabasePassword());
		return connection;

	}



	public static String getDatabaseAdress() {
		return databaseAdress;
	}

	public static void setDatabaseAdress(String databaseAdress) {
		Database.databaseAdress = databaseAdress;
	}

	public static String getDatabaseName() {
		return databaseName;
	}

	public static void setDatabaseName(String databaseName) {
		Database.databaseName = databaseName;
	}

	public static String getDatabasePassword() {
		return databasePassword;
	}

	public static void setDatabasePassword(String databasePassword) {
		Database.databasePassword = databasePassword;
	}

	public static String getDatabaseUserName() {
		return databaseUserName;
	}

	public static void setDatabaseUserName(String databaseUserName) {
		Database.databaseUserName = databaseUserName;
	}

}
