package br.com.ale.sfi.command;

import org.apache.log4j.Logger;

import br.com.ale.sfi.exception.SFIException;

public class CommandFactory {

	private static final Logger LOGGER = Logger.getLogger(CommandFactory.class);

	private static CommandFactory factory;

	public Command getCommand(CommandType type) {
		Class<? extends Command> commandClass = type.getCommandClass();
		try {
			return commandClass.newInstance();
		} catch (Exception e) {
			String msgError = "Erro ao criar comando: " + type.getType() + ".";
			LOGGER.error(msgError, e);
			throw new SFIException(msgError);
		}
	}

	public static CommandFactory getInstance() {
		if (factory == null) {
			factory = new CommandFactory();
		}
		return factory;
	}
}
