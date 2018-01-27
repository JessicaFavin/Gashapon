package vendingMachine;

public class Product {
    public static final int maxQuantity = 10;
    private static int nextId = 1;
    private double price;
    private int quantity;
    private int id;
    private String img;
    private String name;

    public Product(double price, String img, String name){
        this.price = price;
        this.quantity = Product.maxQuantity;
        this.id = nextId;
        incrementId();
        this.img = img;
        this.name = name;

    }
    
    public Product(double price, String img, String name, int quantity){
        this.price = price;
        this.quantity = quantity;
        this.id = nextId;
        incrementId();
        this.img = img;
        this.name = name;

    }
    
    public void restockProduct(int n){
    	int i = this.quantity + n;
    	if(i < Product.maxQuantity) {
    		this.quantity = i;
    	} else {
    		this.quantity = Product.maxQuantity;
    	}
    }

    public void restockProduct(){
    	this.quantity = Product.maxQuantity;
    }

    public void buyProduct(int quantityBought){
        if(quantityBought<=this.quantity){
            this.quantity -= quantityBought;
        }
    }
    
    public void putBackProduct(int quantityPutBack) {
    	if(quantityPutBack>0) {
    		this.quantity = Math.max(this.quantity+quantityPutBack, Product.maxQuantity);
    	}
    }

    public boolean isEmpty(){
        return (this.quantity==0);
    }
    
    public boolean isFull() {
    	return (this.quantity==Product.maxQuantity);
    }

    public double getPrice(){
        return this.price;
    }

    public int getId(){
        return this.id;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getImg(){
        return this.img;
    }

    public String getName(){
        return this.name;
    }
    
    public String toString(){
        return this.name + " (" + this.id + ")";
    }

    private void incrementId(){
        nextId++;
    }
    
    public boolean isSame(Product p) {
    	return (p.getId() == this.id);
    }
    
    public boolean isSame(int id) {
    	return (id == this.id);
    }


}
