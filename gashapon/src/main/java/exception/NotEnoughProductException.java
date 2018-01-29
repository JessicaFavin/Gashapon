package exception;

import java.lang.Exception;

public class NotEnoughProductException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2561608990389740367L;

	public NotEnoughProductException() {
		super();
	}
	
	public NotEnoughProductException(String message) {
		super(message);
	}
}
