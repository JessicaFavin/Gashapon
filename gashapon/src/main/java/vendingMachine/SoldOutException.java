package vendingMachine;

public class SoldOutException extends Exception {
	
	public SoldOutException() {
		super();
	}
	
	public SoldOutException(String message) {
		super(message);
	}
}
