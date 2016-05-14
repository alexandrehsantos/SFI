package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionPool().getConnection();
		Statement createStatement = connection.createStatement();
		boolean resultado = createStatement.execute("select * from produto");
		ResultSet resultSet = createStatement.getResultSet();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
			
		}

		resultSet.close();
		createStatement.close();

	}


}
