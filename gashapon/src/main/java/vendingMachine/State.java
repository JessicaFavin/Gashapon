package vendingMachine;

public interface State {
    public void addProduct(int productId, int productQuantity) throws SoldOutException;
    public void orderComplete() throws SoldOutException;
    public void payOrder(double moneyInserted) throws SoldOutException;
    public void retrieveOrder() throws SoldOutException;
    public void cancelOrder() throws SoldOutException;
    public void callRestockTeam() throws RestockNotNeededException;
    public void giveBackChange() throws SoldOutException;
}
