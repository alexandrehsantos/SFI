package br.com.ale.sfi.dao.factory;

import br.com.ale.sfi.dao.SalaryDAO;
import br.com.ale.sfi.dao.impl.SalaryDAOImpl;

public class DaoFactory {
	
	private static DaoFactory daoFactory;
	private static SalaryDAO salaryDAO;

	private DaoFactory() {

	}

	public SalaryDAO getSalaryDao() {

		if (salaryDAO == null) {
			salaryDAO = new SalaryDAOImpl();
		}

		return salaryDAO;
	}

	public static DaoFactory getInstance() {

		if (daoFactory == null) {
			daoFactory = new DaoFactory();
		}

		return daoFactory;
	}
}
