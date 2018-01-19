package vendingMachine;

import java.util.ArrayList; 

public class Main {

	public static void main(String[] args) {
		// create products
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
		//create vending machine
		VendingMachine vendingMachine = new VendingMachine(products);
		//do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
		System.out.println("do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");

	}

}
