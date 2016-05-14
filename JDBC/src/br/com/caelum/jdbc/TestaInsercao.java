package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionPool().getConnection()) {
		connection.setAutoCommit(false);
		String sql = "insert into Produto (nome, descricao) values (?,?)";

		try (PreparedStatement prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


			String nome = "Pen Drive";
			String descricao = "Kingston's 8 gb";

			adiciona(prepareStatement, "tv lcd", "32 polegadas");
			adiciona(prepareStatement, "Blueray", "Full HDMI");
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("rollback efetuado");
		}

		}
	}

	private static void adiciona(PreparedStatement prepareStatement, String nome, String descricao) throws SQLException {

		if (nome.equals("Blueray")) {
			throw new IllegalArgumentException("Problema ocorrido");
		}

		prepareStatement.setString(1, nome);
		prepareStatement.setString(2, descricao);

		boolean resultado = prepareStatement.execute();

		System.out.println(resultado);

		ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

		while (generatedKeys.next()) {
			String id = generatedKeys.getString("id");
			System.out.println(id);

		}
		generatedKeys.close();
	}

}
