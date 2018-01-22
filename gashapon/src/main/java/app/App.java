package app;

import java.util.ArrayList;

import vendingMachine.VendingMachine;
import vendingMachine.Product;

public class App {

	public static void main(String[] args) {
		// create products
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(2,"coke.png","Coke"));
		products.add(new Product(2.5 ,"sprite.png","Sprite"));
		products.add(new Product(3,"fanta.png","Fanta"));
		products.add(new Product(4,"kinder.png","Kinder"));
		products.add(new Product(3 ,"granola.png","Granola"));
		products.add(new Product(2,"mars.png","Mars"));
		products.add(new Product(1.5,"apple_sauce.png","Apple sauce"));
		products.add(new Product(1 ,"water.png","Water"));
		products.add(new Product(1.5,"sparkling_water.png","Sparkling water"));
		//create vending machine
		VendingMachine vendingMachine = new VendingMachine(products);
		//do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
		System.out.println("do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		
	}

}
