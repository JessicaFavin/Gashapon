package vendingMachine;

public class NoChangeState implements State {

	private VendingMachine vendingMachine;
	
	public NoChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	
}
