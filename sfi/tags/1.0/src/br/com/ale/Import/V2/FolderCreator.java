package br.com.ale.Import.V2;

import java.io.File;
import java.io.IOException;

import br.com.ale.Import.V2.FolderName;

/**
 * Classe Responsável por criar diretórios utilizados pelo programa.
 * 
 * @author ale
 *
 */

public class FolderCreator {

	/**
	 * Construtor que realiza a função padrão da classe.
	 * 
	 * @throws Exception
	 */

	public FolderCreator() throws Exception {
		this.create(FolderName.DEFAULT);
		this.create(FolderName.IN);
		this.create(FolderName.PROCESSING);
		this.create(FolderName.ERROR);
		this.create(FolderName.OUT);
	}

	/**
	 * Método que recebe como paramentro o enum FolderName
	 * 
	 * @param f
	 * @throws IOException
	 */

	public void create(FolderName f) throws Exception {

		System.out.println(f.getFolder());

		File creator = new File(f.getFolder());

		if (!creator.exists()) {
			creator.mkdirs();
		}

	}

}
