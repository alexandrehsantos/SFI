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

		String sql = "insert into Salary (yearId,teamId,lgId,playerId,inclusionDate) values (?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			for (SalaryVO salaryVO : salaryList) {
				
				prepareStatement.setString(1, salaryVO.getYearId());
				prepareStatement.setString(2, salaryVO.getTeamId());
				prepareStatement.setString(3, salaryVO.getLgId());
				prepareStatement.setString(4, salaryVO.getPlayerId());
				prepareStatement.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
				prepareStatement.addBatch();
			}
				prepareStatement.executeBatch();
		} catch (SQLException e) {
			throw new SFIException("Erro ao inserir no banco de dados", e);

		}
	}
}
