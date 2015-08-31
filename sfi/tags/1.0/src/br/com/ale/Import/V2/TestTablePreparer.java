package br.com.ale.Import.V2;

import java.io.IOException;
import java.sql.SQLException;

public class TestTablePreparer {

	public static void main(String[] args) throws SQLException, IOException {

		FileReader read = new FileReader();

		read.read(FolderName.PROCESSING, new ConfigurationReader());

		System.out.println(read.fileInList.size());

		InsertPreparer insertPreparer = new InsertPreparer(read);

		TablePreparer tp = new TablePreparer(insertPreparer);

		
	
	}

}
