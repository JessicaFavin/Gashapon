package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exception.InitException;
import exception.NoChangeException;
import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.SoldOutException;
import state.FullState;
import state.HasChangeState;
import state.NoChangeState;
import state.SoldOutState;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

class VendingMachineTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	protected VendingMachine machine;

	@Before
	public void doBefore() {

	}

	@After
	public void doAfter() {
		this.machine = null;
	}

	@Test
	public void testFillMachineWithNoProducts() {
		// Arrange		
		ArrayList<Product> products = new ArrayList<Product>();
		thrown.expect(ProductDoesNotExistException.class);

		// Act & Assert
		assertThrows(InitException.class, 
				()->{this.machine = new VendingMachine(products);});
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

		// Act & Assert
		try {
			this.machine = new VendingMachine(products);
		} catch (InitException e) {
			e.printStackTrace();
		}

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

		// Act & Assert
		assertThrows(InitException.class, 
				()->{this.machine = new VendingMachine(products);});
	}

	@Test
	public void testBuyItemWithExactPrice() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(2);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.printStackTrace();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 2) && (this.machine.getProduct(product.getId()).getQuantity() == (Product.maxQuantity-1)));
	}

	@Test
	public void testBuyItemWithLessThanPrice() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(1);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 1) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testBuyItemWithMoreThanPriceWithNoChange() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act & Assert
		assertThrows(NoChangeException.class, 
				()->{
					Product product = products.get(0);
					this.machine = new VendingMachine(products);
					this.machine.stateAddProduct(product.getId(), 1);
					this.machine.stateOrderComplete();
					this.machine.statePayOrder(5);
					this.machine.stateRetriveOrder();}
				);
	}

	@Test
	public void testBuyItemWithMoreThanPrice() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);
		try {
			this.machine = new VendingMachine(products);
			// get out of nochange state
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(2);
			this.machine.stateRetriveOrder();

			// get out of nochange state
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(5);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 4) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity-2));
	}

	@Test
	public void testBuyTwiceTheSameItem() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);

		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 2);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(4);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 4) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity-2));
	}

	@Test
	public void testBuyTwoDifferentItems() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		products.add(new Product(3,"kinder.png","Kinder"));
		// Act
		Product product1 = products.get(0);
		Product product2 = products.get(1);
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product1.getId(), 1);
			this.machine.stateAddProduct(product2.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(5);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 5) 
				&& (this.machine.getProduct(product1.getId()).getQuantity() == Product.maxQuantity-1)
				&& (this.machine.getProduct(product2.getId()).getQuantity() == Product.maxQuantity-1));
	}

	@Test
	public void testBuyMoreItemsThanAvailable() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act & Assert
		Product product = products.get(0);
		assertThrows(NotEnoughProductException.class, 
				()->{
					this.machine = new VendingMachine(products);
					this.machine.stateAddProduct(product.getId(), 11);
					this.machine.stateOrderComplete();
					this.machine.statePayOrder(22);
					this.machine.stateRetriveOrder();
				});

	}

	@Test
	public void testBuyItemNotAvailable() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act & Assert
		assertThrows(ProductDoesNotExistException.class, 
				()->{
					this.machine = new VendingMachine(products);
					this.machine.stateAddProduct(0, 1);
					this.machine.stateOrderComplete();
					this.machine.statePayOrder(2);
					this.machine.stateRetriveOrder();
				});

	}

	@Test
	public void testCancelWhileOrdering() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);

		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateCancelOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		}
		// Assert
		assertTrue((this.machine.getCash() == 0) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testCancelWhilePaying() {
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act 
		Product product = products.get(0);

		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(1);
			this.machine.stateCancelOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();

		} catch (InitException e) {
			e.print();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue((this.machine.getCash() == 0) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testSoldOutState() {
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

		Product product = products.get(0);
		// Act
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), Product.maxQuantity);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(2*Product.maxQuantity);
			this.machine.stateRetriveOrder();
		} catch (InitException | NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			e.printStackTrace();
		} catch (NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue(this.machine.getMachineState().getClass() == SoldOutState.class);
	}

	@Test
	public void testFullState() {
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
			e.printStackTrace();
		}
		// Assert
		assertTrue(this.machine.getMachineState().getClass() == FullState.class);
	}

	@Test
	public void testNoChangeState() {
		System.out.println("");
		System.out.println("testNoChangeState");

		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(21,"coke.png","Coke"));
		Product product = products.get(0);
		// Act
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(21);
			this.machine.stateRetriveOrder();
		} catch (InitException | NotEnoughProductException | SoldOutException | ProductDoesNotExistException | NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue(this.machine.getMachineState().getClass() == NoChangeState.class);
	}

	@Test
	public void testHasChangeState() {
		System.out.println("");
		System.out.println("testHasCHangeState");
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(15,"coke.png","Coke"));
		Product product = products.get(0);
		// Act
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(15);
			this.machine.stateRetriveOrder();
		} catch (InitException | NotEnoughProductException | SoldOutException | ProductDoesNotExistException | NoChangeException e) {
			e.printStackTrace();
		}
		// Assert
		assertTrue(this.machine.getMachineState().getClass() == HasChangeState.class);
	}

}
