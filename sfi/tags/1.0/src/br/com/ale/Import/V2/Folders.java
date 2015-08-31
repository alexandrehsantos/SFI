package br.com.ale.Import.V2;

import java.io.File;
import java.io.IOException;

public class Folders implements GetFolder {

	enum FolderName {
		DEFAULT("/"), IN(
				FolderName.DEFAULT + "/in/"), OUT(FolderName.DEFAULT + "/out/"), ERROR(
				FolderName.DEFAULT + "/error/"), PROCESSING(FolderName.DEFAULT
				+ "/processing/");

		private final String folder;

		FolderName(String valorOpcao) {
			folder = valorOpcao;
		}

		public String getFolder() {
			return folder;
		}

	}

	private String folder;

	private String path;

	private String createFolder;

	private String subPath;

	{
		// Inicializa a variavel folder com o valor padrão caso não exista um
		// valor descrito no arquivo

		if (ConfigurationReader.getDefaultPathBaseName().length() == 0) {

			setFolderBaseName("CsvLoad"); // Inicializa variável com o valor
											// padrão.

		} else {
			setFolderBaseName(ConfigurationReader.getDefaultPathBaseName()); // Inicializa
																				// variável
																				// com
																				// o
																				// valor
																				// do
																				// arquivo.
		}

		// Inicializa a variavel path com o valor padrão caso não exista um
		// valor descrito no arquivo

		if (ConfigurationReader.getDefaultPathLocation().length() == 0) {

			path = new File(System.getProperty("user.home")).toString(); // Inicializa
																			// variável
																			// com
																			// o
																			// valor
																			// padrão.

		} else {

			setDefaultPathLocation(ConfigurationReader.getDefaultPathLocation()); // Inicializa
																					// variável
																					// com
																					// o
																					// valor
																					// do
																					// arquivo.
		}

		// Inicializa variáveis crea
//		this.createFolder = FolderName.DEFAULT.getFolder();
		// this.subPath = createFolder.toString() + "/";

	}

	public static void main(String[] args) {
		new Folders().getFOLDERDEFAULT();
	}

	public Folders() {
		// try {
		// this.createDirectory(FolderName.DEFAULT);
		// this.createDirectory(FolderName.IN);
		// this.createDirectory(FolderName.PROCESSING);
		// this.createDirectory(FolderName.ERROR);
		// this.createDirectory(FolderName.OUT);
		// } catch (IOException e) {
		// e.getMessage();
		// }
	}

	public void createDirectory(FolderName f) throws IOException {

		// if (!new File(createFolder + f.getFolder()).exists()) {
		// new File(createFolder + f.getFolder()).mkdir();
		// }

	}

	private void setDefaultPathLocation(String path) {
		this.path = path;
	}

	private void setFolderBaseName(String folder) {
		this.folder = folder;
	}

	@Override
	public String getFOLDERIN() {
		return FolderName.IN.getFolder();
	}

	@Override
	public String getFOLDEROUT() {

		return path;
	}

	@Override
	public String getFOLDERERROR() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFOLDERPROSSESING() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFOLDERDEFAULT() {
		return getFOLDERDEFAULT();
	}

}
