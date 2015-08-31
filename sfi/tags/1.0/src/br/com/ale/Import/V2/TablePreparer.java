package br.com.ale.Import.V2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.DatabaseMetaData;

public class TablePreparer {

	private String tableName;

	// private ConfigurationReader config;

	private InsertPreparer insertPrepared;

	// Connection connection;

	public TablePreparer(InsertPreparer insertPreparer) throws SQLException, IOException {
		// this.connection = c;
		// this.config = config;
		this.insertPrepared = insertPreparer;

		
		this.extractTableName();
		
		this.buildInsert();

		
		// Usa o nome do arquivo como nome de tabela destino... Tem que mudar é
		// melhor usar arquivo+data...

	}

	public String getTableName() {
		return tableName;
	}

	private void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void extractTableName() {
		int indexFolder = 0;
		int indexDot = 0;
		String s = ConfigurationReader.getCsvName();

		indexFolder = s.lastIndexOf("/");
		indexDot = s.lastIndexOf(".");

		setTableName(s.substring(indexFolder + 1, indexDot));
	}

	private boolean checkTable() throws SQLException, FileNotFoundException {

		DatabaseMetaData md = (DatabaseMetaData) Database.getConnection()
				.getMetaData();

		ResultSet rs = md.getTables(null, null, "%", null);

		ArrayList<String> tabelas = new ArrayList<String>();

		while (rs.next()) {
			tabelas.add(rs.getString(3));
		}
		if (tabelas.contains(tableName)) {
			return true;
		} else {
			return false;
		}

	}

	public void buildInsert() throws SQLException, IOException {

		if (this.checkTable()) {

			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();

			for (String s : insertPrepared.getListOfColunContent()) {

				// System.out.println("INSERT INTO " + this.tableName + " "
				// + this.insertPreparer.listOfColunNames.toString()
				// + "VALUES " + s + ";");

				boolean resultado = statement.execute("INSERT INTO "
						+ this.tableName + " "
						+ this.insertPrepared.getListOfColunNames().toString()
						+ "VALUES " + s + ";");

				// if (!resultado) {
				// throw new SQLException("Erro ao inserir linhas na tabela"
				// + this.tableName);
				// }

			}

			statement.close();
			connection.close();

		} else {
			new FileMover().moveToNew(FolderName.PROCESSING, FolderName.ERROR,
					ConfigurationReader.getCsvName());
			throw new SQLException("A tabela informada não existe no banco");
		}
	}
}
