package be.vdab.exceptions;

public class PostCodeException extends Exception {	

	private static final long serialVersionUID = 1L;

	public PostCodeException() {		
	}

	public PostCodeException(String message) {
		super(message);		
	}

	public PostCodeException(Throwable cause) {
		super(cause);
	}

	public PostCodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
