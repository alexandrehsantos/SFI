package br.com.caelum.jdbc.modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionPool;

public class Teste {
	public static void main(String[] args) {
			Produto produto = new Produto("Mesa Azul","Mesa com 4 pes");
			try {
				Connection connection = new ConnectionPool().getConnection();
				String sql = "insert into Produto (nome, descricao) values (?,?)";
				connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
