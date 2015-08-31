package br.com.ale.Import.V2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class SuperImporterCsv {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, SQLException {

		FileMover move = new FileMover();

		move.moveToNew(FolderName.IN, FolderName.PROCESSING,
				ConfigurationReader.getCsvName());

		try {
			
			FileReader read = new FileReader();
			
			//Le o arquivo 
			read.read(FolderName.PROCESSING, new ConfigurationReader());
			
			// Prepara o insert 
			InsertPreparer insertPreparer = new InsertPreparer(read);
			
			//Insert na tabela...
			TablePreparer tp = new TablePreparer(insertPreparer);
			
		} catch (Exception e) {
			move.moveToNew(FolderName.PROCESSING, FolderName.ERROR,
					ConfigurationReader.getCsvName());
		}

		move.moveToNew(FolderName.PROCESSING, FolderName.OUT, ConfigurationReader.getCsvName());

		System.out.println("Fim *-* - kkkkk");
	}
}
