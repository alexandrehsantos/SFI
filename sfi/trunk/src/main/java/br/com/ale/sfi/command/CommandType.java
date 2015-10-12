package br.com.ale.sfi.command;

public enum CommandType {

	LOAD_FILE("load-file") {

		@Override
		public Command getInstance() {
			return new LoadFileCommand();
		}

	};

	private String type;

	CommandType(String type) {
		this.type = type;
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

	public abstract Command getInstance();

}
