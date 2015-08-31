package br.com.ale.Import.V2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

//	protected String csvFile;
//	protected String delimiter;
//	protected int numberColuns;

	static ArrayList<String> fileInList = new ArrayList<String>();

	FileReader(/* FolderName in, String csvFile, String delimiter , int colunas */) {
		// throws FileNotFoundException {
		// // this.csvFile = csvFile;
		// // this.delimiter = "["+ delimiter +"\n]";
		// //// this.numberColuns = colunas;
		// this.read();
	}

	public ArrayList read (FolderName folderProcessing, ConfigurationReader config)
			throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(folderProcessing.getFolder().toString()
				+ config.getCsvName().toString()));

//		scanner.useDelimiter(config.getCsvDelimiter());
		scanner.useDelimiter("["+ config.getCsvDelimiter()+"\n]");

		while (scanner.hasNext()) {
//			int i = 0;
			fileInList.add(scanner.nextLine());
			// System.out.println(fileInList.get(i));
//			i++;
		}

		scanner.close();

		return fileInList;

	}
}
