package br.com.ale.sfi.main;

import java.io.File;
import java.util.List;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.process.SalaryFileProcess;
import br.com.ale.sfi.utils.FileUtil;

public class Main {

	private static final String FILE_EXTENSION = "csv";

	public static void main(String[] args) {

		Config config = Config.getInstance();
		FileUtil fileUtil = FileUtil.getInstance();
		List<File> listFiles = fileUtil.listFiles(config.getFilePathIn(), FILE_EXTENSION);
		
		if(!listFiles.isEmpty()){
			File file = listFiles.get(0);
			SalaryFileProcess salaryFileProcess = new SalaryFileProcess();
			salaryFileProcess.process(file);
		}
		
		
		
	
	}

}
