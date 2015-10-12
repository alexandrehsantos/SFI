package br.com.ale.sfi.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.exception.SFIException;

public class FileUtil {

	private static final Logger LOGGER = Logger.getLogger(FileUtil.class);

	private static FileUtil fileUtil;

	private FileUtil() {

	}

	public void move(File srcFile, String destFolder) {

		File destFile = new File(destFolder, srcFile.getName());
		if (destFile.exists()) {
			String errorMsg = "O arquivo: " + destFile.getAbsolutePath() + " ja existe  no local de destino";
			LOGGER.error(errorMsg);
			throw new SFIException(errorMsg);
		}

		if (srcFile.exists()) {
			if (!srcFile.renameTo(destFile)) {
				String errorMSg = "O arquivo: " + srcFile.getAbsolutePath() + " nao pode ser movido para " + destFolder;
				LOGGER.error(errorMSg);
				throw new SFIException(errorMSg);
			}
		} else {
			String errorMsg = "O arquivo: " + srcFile.getAbsolutePath() + " nao existe  no local de origem";
			LOGGER.error(errorMsg);
			throw new SFIException(errorMsg);
		}
	}

	public Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(fileName));
			return properties;
		} catch (IOException e) {
			String errorMsg = "Erro ao carregar arquivo: " + fileName;
			LOGGER.error(errorMsg,e);
			throw new SFIException(errorMsg, e);
		}
	}

	public boolean existsFiles(String dir, final String extension) {
		File[] files = new File(dir).listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().endsWith(extension) ? true : false;

			}
		});
		return files != null ? (files.length > 0) : false;

	}

	public static FileUtil getInstance() {
		if (fileUtil == null) {
			fileUtil = new FileUtil();
		}
		return fileUtil;
	}

	@SuppressWarnings("unchecked")
	public List<File> listFiles(String dir, final String extension) {

		File[] files = new File(dir).listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().endsWith(extension) ? true : false;

			}
		});

		return files != null ? Arrays.asList(files) : Collections.EMPTY_LIST;
	}

}
