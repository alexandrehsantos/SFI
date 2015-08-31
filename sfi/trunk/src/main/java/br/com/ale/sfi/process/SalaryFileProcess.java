package br.com.ale.sfi.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import br.com.ale.sfi.dao.SalaryDAO;
import br.com.ale.sfi.dao.impl.SalaryDAOImpl;
import br.com.ale.sfi.exception.SFIException;
import br.com.ale.sfi.vo.SalaryVO;

public class SalaryFileProcess {

	private SalaryDAO salaryDAO = new SalaryDAOImpl();

	public SalaryFileProcess() {

	}

	public void process(File salaryFile) {
		List<SalaryVO> salaryList = new ArrayList<SalaryVO>();
		String line = null;
		try {
			FileReader fileReader = new FileReader(salaryFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
				while ((line = bufferedReader.readLine()) != null) {
					salaryList.add(convert(line));
					if(salaryList.size() == 500){
						salaryDAO.insert(salaryList);
						salaryList = new ArrayList<SalaryVO>();
					}
				}
				if(!salaryList.isEmpty()){
					salaryDAO.insert(salaryList);
				}
			} finally {
				fileReader.close();
				bufferedReader.close();
			}
		} catch (Exception e) {
			throw new SFIException("Erro ao ler arquivo: "+ salaryFile.getAbsolutePath(), e);
		}
	}

	public SalaryVO convert(String line) {

		String[] split = line.split(",");
		SalaryVO salaryVO = new SalaryVO();
		int index = 0;

		salaryVO.setYearId(split[index++]);
		salaryVO.setTeamId(split[index++]);
		salaryVO.setLgId(split[index++]);
		salaryVO.setPlayerId(split[index++]);
		salaryVO.setSalary(split[index++]);

		return salaryVO;
	}

}
