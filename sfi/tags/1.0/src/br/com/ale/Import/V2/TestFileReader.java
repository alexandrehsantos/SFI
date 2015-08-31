package br.com.ale.Import.V2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileReader {

	public static void main(String[] args) throws IOException {

		// Pegando as configurações

		ConfigurationReader config = new ConfigurationReader();

		FileReader fr = new FileReader();

		fr.read(FolderName.IN, config);
		for (String s : fr.fileInList) {
			System.out.println(s);
		}

	}

}
