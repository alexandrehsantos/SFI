package br.com.ale.sfi.utils;

import java.io.File;

import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

	private static FileUtil fileUtil;

	private FileUtil() {

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
