package vendingMachine;

public class SoldOutState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public SoldOutState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void addProduct(int productId, int productQuantity) throws SoldOutException {
		throw new SoldOutException();
		
	}

	public void orderComplete() throws SoldOutException {
		throw new SoldOutException();
		
	}

	public void payOrder(double moneyInserted) throws SoldOutException {
		throw new SoldOutException();
		
	}

	public void retrieveOrder() throws SoldOutException {
		throw new SoldOutException();
		
	}

	public void cancelOrder() throws SoldOutException {
		throw new SoldOutException();
		
	}
	
	public void callRestockTeam() throws RestockNotNeededException{
		//call the restock team
		this.vendingMachine.restockMachine();
		//change to full state
		this.vendingMachine.changeState(this.vendingMachine.getFullState());
	}


	

}