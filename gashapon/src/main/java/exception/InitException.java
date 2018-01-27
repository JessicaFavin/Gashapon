package exception;

public class InitException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public InitException() {
		super();
	}
	
	public InitException(String message) {
		super(message);
		this.message = message;
	}
	
	public void print() {
		System.err.println(this.message);
		this.printStackTrace();
	}
	
	public String getMessage() {
		return this.message;
	}

}
