package br.com.ale.Import;

import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		// delimitadores usados: ,\\n
		//
		ReadFile read = new ReadFile(
				"/home/ale/Documents/Home/Estudos/Java/Pratica/CSVs/Teams.csv",
				"[,\n]", 48);

		try {
			Map test = read.run();

			//System.out.println(test);

			Map test2 = read.hashMap;

			System.out.println(test2.get("teamIDretro"));
			
			
		} catch (FileNotFoundException e) {

			e.getStackTrace();

		}

	}

}
