package br.com.ale.Import.V2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInsertPreparer {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(); 
		
		fr.read(FolderName.PROCESSING, new ConfigurationReader());
		
		InsertPreparer prep = new InsertPreparer(fr);
		
		System.out.println(prep.getColunNames().getClass());
		
		System.out.println(prep.getColunContent().size());
		
		System.out.println(prep.getColunNames());
		
	}
	
}
