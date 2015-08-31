package br.com.ale.Import.V2;

/**
 * enum Responsável por devolver opções de pastas disponíveis.
 * @author ale
 *
 */


// valor do diretório padrão deve ser dado pela classe Configuration reader. A mesma classe depende do Valor padrão das coisas

public enum FolderName {
	DEFAULT(ConfigurationReader.getDefaultPathLocation()+ "/" + ConfigurationReader.getDefaultPathBaseName() + "/"), IN(
			FolderName.DEFAULT.getFolder() + "in/"), OUT(FolderName.DEFAULT
			.getFolder() + "out/"), ERROR(FolderName.DEFAULT.getFolder()
			+ "error/"), PROCESSING(FolderName.DEFAULT.getFolder()
			+ "processing/");

	private final String folder;

	FolderName(String valorOpcao) {
		folder = valorOpcao;
	}

	public String getFolder() {
		return folder;
	}

}
