package br.com.ale.sfi.dao.factory;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import br.com.ale.sfi.config.Config;
import br.com.ale.sfi.exception.SFIException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory connectionFactory;
	private ComboPooledDataSource dataSource;

	private ConnectionFactory() {

		Config config = Config.getInstance();

		dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass(config.getDriverClass());
		} catch (PropertyVetoException e) {
			LOGGER.error("Erro ao configurar database driver", e);
			throw new SFIException("Erro ao configurar database driver", e);
		}

		dataSource.setJdbcUrl(config.getJDBCUrl());
		dataSource.setUser(config.getUser());
		dataSource.setPassword(config.getPassword());
		dataSource.setMinPoolSize(config.getMinPollSize());
		dataSource.setMaxPoolSize(config.getMaxPollSize());

	}

	public void closePreparedStament(PreparedStatement preparedStatement) {
		try {
			if( preparedStatement != null){
				preparedStatement.close();
			}
		} catch (SQLException e) {
			String errorMsg = "Erro ao fechar conexao com o banco de dados";
			LOGGER.error(errorMsg, e);
			throw new SFIException(errorMsg, e);
		}
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			String errorMsg = "Erro ao obter conexao com o banco de dados";
			LOGGER.error(errorMsg, e);
			throw new SFIException(errorMsg, e);
		}
	}

	public void closeConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			String errorMsg = "Erro ao fechar conexao com o banco de dados";
			LOGGER.error(errorMsg, e);
			throw new SFIException(errorMsg, e);
		}
	}

	public static ConnectionFactory getInstance() {

		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

}
