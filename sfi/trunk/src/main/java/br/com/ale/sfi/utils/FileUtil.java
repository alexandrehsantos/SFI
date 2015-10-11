package br.com.ale.sfi.utils;

import java.io.File;

import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.exception.SFIException;

public class FileUtil {

	private static FileUtil fileUtil;

	private FileUtil() {

	}

	public Properties loadProperties(String fileName) {
		Properties properties = new Properties();
		try {
			properties.load(Config.class.getClassLoader().getResourceAsStream(fileName));
			return 	properties;
		} catch (IOException e) {
			throw new SFIException("Erro ao carregar arquivo: " + fileName, e);
		}
	}

	public static FileUtil getInstance() {
		if (fileUtil == null) {
			fileUtil = new FileUtil();
		}
		return fileUtil;
	}

	public List<File> listFiles(String dir, final String extension) {

		return Arrays.asList(new File(dir).listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().endsWith(extension) ? true : false;

			}
		}));

	}

}
