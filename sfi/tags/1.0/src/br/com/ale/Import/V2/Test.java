package br.com.ale.Import.V2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ale.Import.Database;

public class Test {

	static String fileName = "Salaries.csv";
	static FileMover file;
	static String delimiter = ",";

	public static void main(String[] args) throws SQLException, IOException {

		// delimitadores testados:
		// ,\\n
		// [,\n]

		
		
		ConfigurationReader configurationReader = new ConfigurationReader();


		FileReader read = new FileReader(getFullFileName(),delimiter, 5);

		InsertPreparer prep = new InsertPreparer(read);

		TablePreparer tb = new TablePreparer(Database.getConnection(), read,
				prep);
		tb.extractTableName();
		tb.buildInsert();
		System.out.println(tb.getTableName());

	}
	
	static String getFullFileName() throws IOException{
		
		
		
		file = new FileMover();
		
		return file.getFOLDERIN() + "/" + ConfigurationReader.getCsvName();
		
	}
}
