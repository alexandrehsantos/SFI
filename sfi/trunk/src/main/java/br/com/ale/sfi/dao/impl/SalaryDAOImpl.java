package br.com.ale.sfi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.ale.sfi.dao.SalaryDAO;
import br.com.ale.sfi.dao.factory.ConnectionFactory;
import br.com.ale.sfi.exception.SFIException;
import br.com.ale.sfi.vo.SalaryVO;

public class SalaryDAOImpl implements SalaryDAO {

	private ConnectionFactory factory = ConnectionFactory.getInstance();

	public void insert(List<SalaryVO> salaryList) {

		Connection connection = factory.getConnection();

		String sql = "insert into Salary (id,yearId,teamId,lgId,playerId,salary, inclusionDate) values (sfi_seq.nextval,?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			for (SalaryVO salaryVO : salaryList) {
				prepareStatement.setString(1, salaryVO.getYearId());
				prepareStatement.setString(2, salaryVO.getTeamId());
				prepareStatement.setString(3, salaryVO.getLgId());
				prepareStatement.setString(4, salaryVO.getPlayerId());
				prepareStatement.setString(5, salaryVO.getSalary());
				java.util.Date date = new java.util.Date();
				prepareStatement.setDate(6, new java.sql.Date(date.getTime()));
				prepareStatement.addBatch();
			}
			prepareStatement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			throw new SFIException("Erro ao inserir no banco de dados", e);

		}
	}
}
