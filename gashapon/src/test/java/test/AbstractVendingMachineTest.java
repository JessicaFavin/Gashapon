package test;
/*
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vendingMachine.Product;
import vendingMachine.VendingMachine;

public class AbstractVendingMachineTest {

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
		this.machine = new VendingMachine(products);
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
		this.machine = new VendingMachine(products);

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
		this.machine = new VendingMachine(products);

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
*/