package br.com.ale.Import.V3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader  {

	protected String csvFile;
	protected String delimiter;
	protected int numberColuns;

	static ArrayList<String> fileInList = new ArrayList<String>();

	public FileReader() {

	}

	FileReader(String csvFile, String delimiter, int colunas)
			throws FileNotFoundException {
		this.csvFile = csvFile;
		this.delimiter = delimiter;
		this.numberColuns = colunas;
		this.read();
	}

	public ArrayList read() throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(csvFile));
		scanner.useDelimiter(delimiter);

		while (scanner.hasNext()) {
		int i = 0;
			fileInList.add(scanner.nextLine());
			System.out.println(fileInList.get(i));
		i++;	
		}
		
		

		scanner.close();

		return fileInList;

	}
}
