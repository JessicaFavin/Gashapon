package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exception.InitException;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

class VendingMachineTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	protected VendingMachine machine;

	@Before
	public void doBefore() {
		
		//ArrayList<Product> products = new ArrayList<Product>();
		//products.add(new Product(2,"coke.png","Coke"));
		//products.add(new Product(2.5 ,"sprite.png","Sprite"));
		//products.add(new Product(3,"fanta.png","Fanta"));
		//products.add(new Product(5,"kinder.png","Kinder"));
		//products.add(new Product(3 ,"granola.png","Granola"));
		//products.add(new Product(3,"mars.png","Mars"));
		//products.add(new Product(2,"apple_sauce.png","Apple sauce"));
		//products.add(new Product(2.5 ,"water.png","Water"));
		//products.add(new Product(3,"sparkling_water.png","Sparkling water"));
		
		//this.machine = new VendingMachine();
	}

	@After
	public void doAfter() {
		this.machine = null;
	}

	@Test
	public void testFillMachineWithNoProducts() {
		// Arrange		
		ArrayList<Product> products = new ArrayList<Product>();
		// Act
		try {
			this.machine = new VendingMachine(products);
		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assert
	}

	@Test
	public void testFillMachineWithMaxNumberOfProducts() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		products.add(new Product(2.5 ,"sprite.png","Sprite"));
		products.add(new Product(3,"fanta.png","Fanta"));
		products.add(new Product(5,"kinder.png","Kinder"));
		products.add(new Product(3 ,"granola.png","Granola"));
		products.add(new Product(3,"mars.png","Mars"));
		products.add(new Product(2,"apple_sauce.png","Apple sauce"));
		products.add(new Product(2.5 ,"water.png","Water"));
		products.add(new Product(3,"sparkling_water.png","Sparkling water"));
		// Act
		try {
			this.machine = new VendingMachine(products);
		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Assert
	}

	@Test
	public void testFillMachineWithMoreThanManNumberOfProducts() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		products.add(new Product(2.5 ,"sprite.png","Sprite"));
		products.add(new Product(3,"fanta.png","Fanta"));
		products.add(new Product(5,"kinder.png","Kinder"));
		products.add(new Product(3 ,"granola.png","Granola"));
		products.add(new Product(3,"mars.png","Mars"));
		products.add(new Product(2,"apple_sauce.png","Apple sauce"));
		products.add(new Product(2.5 ,"water.png","Water"));
		products.add(new Product(3,"sparkling_water.png","Sparkling water"));
		products.add(new Product(3,"fanta.png","Fanta"));
		products.add(new Product(5,"kinder.png","Kinder"));
		products.add(new Product(3 ,"granola.png","Granola"));
		products.add(new Product(3,"mars.png","Mars"));
		products.add(new Product(2,"apple_sauce.png","Apple sauce"));
		products.add(new Product(2.5 ,"water.png","Water"));
		products.add(new Product(3,"sparkling_water.png","Sparkling water"));
		// Act
		try {
			this.machine = new VendingMachine(products);
		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Assert
	}

	@Test
	public void testBuyItemWithExactPrice() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testBuyItemWithLessPrice() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testBuyItemWithMorePrice() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testSoldOutState() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testFullState() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testNoCHangeState() {
		// Arrange

		// Act

		// Assert
	}

}
