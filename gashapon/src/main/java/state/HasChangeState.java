package state;

import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.RestockNotNeededException;
import exception.SoldOutException;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

public class HasChangeState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;
	
	public HasChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void addProduct(int productId, int productQuantity) throws SoldOutException, NotEnoughProductException, ProductDoesNotExistException {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			try {
				if(this.vendingMachine.getProduct(productId) != null) {
					try {
						this.vendingMachine.addProduct(productId, productQuantity);
					} catch (NotEnoughProductException e) {
						//throws exception to be handled by the controller
						throw new NotEnoughProductException();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void orderComplete() throws SoldOutException {
		//checks if not in the paying phase
		//if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.orderComplete();
		//}		
	}

	public void payOrder(double moneyInserted) throws SoldOutException {
		//checks if not in the paying phase
		//if(this.vendingMachine.getWaitingForPayement()) {
			//checks if inserted good money
			if(moneyInserted>0) {
				this.vendingMachine.insertMoney(moneyInserted);
			}
		//}		
	}

	public void retrieveOrder() throws SoldOutException {
		//checks if not in the paying phase
		if(!this.vendingMachine.getWaitingForPayement()) {
			//changes state to hasChange or noChange
			if(!this.vendingMachine.hasChange()) {
				this.vendingMachine.changeState(this.vendingMachine.getNoChangeState());
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

	public void cancelOrder() throws SoldOutException {
		//checks if not in the paying phase
		//if(!this.vendingMachine.getWaitingForPayement()) {
			this.vendingMachine.cancelOrder();
		//}
	}

	public void callRestockTeam() throws RestockNotNeededException {
		// TODO Auto-generated method stub
		
	}

	public void giveBackChange() throws SoldOutException {
		this.vendingMachine.giveBackChange();		
	}
	
	@Override
	public String toString() {
		return "HasChangeState";
	}
	
}