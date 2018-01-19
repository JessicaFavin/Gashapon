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

    //list of all the states
    private State fullState;
    private State hasChangeState;
    private State noChangeState;
    private State soldOutState ;
    
    public VendingMachine() {
    	initStates();
    	this.products = new ArrayList<Product>();
        this.cashRegister = 0;
        this.machineState = noChangeState; 
        this.amountToPay = 0;
        this.order = new ArrayList<Integer>();
        this.waitingForPayement = false;
    }

    public VendingMachine(ArrayList<Product> products){
    	initStates();
    	initProducts(products);
        this.cashRegister = 0;
        this.machineState = noChangeState; 
        this.amountToPay = 0;
        this.order = new ArrayList<Integer>();
        this.waitingForPayement = false;
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
     * Customer
     */
    public void addProduct(int productId, int productQuantity) {
    	this.order.add(productId, productQuantity);
    	this.amountToPay += this.products.get(productId).getPrice();
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
    
    private void initProducts(ArrayList<Product> products) {
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

}
