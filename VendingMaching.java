

public class VendingMachine {
    public Product[] products;
    private int cashRegister;
    private int machineState; //don't know how to implement this yet
    private int amountToPay;

    public VendingMachine(Produt[] products){
        this.products = products;
        this.cashRegister = 0;
        this.State = 0; //same here
        this.amountToPay = 0;
    }

    public void addCash(int cashAdded){
        if(cashAdded>0){
            this.cashRegister += cashAdded;
        }
    }

    public void giveCash(int cashReturned){
        if (cashReturned<=cashRegister){
            this.cashRegister -= cashAdded;
        }
    }

}
