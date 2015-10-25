package br.com.ale.sfi.command;


public enum CommandType {

	LOAD_FILE("load-file", LoadFileCommand.class);

	private String type;
	private Class<? extends Command> commandClass; 

	CommandType(String type, Class<? extends Command> commandClass) {
		this.type = type;
		this.commandClass = commandClass;
	}
	
	public String getType() {
		return type;
	}

	public Class<? extends Command> getCommandClass() {
		return commandClass;
	}

	public static CommandType fromType(String type) {
		CommandType[] values = values();
		for (CommandType commandType : values) {
			if (commandType.type.equals(type)) {
				return commandType;
			}
		}
		return null;
	}
}
