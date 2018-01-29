package state;

import vendingMachine.Product;
import vendingMachine.VendingMachine;
import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.RestockNotNeededException;
import exception.SoldOutException;

public class FullState implements State {

	//the vending machine is the context 
	private VendingMachine vendingMachine;

	public FullState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void addProduct(int productId, int productQuantity) throws NotEnoughProductException, ProductDoesNotExistException {
		if(!this.vendingMachine.getWaitingForPayement()) {
			//checks if ID exists in the vending machine list
			if(this.vendingMachine.getProduct(productId) != null) {
				try {
					this.vendingMachine.addProduct(productId, productQuantity);
				} catch (NotEnoughProductException e) {
					//throws exception to be handled by the controller
					throw new NotEnoughProductException();
				} catch (ProductDoesNotExistException e) {
					// TODO Auto-generated catch block
					throw new ProductDoesNotExistException();
				}
			} else {
				throw new ProductDoesNotExistException();
			}
		}
	}

	@Override
	public void orderComplete() throws SoldOutException {
		this.vendingMachine.orderComplete();
	}

	@Override
	public void payOrder(double moneyInserted) throws SoldOutException {
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
			} else {
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

	@Override
	public void cancelOrder() {
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
		return "FullState";
	}

}