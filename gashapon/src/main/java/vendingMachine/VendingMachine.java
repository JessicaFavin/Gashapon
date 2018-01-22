package vendingMachine;

import java.util.ArrayList;
import java.util.HashMap;

import exception.SoldOutException;
import exception.NotEnoughProductException;

import state.FullState;
import state.HasChangeState;
import state.NoChangeState;
import state.SoldOutState;
import state.State;

public class VendingMachine {
    public ArrayList<Product> products; 
    public static final int productsCapacity = 9;
    private int cashRegister;
    private State machineState; 
    private int amountToPay;
    private HashMap<Integer, Integer> order;
    private boolean waitingForPayement;
    private double changeToGiveBack;

    //list of all the states
    private State fullState; // all the products are available
    private State hasChangeState; // the machine has money
    private State noChangeState; // the machine does not have money
    private State soldOutState ; // at least one product can not be sold
    // TODO: see for priority between noChange/soldOut, hasChange/soldOut, noChange/full, hasChange/full
    
    public VendingMachine() throws SoldOutException {
    	initStates();
    	this.products = new ArrayList<Product>();
        this.cashRegister = 0;
        this.machineState = noChangeState; 
        this.amountToPay = 0;
        this.order = new HashMap<Integer, Integer>();
        this.waitingForPayement = false;
        
        changeState(soldOutState);
    }

    public VendingMachine(ArrayList<Product> products){
    	initStates();
        this.cashRegister = 0;
        this.machineState = noChangeState; 
        this.amountToPay = 0;
        this.order = new HashMap<Integer, Integer>();
        this.waitingForPayement = false;
        this.changeToGiveBack = 0;
        
        try {
        	initProducts(products);
        } catch(SoldOutException e) {
        	changeState(soldOutState);
        }
    }

    public void addCash(int cashAdded){
        if(cashAdded>0){
            this.cashRegister += cashAdded;
        }
    }

    public void giveCash(int cashReturned){
        if (cashReturned<=cashRegister){
            this.cashRegister -= cashReturned;
        }
    }
    
    /*
     * Customer add product to order list
     */
    public void addProduct(int productId, int productQuantity) throws NotEnoughProductException {
    	Product productToAdd = this.getProduct(productId);
    	if(productToAdd.getQuantity()-productQuantity >= 0) {
    		//add product to the order
        	this.order.put(productId, productQuantity);
        	//add price of products added
        	this.amountToPay += productToAdd.getPrice()*productQuantity;
        	//takes products from the machine
        	productToAdd.buyProduct(productQuantity);
    	} else {
    		throw new NotEnoughProductException();
    	}
    }
    
    public void orderComplete() {
    	this.waitingForPayement = true;
    }
    
    public void insertMoney(double moneyInserted) {
    	this.amountToPay -= moneyInserted;
    }
    
    public boolean getWaitingForPayement() {
    	return this.waitingForPayement;
    }
    
    public void restockMachine() {
    	for(Product product: this.products) {
    		product.restockProduct();
    	}
    }
    
    public void retrieveOrder() {
    	this.order.clear();
    	if(this.amountToPay<0) {
    		this.changeToGiveBack = -1*this.amountToPay;
    	}
    	this.amountToPay = 0;
    }
    
    public void giveBackChange() {
    	this.changeToGiveBack = 0;
    }
    
    public void cancelOrder() {
    	this.order.clear();
    	this.amountToPay = 0;
    	//puts the products back in the machine's list
    	for(int i=0; i<VendingMachine.productsCapacity; i++) {
			Integer productQuantity = this.order.get(i);
			int productId = i;
			if(productQuantity != null) {
				Product product = this.products.get(productId);
	    		product.putBackProduct(productQuantity.intValue());
			}
		}
    }

    /*
    public void restockMachine(ArrayList<Product> products) {
    	boolean filled = false;
    	for(Product p: products) {
    		filled = false;
    		for(int i=0 ; i < this.products.size() ; i++) {
    			if(p.isSame(this.products.get(i))) {
    				this.products.get(i).restockProduct(p.getQuantity());
    				filled = true;
    				break;
    			}
    		}
    		if(!filled) {
    			this.products.add(p);
    		}
    	}
    }
    */

    
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
    	return (this.cashRegister>15 && this.cashRegister%7==0);
    }
    
    private void initProducts(ArrayList<Product> products) throws SoldOutException {
    	if(products.size() == 0) {
    		throw new SoldOutException();
    	}
    	if(products.size() > VendingMachine.productsCapacity) {
    		int i = 0;
    		for(Product p : products) {
    			if(i >= VendingMachine.productsCapacity)
    				break;
    			
    			this.products.add(p);
    			i++;
    		}
    	} else {
    		this.products = products;
    	}
    }
    
    public ArrayList<Product> getProducts(){
    	return this.products;
    }
    
    public Product getProduct(int id) {
    	for(Product product : this.products) {
    		if(product.isSame(id)) {
    			return product;
    		}
    	}
    	
    	return null;
    }
    
    public HashMap<Integer, Integer> getOrder() {
    	return this.order;
    }

}
