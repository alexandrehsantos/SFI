package br.com.ale.sfi.config;

import java.io.IOException;
import java.util.Properties;

import br.com.ale.sfi.exception.SFIException;

public class Config {

	private static final String CONFIG_PROPERTIES = "config.properties";
	private static Properties properties;
	private static Config config;

	private Config() {

		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Config.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
			} catch (IOException e) {
				throw new SFIException("Erro ao carregar arquivo: " + CONFIG_PROPERTIES, e);
			}
		}

	}

	public static Config getInstance() {
		if (config == null) {
			config = new Config();
		}
		return config;
	}

	public String getFilePathIn() {

		return properties.getProperty("sfi.file.path.in");

	}

	public String getFilePathWork() {

		return properties.getProperty("sfi.file.path.work");

	}

	public String getFilePathError() {

		return properties.getProperty("sfi.file.path.error");

	}

	public String getFilePathDone() {

		return properties.getProperty("sfi.file.path.done");

	}

	public String getDriverClass() {
		return properties.getProperty("driver.class");
	}

	public String getJDBCUrl() {

		return properties.getProperty("jdbc.url");
	}


	
	public String getUser() {

		return properties.getProperty("user.name");
	}

	public String getPassword() {

		return properties.getProperty("user.password");
	}

	public int getMinPollSize() {

		return Integer.parseInt(properties.getProperty("min.pool.size"));
	}

	public int getMaxPollSize() {

		return Integer.parseInt(properties.getProperty("max.pool.size"));
	}

	
}
