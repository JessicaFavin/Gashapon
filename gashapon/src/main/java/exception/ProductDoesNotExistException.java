package exception;

public class ProductDoesNotExistException extends Exception {
	public ProductDoesNotExistException() {
		super();
	}
	
	public ProductDoesNotExistException(String message) {
		super(message);
	}
}
