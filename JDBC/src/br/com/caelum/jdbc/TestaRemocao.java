package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionPool().getConnection();

			Statement createStatement = connection.createStatement();
			
			createStatement.execute("delete from Produto where id> 3");
			
			int updateCount = createStatement.getUpdateCount();
			System.out.println(updateCount + " linhas atualizadas");
						
		   createStatement.close();
		   connection.close();
			
			
	
	}
	
}
