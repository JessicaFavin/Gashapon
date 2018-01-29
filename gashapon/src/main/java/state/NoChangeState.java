package state;

import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.RestockNotNeededException;
import exception.SoldOutException;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

public class NoChangeState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public NoChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void addProduct(int productId, int productQuantity) throws SoldOutException, NotEnoughProductException, ProductDoesNotExistException {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			if(this.vendingMachine.getProduct(productId) != null) {
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
		this.vendingMachine.orderComplete();
	}

	@Override
	public void payOrder(double moneyInserted) throws SoldOutException {
		// TODO
		//has to make sure user has the exact right amount of money
		
		//checks if inserted good money
		if(moneyInserted>0) {
			this.vendingMachine.insertMoney(moneyInserted);
		}	
		
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
			for(Product product : this.vendingMachine.getProducts()) {
				Integer quantity = this.vendingMachine.getOrder().get(product.getId());
				if(quantity != null) {
					if(product.isEmpty()) {
						this.vendingMachine.changeState(this.vendingMachine.getSoldOutState());
					}
				}
			}
			this.vendingMachine.retrieveOrder();
		}
	}

	@Override
	public void cancelOrder() throws SoldOutException {
		this.vendingMachine.cancelOrder();
	}

	@Override
	public void callRestockTeam() throws RestockNotNeededException {
		throw new RestockNotNeededException();
		
	}

	@Override
	public void giveBackChange() throws SoldOutException {
		this.vendingMachine.giveBackChange();		
	}
	
	@Override
	public String toString() {
		return "NoChangeState";
	}

	
}
