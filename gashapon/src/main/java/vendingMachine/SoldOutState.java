package vendingMachine;

public class SoldOutState implements State {
	
	private VendingMachine vendingMachine;
	
	public SoldOutState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void addProduct(int productId, int productQuantity) {
		// throw SoldOutException ?
		
	}

	public void orderComplete() {
		// throw SoldOutException ?
		
	}

	public void payOrder(double moneyInserted) {
		// throw SoldOutException ?
		
	}

	public void retrieveOrder() {
		// throw SoldOutException ?
		
	}

	public void cancelOrder() {
		// throw SoldOutException ?
		
	}


	

}