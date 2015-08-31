package br.com.ale.Import.V2;

import java.io.File;

/**
 * Classe responsável por ler as configurações de diretórios 
 * @author ale
 *
 */

//Talvez a interface GetFolder seja desnecessária para este caso já que os métodos implementados também parecem não ter mais função.

//Alterar o nome da classe?



public class Folders2 implements GetFolder {

	String folder;

	String path;

	private String createFolder;

	private String subPath;

	//Alterar esse if e substituir por uma chamada ao configuration reader
	
	{
		// Inicializar a variavel folder com o valor padrão caso não exista um
		// valor descrito no arquivo

		path = ConfigurationReader.getDefaultPathLocation();
		folder = ConfigurationReader.getDefaultPathBaseName();

	}






	private void setDefaultPathLocation(String path) {
		this.path = path;
	}

	private void setFolderBaseName(String folder) {
		this.folder = folder;
	}

	
	//Talvez os métodos abaixo sejam desnecessário já que o Enum FolderName já retorna as mesmas informações...
	
	@Override
	public String getFOLDERIN() {
		return FolderName.IN.getFolder();
	}

	@Override
	public String getFOLDEROUT() {

		return FolderName.OUT.getFolder();
	}

	@Override
	public String getFOLDERERROR() {
		return FolderName.ERROR.getFolder();
	}

	@Override
	public String getFOLDERPROSSESING() {
		return FolderName.PROCESSING.getFolder();
	}

	@Override
	public String getFOLDERDEFAULT() {
		return FolderName.DEFAULT.getFolder();
	}

}
