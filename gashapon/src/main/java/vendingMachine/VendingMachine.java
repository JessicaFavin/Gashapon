package vendingMachine;

import java.util.ArrayList; 

public class VendingMachine {
    public ArrayList<Product> products; 
    public static final int productsCapacity = 9;
    private int cashRegister;
    private State machineState; 
    private int amountToPay;
    private ArrayList<Integer> order;
    private boolean waitingForPayement;
    private double changeToGiveBack;

    //list of all the states
    private State fullState;
    private State hasChangeState;
    private State noChangeState;
    private State soldOutState ;

    public VendingMachine(ArrayList<Product> products){
    	initStates();
        this.products = products;
        this.cashRegister = 0;
        this.machineState = noChangeState; 
        this.amountToPay = 0;
        this.order = new ArrayList<Integer>();
        this.waitingForPayement = false;
        this.changeToGiveBack = 0;
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
    
    public void addProduct(int productId, int productQuantity) {
    	if(this.products.get(productId).getQuantity()-productQuantity >= 0) {
    		//add product to the order
        	this.order.add(productId, productQuantity);
        	//add price of products added
        	this.amountToPay += this.products.get(productId).getPrice()*productQuantity;
        	//takes products from the machine
        	this.products.get(productId).buyProduct(productQuantity);
    	} else {
    		//throw notEnoughProductException
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
    	for(Integer productQuantity: this.order) {
    		int productId = this.order.indexOf(productQuantity);
    		Product product = this.products.get(productId);
    		product.putBackProduct(productQuantity.intValue());
    	}
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
    	return (this.cashRegister>15 && this.cashRegister%7==0);
    }
}
