package state;

import exception.NotEnoughProductException;
import exception.RestockNotNeededException;
import exception.SoldOutException;
import vendingMachine.VendingMachine;

public class NoChangeState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public NoChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void addProduct(int productId, int productQuantity) throws SoldOutException, NotEnoughProductException {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			if(this.vendingMachine.getProducts().get(productId) != null) {
				//add the product to the order list
				try {
					this.vendingMachine.addProduct(productId, productQuantity);
				} catch (NotEnoughProductException e) {
					//throws exception to be handled by the controller
					throw new NotEnoughProductException();
				}
				
			}
		}
	}

	@Override
	public void orderComplete() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.orderComplete();
		}		
	}

	@Override
	public void payOrder(double moneyInserted) throws SoldOutException {
		//TO DO
		//has to make sure user has the exact right amount of money
		
		/*
		//checks if not in the paying phase
		if(this.vendingMachine.getWaitingForPayement()) {
			//checks if inserted good money
			if(moneyInserted>0) {
				this.vendingMachine.insertMoney(moneyInserted);
			}
		}		
		*/
		
	}

	@Override
	public void retrieveOrder() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			//changes state to hasChange or noChange
			if(this.vendingMachine.hasChange()) {
				this.vendingMachine.changeState(this.vendingMachine.getHasChangeState());
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

	@Override
	public void cancelOrder() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.cancelOrder();
		}
	}

	@Override
	public void callRestockTeam() throws RestockNotNeededException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveBackChange() throws SoldOutException {
		this.vendingMachine.giveBackChange();		
	}

	
}
