package vendingMachine;

public class HasChangeState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public HasChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void addProduct(int productId, int productQuantity) throws SoldOutException {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			if(this.vendingMachine.getProducts().get(productId) != null) {
				//add the product to the order list
				this.vendingMachine.addProduct(productId, productQuantity);
			}
		}
	}

	public void orderComplete() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.orderComplete();
		}		
	}

	public void payOrder(double moneyInserted) throws SoldOutException {
		//checks if not in the paying phase
		if(this.vendingMachine.getWaitingForPayement()) {
			//checks if inserted good money
			if(moneyInserted>0) {
				this.vendingMachine.insertMoney(moneyInserted);
			}
		}		
	}

	public void retrieveOrder() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			//changes state to hasChange or noChange
			if(!this.vendingMachine.hasChange()) {
				this.vendingMachine.changeState(this.vendingMachine.getNoChangeState());
			}
			//checks if need to change state to soldOut
			for(int i=0; i<VendingMachine.productsCapacity; i++) {
				Integer quantity = this.vendingMachine.getOrder().get(i);
				if(quantity != null) {
					if(this.vendingMachine.getProducts().get(i).isEmpty()) {
						this.vendingMachine.changeState(this.vendingMachine.getSoldOutState());
					}
				}
			}
			this.vendingMachine.retrieveOrder();
		}
		
	}

	public void cancelOrder() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.cancelOrder();
		}
	}

	public void callRestockTeam() throws RestockNotNeededException {
		// TODO Auto-generated method stub
		
	}

	public void giveBackChange() throws SoldOutException {
		this.vendingMachine.giveBackChange();		
	}
	
}