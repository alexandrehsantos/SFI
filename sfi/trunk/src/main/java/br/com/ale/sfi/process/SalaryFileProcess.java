package br.com.ale.sfi.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.dao.SalaryDAO;
import br.com.ale.sfi.dao.factory.DaoFactory;
import br.com.ale.sfi.exception.SFIException;
import br.com.ale.sfi.utils.FileUtil;
import br.com.ale.sfi.vo.SalaryVO;

public class SalaryFileProcess {
	
	private static final Logger LOGGER = Logger.getLogger(SalaryFileProcess.class);
	
	private DaoFactory daoFactory = DaoFactory.getInstance();
	private FileUtil fileUtil = FileUtil.getInstance();
	private Config config = Config.getInstance();

	public SalaryFileProcess() {

	}

	public void process(File salaryFile) {
		
		SalaryDAO salaryDao = daoFactory.getSalaryDao();
		List<SalaryVO> salaryList = new ArrayList<SalaryVO>();
		String line = null;
		int count = 0;
		try {
			FileReader fileReader = new FileReader(salaryFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
				while ((line = bufferedReader.readLine()) != null) {
					++count;
					salaryList.add(convert(line, count));
					if(salaryList.size() == config.getBachSize()){
						salaryDao.insert(salaryList);	
						salaryList = new ArrayList<SalaryVO>();
					}
				}
				if(!salaryList.isEmpty()){
					salaryDao.insert(salaryList);
				}
				
				fileUtil.move(salaryFile, config.getFilePathDone());
				fileUtil.renameFile(salaryFile, config.getFilePathDone());
				
			} finally {
				fileReader.close();
				bufferedReader.close();
			}
		} catch (Exception e) {
			String errorMsg = "Erro ao ler arquivo: "+ salaryFile.getAbsolutePath();
			LOGGER.error(errorMsg, e);
			fileUtil.move(salaryFile, config.getFilePathError());
			throw new SFIException(errorMsg, e);	
		}
	}

	
	
	public SalaryVO convert(String line, int lineNumber) throws Exception {

		String[] split = line.split(",");
		SalaryVO salaryVO = new SalaryVO();
		int index = 0;
		try {
			salaryVO.setYearId(split[index++]);
			salaryVO.setTeamId(split[index++]);
			salaryVO.setLgId(split[index++]);
			salaryVO.setPlayerId(split[index++]);
			salaryVO.setSalary(split[index++]);
		} catch (Exception e) {
			String errorMsg = "Erro ao converter dados da linha" + lineNumber + "no campo: " + (--index);
			LOGGER.error(errorMsg);
			throw new SFIException(errorMsg,e);
		}

		return salaryVO;
	}

}
	