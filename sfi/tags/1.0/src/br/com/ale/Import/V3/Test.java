package br.com.ale.Import.V3;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ale.Import.Database;

public class Test {

	public static void main(String[] args) throws FileNotFoundException,
			SQLException {

		// delimitadores testados:
		// ,\\n
		// [,\n]

		FileReader read = new FileReader(
				"/home/ale/Documents/Home/Estudos/Java/Pratica/CSVs/Salaries.csv",
				"[,\n]", 5);

		InsertPreparer prep = new InsertPreparer(read);

		TablePreparer tb = new TablePreparer(Database.getConnection(), read,
				prep);
		tb.extractTableName();
		tb.buildInsert();
		System.out.println(tb.getTableName());

	}
}
