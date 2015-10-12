package br.com.ale.sfi.command;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.exception.SFIException;
import br.com.ale.sfi.process.SalaryFileProcess;
import br.com.ale.sfi.utils.FileUtil;

public class LoadFileCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(LoadFileCommand.class);
	
	private static final String FILE_EXTENSION = "csv";
	
	private Config config = Config.getInstance();
	private FileUtil fileUtil = FileUtil.getInstance();

	public void execute(List<String> listArgs) {

		LOGGER.info("Checando existencia de arquivos no diretorio " + config.getFilePathWork());
		if (fileUtil.existsFiles(config.getFilePathWork(), FILE_EXTENSION)) {
			String message = "Existem arquivos no diretorio work.";
			LOGGER.error(message);
			throw new SFIException(message);
		}

		LOGGER.info("Checando arquivos a serem processados no diretorio " + config.getFilePathIn());
		List<File> listFilesIn = fileUtil.listFiles(config.getFilePathIn(), FILE_EXTENSION);
		if (!listFilesIn.isEmpty()) {
			LOGGER.info("Movendo arquivos do diretorio: " + config.getFilePathIn() + "para diretorio: " + config.getFilePathWork());
			for (File file : listFilesIn) {
				fileUtil.move(file, config.getFilePathWork());
			}
		} else {
			LOGGER.info("Nao existem arquivos para serem processados.");
			return;
		}

		List<File> filesWork = fileUtil.listFiles(config.getFilePathWork(), FILE_EXTENSION);
		
		SalaryFileProcess salaryFileProcess = new SalaryFileProcess();

		for (File file : filesWork) {
			LOGGER.debug("Processando arquivo " + file.getAbsolutePath());
			salaryFileProcess.process(file);
		}
		
	}
}
