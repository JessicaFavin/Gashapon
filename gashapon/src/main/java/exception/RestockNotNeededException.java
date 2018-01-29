package exception;

import java.lang.Exception;

public class RestockNotNeededException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -739808824590551212L;

	public RestockNotNeededException() {
		super();
	}
	
	public RestockNotNeededException(String message) {
		super(message);
	}
	
}
