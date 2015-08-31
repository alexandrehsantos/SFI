package br.com.ale.Import.V2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class ConfigurationReader {

	static GetFolder folder;

	// Database Configuration
	protected static String DatabaseAdress;
	protected static String DatabaseName;
	protected static String DatabaseUser;
	protected static String DatabasePassword;

	// Path Configuration
	protected static String DefaultPathLocation;
	protected static String DefaultPathBaseName;

	// FileConfiguration
	protected static String CsvName;
	protected static String CsvDelimiter;

	private static final String CONFIGFILE = new File(
			System.getProperty("user.home")).toString()
			+ "/SuperImporter/config.xml";

	 static {
	 try {
		 setVariables();
	 
	 
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 }

	public ConfigurationReader() throws IOException {

	}

	/**
	 * Método que retorna a localização do arquivo de configuração
	 * 
	 * @return
	 */

	public static File getConfigurationFile() throws FileNotFoundException {

		 if (new File(CONFIGFILE).exists()) {
		 return new File(CONFIGFILE);
		 } else {
		 throw new FileNotFoundException(
		 "Arquivo de configuração não encontrado em: " + CONFIGFILE);
		 }

	}

	/**
	 * Método responsável por carregar o valor das configurações para as
	 * variáveis.
	 * 
	 * @throws IOException
	 */
	static void setVariables() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(getConfigurationFile());
		props.loadFromXML(fis);
		
		

//		// Set Database Configuration
		setDatabaseAdress(props.getProperty("DatabaseAdress"));
		setDatabaseName(props.getProperty("DatabaseName"));
		setDatabaseUser(props.getProperty("DatabaseUser"));
		setDatabasePassword(props.getProperty("DatabasePassword"));
//
//		// Path Configuration

		if ((props.getProperty("DefaultPathLocation")).length() == 0) {
			setDefaultPathLocation(new File(System.getProperty("user.home")).toString());
		} else {
			setDefaultPathLocation(props.getProperty("DefaultPathLocation"));
		}

		if (props.getProperty("DefaultPathBaseName").length() == 0) {
			setDefaultPathBaseName("CsvLoad");
		} else {
			setDefaultPathBaseName(props.getProperty("DefaultPathBaseName"));
		}

//		// FileConfiguration
		setCsvName(props.getProperty("CsvName"));
		setCsvDelimiter(props.getProperty("CsvDelimiter"));

	}

	public static String getDatabaseAdress() {
		return DatabaseAdress;
	}

	public static void setDatabaseAdress(String databaseAdress) {
		DatabaseAdress = databaseAdress;
	}

	public static String getDatabaseName() {
		return DatabaseName;
	}

	public static void setDatabaseName(String databaseName) {
		DatabaseName = databaseName;
	}

	public static String getDatabaseUser() {
		return DatabaseUser;
	}

	public static void setDatabaseUser(String databaseUser) {
		DatabaseUser = databaseUser;
	}

	public static String getDatabasePassword() {
		return DatabasePassword;
	}

	public static void setDatabasePassword(String databasePassword) {
		DatabasePassword = databasePassword;
	}

	public static String getDefaultPathLocation() {
		return DefaultPathLocation;
	}

	public static void setDefaultPathLocation(String defaultPathLocation) {
		DefaultPathLocation = defaultPathLocation;
	}

	public static String getDefaultPathBaseName() {
		return DefaultPathBaseName;
	}

	public static void setDefaultPathBaseName(String defaultPathBaseName) {
		DefaultPathBaseName = defaultPathBaseName;
	}

	public static String getCsvName() {
		return CsvName;
	}

	public static void setCsvName(String csvName) {
		CsvName = csvName;
	}

	public static String getCsvDelimiter() {
		return CsvDelimiter;
	}

	public static void setCsvDelimiter(String csvDelimiter) {
		CsvDelimiter = csvDelimiter;
	}

}
