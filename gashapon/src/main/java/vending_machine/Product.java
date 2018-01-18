

public class Product {
    private static final int maxQuantity = 10;
    private static int nextId = 1;
    private int price;
    private int quantity;
    private int id;
    private String img;
    private String name;

    public Product(int price, String img, String name){
        this.price = price;
        this.quantity = this.maxQuantity;
        this.is = nextId;
        incrementId();
        this.img = img;
        this.name = name;

    }

    public void restockProduct(int quantityAdded){
        if(quantityAdded>0){
            this.quantity += quantityAdded;
            if(this.quantity>maxQuantity){
                this.quantity = maxQuantity;
            }
        }
    }

    public void buyProduct(int quantityBought){
        if(quantityBought<=this.quantity){
            this.quantity -= quantityBought;
        }
    }

    public boolen isEmpty(){
        return (this.quantity==0);
    }

    public int getPrice(){
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
