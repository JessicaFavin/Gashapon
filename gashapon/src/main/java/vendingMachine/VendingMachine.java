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

    public VendingMachine(ArrayList<Product> products){
    	initStates();
        this.products = products;
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
    
    private void initStates() {
    	this.fullState = new FullState(this);
    	this.hasChangeState = new HasChangeState(this);
    	this.noChangeState = new NoChangeState(this);
    	this.soldOutState = new SoldOutState(this);
    }

}
