package br.com.ale.sfi.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.exception.SFIException;

public class FileUtil {

	private static FileUtil fileUtil;

	private FileUtil() {

	}

	public void move(File srcFile, String destFolder) {

		File destFile = new File(destFolder, srcFile.getName());
		if (destFile.exists()) {
			throw new SFIException("O arquivo: " + destFile.getAbsolutePath() + " ja existe  no local de destino");
		}

		if (srcFile.exists()) {
			if (!srcFile.renameTo(destFile)) {
				throw new SFIException(
						"O arquivo: " + srcFile.getAbsolutePath() + " nao pode ser movido para " + destFolder);
			}
		} else {
			throw new SFIException("O arquivo: " + srcFile.getAbsolutePath() + " nao existe  no local de origem");
		}
	}

	public Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(Config.class.getClassLoader().getResourceAsStream(fileName));
			return properties;
		} catch (IOException e) {
			throw new SFIException("Erro ao carregar arquivo: " + fileName, e);
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
