package br.com.ale.sfi.exception;

public class SFIException extends RuntimeException {

	public SFIException() {
		// TODO Auto-generated constructor stub
	}

	public SFIException(String message) {
		super(message);
	}

	public SFIException(String message, Throwable cause) {
		super(message, cause);
	}
	
    public SFIException(Throwable cause) {
        super(cause);
    }
}
