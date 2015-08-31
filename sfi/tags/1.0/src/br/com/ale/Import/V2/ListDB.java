package br.com.ale.Import.V2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class ListDB {
	

	void getResult(Connection c) throws SQLException {

		Statement statement = c.createStatement();

		boolean resultado = statement.execute("select * from Schools");

		ResultSet resultset = statement.getResultSet();

		while (resultset.next()) {

			System.out.println(resultset.getString("schoolID"));
			System.out.println(resultset.getString("name"));
			System.out.println(resultset.getString("city"));
			System.out.println(resultset.getString("state"));
			System.out.println(resultset.getString("country"));
		}

	}

}
