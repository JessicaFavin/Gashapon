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

    public void restockProduct(){
    	this.quantity = maxQuantity;
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

    private void incrementId(){
        nextId++;
    }


}
