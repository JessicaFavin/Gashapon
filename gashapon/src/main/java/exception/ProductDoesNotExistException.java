package exception;

public class ProductDoesNotExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5394543521791761668L;

	public ProductDoesNotExistException() {
		super();
	}
	
	public ProductDoesNotExistException(String message) {
		super(message);
	}
}
