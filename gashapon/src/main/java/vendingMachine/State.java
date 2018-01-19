package vendingMachine;

public interface State {
    public void addProduct(int productId, int productQuantity);
    public void orderComplete();
    public void payOrder(double moneyInserted);
    public void retrieveOrder();
    public void cancelOrder();
}
