package br.com.ale.Import.V2;

import java.io.File;
import java.io.IOException;

/**
 * Classe responsável por mover os arquivos de diretórios
 * 
 * @author ale
 *
 */

class FileMover {

	/**
	 * A princípio o parâmetro file é fornecido pela o arquivo de configuração,
	 * mas a intenção é de que o parâmetro seja fornecido por um método em uma
	 * classe file que faça um loop no diretório.
	 * 
	 * @param source
	 * @param destination
	 * @param file
	 * @throws IOException 
	 */

	public void moveToNew(FolderName source, FolderName destination,
			String file) throws IOException {

		String s = source.getFolder() + file;// Path
															// origem
		String d = destination.getFolder() + file; // Path
																	// destino

		if(new File(s).exists()){
			File toMove = new File(s);
			toMove.renameTo(new File(d));
		}else{
			throw new IOException("Arquivo não encontrado no diretorio de origem");
		}

	}

}
