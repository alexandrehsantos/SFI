package br.com.ale.sfi.command;

import java.io.File;
import java.util.List;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.process.SalaryFileProcess;
import br.com.ale.sfi.utils.FileUtil;

public class LoadFileCommand implements Command {

	private static final String FILE_EXTENSION = "csv";
	
	private Config config = Config.getInstance();
	private FileUtil fileUtil = FileUtil.getInstance();

	public void execute(List<String> listArgs) {

		if (fileUtil.existsFiles(config.getFilePathWork(), FILE_EXTENSION)) {
			System.out.println("Existem arquivos no diretorio work.");
			return;
		}

		List<File> listFilesIn = fileUtil.listFiles(config.getFilePathIn(), FILE_EXTENSION);
		if (!listFilesIn.isEmpty()) {
			for (File file : listFilesIn) {
				fileUtil.move(file, config.getFilePathWork());
			}
		} else {
			System.out.println("Nao existem arquivos para serem processados.");
			return;
		}

		List<File> filesWork = fileUtil.listFiles(config.getFilePathWork(), FILE_EXTENSION);
		
		SalaryFileProcess salaryFileProcess = new SalaryFileProcess();

		for (File file : filesWork) {
			
			salaryFileProcess.process(file);
		}
		
	}
}
