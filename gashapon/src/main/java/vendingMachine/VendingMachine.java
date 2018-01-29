package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import exception.SoldOutException;
import exception.InitException;
import exception.NoChangeException;
import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.RestockNotNeededException;
import state.FullState;
import state.HasChangeState;
import state.NoChangeState;
import state.SoldOutState;
import state.State;

public class VendingMachine {
	public List<Product> products; 
	public static final int productsCapacity = 9;
	private double cashRegister;
	private State machineState; 
	private double amountToPay;
	private Map<Integer, Integer> order;
	private boolean waitingForPayement;
	private double changeToGiveBack;
	private double price;

	//list of all the states
	private State fullState; // all the products are available / priority
	private State hasChangeState; // the machine has money
	private State noChangeState; // the machine does not have money
	private State soldOutState ; // at least one product can not be sold / priority

	public VendingMachine() throws SoldOutException {
		initStates();
		this.products = new ArrayList<Product>();
		this.cashRegister = 0;
		this.machineState = noChangeState; 
		this.amountToPay = 0;
		this.order = new HashMap<Integer, Integer>();
		this.waitingForPayement = false;
		this.products = new ArrayList<Product>();
		changeState(soldOutState);
	}

	public VendingMachine(List<Product> products) throws InitException {
		initStates();
		this.cashRegister = 0;
		//if state is not full, it will be changed inside initProducts method 
		this.machineState = fullState; 
		this.amountToPay = 0;
		this.order = new HashMap<Integer, Integer>();
		this.waitingForPayement = false;
		this.changeToGiveBack = 0;
		this.products = new ArrayList<Product>();
		try {
			initProducts(products);
		} catch(InitException e) {
			throw new InitException(e.getMessage());
		}
	}

	public void addCash(double cashAdded){
		if(cashAdded>0){
			this.cashRegister += cashAdded;
		}
	}

	public void giveCash(double cashReturned){
		if (cashReturned<=cashRegister){
			this.cashRegister -= cashReturned;
		}
	}

	/*
	 * Customer add product to order list
	 */
	public void addProduct(int productId, int productQuantity) throws NotEnoughProductException, ProductDoesNotExistException {
		Product productToAdd = this.getProduct(productId);
		if(productToAdd == null)
			throw new ProductDoesNotExistException();
		if(productToAdd.getQuantity()-productQuantity >= 0) {
			//add product to the order
			if(!this.order.containsKey(productId)) {
				this.order.put(productId, productQuantity);
			} else {
				this.order.put(productId, this.order.get(productId)+productQuantity);
			}
			// check quantity
			if(this.order.get(productId) > getProduct(productId).getQuantity()) {
				throw new NotEnoughProductException();
			}
			//add price of products added
			this.amountToPay += productToAdd.getPrice()*productQuantity;
			this.price = this.amountToPay;
		} else {
			throw new NotEnoughProductException();
		}
	}

	public void statePayOrder(double moneyInserted) throws SoldOutException, NoChangeException {
		System.out.println("VendingMachine - statePayOrder - waitingForPayement = " + this.waitingForPayement);
		System.out.println("VendingMachine - statePayOrder - machineState = " + this.machineState);
		this.machineState.payOrder(moneyInserted);
	}

	public void stateAddProduct(int productId, int productQuantity) throws NotEnoughProductException, SoldOutException, ProductDoesNotExistException {
		System.out.println("VendingMachine - stateAddProduct - waitingForPayement = " + this.waitingForPayement);
		System.out.println("VendingMachine - stateAddProduct - machineState = " + this.machineState);
		System.out.println("VendingMachine - stateAddProduct - productId = " + productId);
		System.out.println("VendingMachine - stateAddProduct - getProduct = " + getProduct(productId));
		machineState.addProduct(productId, productQuantity);
	}

	public void orderComplete() {
		if(this.amountToPay <= 0) {
			this.waitingForPayement = false;
		} else {
			this.waitingForPayement = true;
		}
	}

	public void stateOrderComplete() throws SoldOutException {
		this.machineState.orderComplete();
	}

	public void insertMoney(double moneyInserted) {
		this.amountToPay -= moneyInserted;
		addCash(moneyInserted);
		if(this.amountToPay <= 0) {
			this.waitingForPayement = false;
		}
	}

	public boolean getWaitingForPayement() {
		return this.waitingForPayement;
	}
	
	public void stateRestockMachine() throws RestockNotNeededException {
		this.machineState.callRestockTeam();
	}

	public void restockMachine() {
		for(Product product: this.products) {
			product.restockProduct();
		}
	}

	public void stateRetriveOrder() throws SoldOutException {
		System.out.println("VendingMachine - stateRetrieveOrder - waitingForPayement = " + this.waitingForPayement);
		System.out.println("VendingMachine - stateRetrieveOrder - machineState = " + this.machineState);
		System.out.println("VendingMachine - stateRetrieveOrder - amountToPay = " + this.amountToPay);
		if(this.amountToPay <= 0) {
			this.machineState.retrieveOrder();
		}
	}

	public void retrieveOrder() {
		// take products
		for (Map.Entry<Integer, Integer> entry : order.entrySet()) {
			Integer id = entry.getKey();
			Integer quantity = entry.getValue();
			getProduct(id).buyProduct(quantity);
		}
		this.order.clear();
		this.changeToGiveBack = 0;
		if(this.amountToPay<0) {
			this.changeToGiveBack = -1*this.amountToPay;
			giveCash(this.changeToGiveBack);
		}
		this.amountToPay = 0;
		this.price = 0;
		this.waitingForPayement = false;
		
		checkMachineState();
	}

	public void giveBackChange() {
		this.changeToGiveBack = 0;
	}

	public void cancelOrder() {
		giveCash(price-amountToPay);
		this.order.clear();
		this.amountToPay = 0;
		this.price = 0;
		//puts the products back in the machine's list
		for(int i=0 ; i<products.size() ; i++) {
			Integer quantity = this.order.get(products.get(i).getId());
			if(quantity != null) {
				products.get(i).putBackProduct(quantity.intValue());
			}
		}
	}

	public void stateCancelOrder() throws SoldOutException {
		this.machineState.cancelOrder();
	}

	private void initStates() {
		this.fullState = new FullState(this);
		this.hasChangeState = new HasChangeState(this);
		this.noChangeState = new NoChangeState(this);
		this.soldOutState = new SoldOutState(this);
	}

	public State getFullState() {
		return this.fullState;
	}

	public State getHasChangeState() {
		return this.hasChangeState;
	}

	public State getNoChangeState() {
		return this.noChangeState;
	}

	public State getSoldOutState() {
		return this.soldOutState;
	}

	public void changeState(State newState) {
		this.machineState = newState;
	}

	public boolean hasChange() {
		return !(this.cashRegister>15 && this.cashRegister%7==0);
	}

	private void initProducts(List<Product> products) throws InitException {
		//if the list of products contains enough products to fill the machine
		if(products.size() > 0) {
			int i = 0;
			for(Product p : products) {
				if(i >= VendingMachine.productsCapacity) {
					throw new InitException("Too much products.");
				}
				this.products.add(p);
				if(p.isEmpty()) {
					this.changeState(this.soldOutState);
				} else if(!p.isFull()) {
					this.changeState(this.noChangeState);
				}

				i++;
			}
		} else {
			//if there's not enough products throw init exception
			throw new InitException("No product");
		}
	}

	public List<Product> getProducts(){
		return this.products;
	}

	public Product getProduct(int id) {
		for(int i=0 ; i < this.products.size() ; i++) {
			if(this.products.get(i).isSame(id)) {
				return this.products.get(i);
			}
		}
		return null;
	}

	public Map<Integer, Integer> getOrder() {
		return this.order;
	}

	public double getChangeToGiveBack() {
		return this.changeToGiveBack;
	}

	public State getMachineState() {
		return this.machineState;
	}

	public double getPrice(int productId) {
		return getProduct(productId).getPrice();
	}

	public String printContent() {
		String content = "";

		for (Product product : this.products) {
			content += product.getName() + " (" + product.getId() + ") has " + product.getQuantity() + " left\n";
		}

		content += "Cash = " + this.cashRegister + "\n";

		return content;
	}

	public double getCash() {
		return this.cashRegister;
	}

	public void noWaitingForPayment() {
		this.waitingForPayement = false;
	}
	
	public void checkMachineState() {
		boolean full = true;
		for(Product product : this.products) {
			if(product.isEmpty()) {
				changeState(this.soldOutState);
				return;
			} else if(!product.isFull()){
				full = false;
			}
		}
		
		if(full) {
			changeState(this.fullState);
			return;
		}
		
		if(hasChange()) {
			changeState(this.hasChangeState);
			return;
		}
		
		changeState(this.noChangeState);
	}
	
	public double getAmountToPay() {
		return this.amountToPay;
	}

}
