package br.com.ale.sfi.config;
import java.util.Properties;
import br.com.ale.sfi.utils.FileUtil;

public class Config {

	private static final String CONFIG_PROPERTIES = "config.properties";
	private static Properties properties;
	private static Config config;

	private Config() {
		FileUtil fileUtil = FileUtil.getInstance();
		properties = fileUtil.loadProperties(CONFIG_PROPERTIES);
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

	public int getBachSize() {
		return Integer.parseInt(properties.getProperty("batch.size"));
	}

}
