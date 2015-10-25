package br.com.ale.sfi.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import br.com.ale.sfi.command.Command;
import br.com.ale.sfi.command.CommandFactory;
import br.com.ale.sfi.command.CommandType;
import br.com.ale.sfi.config.Config;

public class Main {

	private final static Logger LOGGER = Logger.getLogger(Main.class); 
	
	
	public static void main(String[] args) {
		Config config = Config.getInstance();
		CommandFactory commandFactory = CommandFactory.getInstance();
		DOMConfigurator.configure(config.getPathLog());
		
		if (args.length == 0) {
			LOGGER.error("Parametro tipo de comando nao fornecido. Encerrando o sistema.");
			System.exit(1);
		}
		String argCommand = args[0];

		CommandType commandType = CommandType.fromType(argCommand);
		
		if(commandType == null){
			LOGGER.error("Tipo de commando " + argCommand + " não mapeado. Encerrando o sistema.");
			System.exit(1);
		}
		
		List<String> listArgs = new ArrayList<String>(Arrays.asList(args));
		listArgs.remove(0);	
		
		Command command = commandFactory.getCommand(commandType);
		
		try {
			long start = System.currentTimeMillis();
			command.execute(listArgs);
			long end = System.currentTimeMillis();
			LOGGER.info("Finalizado em :" + ((end - start) / 1000) + " seconds");
		} catch (Exception e) {
			LOGGER.info("Erro ao executar command: " + argCommand +  ". Favor verificar o log.");
			System.exit(1);
		}
	
	}

}
