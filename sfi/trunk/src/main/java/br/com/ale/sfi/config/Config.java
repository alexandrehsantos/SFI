package br.com.ale.sfi.config;

import java.io.IOException;
import java.util.Properties;

import br.com.ale.sfi.exception.SFIException;

public class Config {

	private static final String CONFIG_PROPERTIES = "config.properties";
	private static Properties properties;

	public Config() {

		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Config.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
			} catch (IOException e) {
				throw new SFIException("Erro ao carregar arquivo: " + CONFIG_PROPERTIES, e);
			}
		}

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

}
