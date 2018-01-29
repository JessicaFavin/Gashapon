package exception;

import java.lang.Exception;

public class SoldOutException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4328302986886686968L;

	public SoldOutException() {
		super();
	}
	
	public SoldOutException(String message) {
		super(message);
	}
}
