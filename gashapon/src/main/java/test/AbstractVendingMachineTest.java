package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractVendingMachineTest {
	
	protected VendingMachine machine;
	
	@Before
	public void doBefore() {
		this.machine = new VendingMachine();
	}
	
	@Test
	public void testMachineSingleton() {
		// Arrange
		
		// Act
		
		// Assert
	}
}
