package vendingMachine;

public class HasChangeState implements State {

	private VendingMachine vendingMachine;
	
	public HasChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void addProduct(int productId, int productQuantity) {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			if(this.vendingMachine.products.get(productId) != null) {
				//add the product to the order list
				this.vendingMachine.addProduct(productId, productQuantity);
			}
		}
	}

	public void orderComplete() {
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.orderComplete();
		}		
	}

	public void payOrder(double moneyInserted) {
		if(this.vendingMachine.getWaitingForPayement()) {
			if(moneyInserted>0) {
				this.vendingMachine.insertMoney(moneyInserted);
			}
		}		
	}

	public void retrieveOrder() {
		// TODO Auto-generated method stub
		
	}

	public void cancelOrder() {
		// TODO Auto-generated method stub
		
	}
	
}