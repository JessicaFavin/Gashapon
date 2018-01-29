package state;

import exception.NoChangeException;
import exception.NotEnoughProductException;
import exception.RestockNotNeededException;
import exception.SoldOutException;
import vendingMachine.VendingMachine;

public class SoldOutState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public SoldOutState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void addProduct(int productId, int productQuantity) throws SoldOutException, NotEnoughProductException {
		throw new SoldOutException();
		
	}

	@Override
	public void orderComplete() throws SoldOutException {
		throw new SoldOutException();
		
	}

	@Override
	public void payOrder(double moneyInserted) throws SoldOutException, NoChangeException {
		throw new SoldOutException();
		
	}

	@Override
	public void retrieveOrder() throws SoldOutException {
		throw new SoldOutException();
		
	}

	@Override
	public void cancelOrder() throws SoldOutException {
		throw new SoldOutException();
		
	}
	
	@Override
	public void callRestockTeam() {
		//call the restock team
		this.vendingMachine.restockMachine();
		//change to full state
		this.vendingMachine.changeState(this.vendingMachine.getFullState());
	}

	@Override
	public void giveBackChange() throws SoldOutException {
		throw new SoldOutException();
		
	}

	@Override
	public String toString() {
		return "SoldOutState";
	}
	

}