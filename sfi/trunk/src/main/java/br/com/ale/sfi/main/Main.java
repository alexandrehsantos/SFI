package br.com.ale.sfi.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.ale.sfi.command.Command;
import br.com.ale.sfi.command.CommandType;

public class Main {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("Parametro command type não fornecido. Encerrando o sistema.");
			System.exit(1);
		}
		String argCommand = args[0];

		CommandType commandType = CommandType.fromType(argCommand);
		
		if(commandType == null){
			System.out.println("Tipo de commando " + argCommand + " não mapeado. Encerrando o sistema.");
			System.exit(1);
		}
		
		List<String> listArgs = new ArrayList<String>(Arrays.asList(args));

		listArgs.remove(0);
		
		Command command = commandType.getInstance();
		
		try {
			long start = System.currentTimeMillis();
			command.execute(listArgs);
			long end = System.currentTimeMillis();
			System.out.println("Finalizado em :" + ((end - start) / 1000) + " seconds");
		} catch (Exception e) {
			System.out.println("Erro ao executar command: " + argCommand +  ". Favor verificar o log.");
			System.exit(1);
		}
	
	}

}
