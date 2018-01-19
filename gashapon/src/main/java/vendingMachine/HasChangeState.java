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
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.orderComplete();
		}		
	}

	public void payOrder(double moneyInserted) {
		//checks if not in the paying phase
		if(this.vendingMachine.getWaitingForPayement()) {
			//checks if inserted good money
			if(moneyInserted>0) {
				this.vendingMachine.insertMoney(moneyInserted);
			}
		}		
	}

	public void retrieveOrder() {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.retrieveOrder();
		}
		
	}

	public void cancelOrder() {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.cancelOrder();
		}
	}

	public void callRestockTeam() {
		// TODO Auto-generated method stub
		
	}

	public void giveBackChange() {
		this.vendingMachine.giveBackChange();		
	}
	
}