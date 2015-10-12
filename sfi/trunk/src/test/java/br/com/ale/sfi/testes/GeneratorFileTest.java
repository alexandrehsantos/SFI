package br.com.ale.sfi.testes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import br.com.ale.sfi.exception.SFIException;

public class GeneratorFileTest {

	private static final int QTE_LINES = 1000 * 7;
	private File file;

	@Before
	public void init() {
		file = new File("/opt/sfi/files/in", "Salary.csv");
	}

	@Test
	public void generete() {

		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			try {

				for (int i = 0; i < QTE_LINES; i++) {

					bufferedWriter.write("yearId-" + i + "," + "teamId-" + i
							+ "," + "lgId-" + i + "," + "playerId-" + i + ","
							+ "salary-" + i);
					bufferedWriter.newLine();
					bufferedWriter.flush();
				}

			} finally {
				bufferedWriter.close();
			}

		} catch (IOException e) {
			throw new SFIException("Erro ao gerar aquivo de teste", e);
		}

	}

}
