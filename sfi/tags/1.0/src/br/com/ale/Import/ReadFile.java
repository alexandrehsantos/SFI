package br.com.ale.Import;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {

	protected String csvFile;
	protected String delimiter;
	protected int colunas;
	protected HashMap<String, String> hashMap = new HashMap<String, String>();

	ReadFile(String csvFile, String delimiter, int colunas) {
		this.csvFile = csvFile;
		this.delimiter = delimiter;
		this.colunas = colunas;
	}

	public Map run() throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(csvFile));
		scanner.useDelimiter(delimiter);
		int i = 0;
		int j = 0;
		int x = colunas;

		String[] colName = new String[colunas];

		//System.out.println(colName.length);

		while (scanner.hasNext()) {
			// System.out.println(i);
			String colContent = scanner.next();

			if (i < colunas) {
				colName[i] = colContent;
			} else {

				hashMap.put(colName[j].trim(), colContent);

				//System.out.print("[" + colName[j].trim() + "]");
				//System.out.println(colContent);

				if (j == (x - 1)) {
					j = 0;
				} else {
					j++;
				}

			}

			i++;

		}
		scanner.close();
		return hashMap;
	}

}
