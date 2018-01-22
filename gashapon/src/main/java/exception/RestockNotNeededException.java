package exception;

import java.lang.Exception;

public class RestockNotNeededException extends Exception {

	
	public RestockNotNeededException() {
		super();
	}
	
	public RestockNotNeededException(String message) {
		super(message);
	}
	
}
