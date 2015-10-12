package br.com.ale.sfi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.ale.sfi.dao.SalaryDAO;
import br.com.ale.sfi.dao.factory.ConnectionFactory;
import br.com.ale.sfi.exception.SFIException;
import br.com.ale.sfi.vo.SalaryVO;

public class SalaryDAOImpl implements SalaryDAO {

	private static final Logger LOGGER = Logger.getLogger(SalaryDAOImpl.class);
	private ConnectionFactory factory = ConnectionFactory.getInstance();

	public void insert(List<SalaryVO> salaryList) {

		Connection connection = factory.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into Salary (id,yearId,teamId,lgId,playerId,salary, inclusionDate) values (sfi_seq.nextval,?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			for (SalaryVO salaryVO : salaryList) {
				preparedStatement.setString(1, salaryVO.getYearId());
				preparedStatement.setString(2, salaryVO.getTeamId());
				preparedStatement.setString(3, salaryVO.getLgId());
				preparedStatement.setString(4, salaryVO.getPlayerId());
				preparedStatement.setString(5, salaryVO.getSalary());
				java.util.Date date = new java.util.Date();
				preparedStatement.setDate(6, new java.sql.Date(date.getTime()));
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			
			String errorMsg = "Erro ao inserir no banco de dados";
			LOGGER.error(errorMsg, e);
			throw new SFIException(errorMsg, e);

		} finally {
			factory.closePreparedStament(preparedStatement);
			factory.closeConnection(connection);	
		}
	}
}
