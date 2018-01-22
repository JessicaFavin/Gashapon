package exception;

import java.lang.Exception;

public class SoldOutException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoldOutException() {
		super();
	}
	
	public SoldOutException(String message) {
		super(message);
	}
}
