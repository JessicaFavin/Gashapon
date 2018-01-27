package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exception.InitException;
import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.SoldOutException;
import state.FullState;
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
			// TODO Auto-generated catch block
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
		System.out.println("");
		System.out.println("testBuyItemWithExactPrice");
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
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assert
		System.out.println("testBuyItemWithExactPrice - cash = " + this.machine.getCash());
		System.out.println("testBuyItemWithExactPrice - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 2) && (this.machine.getProduct(product.getId()).getQuantity() == (Product.maxQuantity-1)));
	}

	@Test
	public void testBuyItemWithLessThanPrice() {
		System.out.println("");
		System.out.println("testBuyItemWithLessPrice");
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
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testBuyItemWithLessPrice - cash = " + this.machine.getCash());
		System.out.println("testBuyItemWithLessPrice - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 1) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testBuyItemWithMoreThanPrice() {
		System.out.println("");
		System.out.println("testBuyItemWithMoreThanPrice");
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);
		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 1);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(5);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testBuyItemWithMoreThanPrice - cash = " + this.machine.getCash());
		System.out.println("testBuyItemWithMoreThanPrice - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 2) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity-1));
	}

	@Test
	public void testBuyTwiceTheSameItem() {
		System.out.println("");
		System.out.println("testBuyTwiceTheSameItem");
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act
		Product product = products.get(0);

		try {
			this.machine = new VendingMachine(products);
			this.machine.stateAddProduct(product.getId(), 2);
			this.machine.stateOrderComplete();
			this.machine.statePayOrder(5);
			this.machine.stateRetriveOrder();
		} catch (NotEnoughProductException | SoldOutException | ProductDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testBuyTwiceTheSameItem - cash = " + this.machine.getCash());
		System.out.println("testBuyTwiceTheSameItem - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 4) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity-2));
	}

	@Test
	public void testBuyTwoDifferentItems() {
		System.out.println("");
		System.out.println("testBuyTwoDifferentItems");
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
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testBuyTwoDifferentItems - cash = " + this.machine.getCash());
		//System.out.println("testBuyTwoDifferentItems - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 5) 
				&& (this.machine.getProduct(product1.getId()).getQuantity() == Product.maxQuantity-1)
				&& (this.machine.getProduct(product2.getId()).getQuantity() == Product.maxQuantity-1));
	}

	@Test
	public void testBuyMoreItemsThanAvailable() {
		System.out.println("");
		System.out.println("testBuyMoreItemsThanAvailable");
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

		System.out.println("testBuyMoreItemsThanAvailable - cash = " + this.machine.getCash());
		System.out.println("testBuyMoreItemsThanAvailable - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
	}

	@Test
	public void testBuyItemNotAvailable() {
		System.out.println("");
		System.out.println("testBuyItemNotAvailable");
		// Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		// Act & Assert
		Product product = products.get(0);
		assertThrows(ProductDoesNotExistException.class, 
				()->{
					this.machine = new VendingMachine(products);
					this.machine.stateAddProduct(0, 1);
					this.machine.stateOrderComplete();
					this.machine.statePayOrder(2);
					this.machine.stateRetriveOrder();
				});

		System.out.println("testBuyItemNotAvailable - cash = " + this.machine.getCash());
		System.out.println("testBuyItemNotAvailable - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
	}

	@Test
	public void testCancelWhileOrdering() {
		System.out.println("");
		System.out.println("testCancelWhileOrdering");
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
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testCancelWhileOrdering - cash = " + this.machine.getCash());
		System.out.println("testCancelWhileOrdering - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 0) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testCancelWhilePaying() {
		System.out.println("");
		System.out.println("testCancelWhilePaying");
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
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InitException e) {
			// TODO Auto-generated catch block
			e.print();
		}
		// Assert
		System.out.println("testCancelWhilePaying - cash = " + this.machine.getCash());
		System.out.println("testCancelWhilePaying - quantity " + Product.maxQuantity + " = " + this.machine.getProduct(product.getId()).getQuantity());
		assertTrue((this.machine.getCash() == 0) && (this.machine.getProduct(product.getId()).getQuantity() == Product.maxQuantity));
	}

	@Test
	public void testSoldOutState() {
		System.out.println("");
		System.out.println("testSoldOutState");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Assert
		assertTrue(this.machine.getMachineState().getClass() == SoldOutState.class);
	}

	@Test
	public void testFullState() {
		System.out.println("");
		System.out.println("testFullState");
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
		assertTrue(this.machine.getMachineState().getClass() == FullState.class);
	}

	@Test
	public void testNoChangeState() {
		System.out.println("");
		System.out.println("testNoChangeState");
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testHasChangeState() {
		System.out.println("");
		System.out.println("testHasCHangeState");
		// Arrange

		// Act

		// Assert
	}

}
