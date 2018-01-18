package vendingMachine;

import java.util.ArrayList; 

public class Main {

	public static void main(String[] args) {
		// create products
		Product p1 = new Product(2,"coke.png","Coke");
		Product p2 = new Product(2.5 ,"sprite.png","Sprite");
		Product p3 = new Product(3,"fanta.png","Fanta");
		Product p4 = new Product(5,"kinder.png","Kinder");
		Product p5 = new Product(3 ,"granola.png","Granola");
		Product p6 = new Product(3,"mars.png","Mars");
		Product p7 = new Product(2,"apple_sauce.png","Apple sauce");
		Product p8 = new Product(2.5 ,"water.png","Water");
		Product p9 = new Product(3,"sparkling_water.png","Sparkling water");
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		//create vending machine
		VendingMachine vendingMachine = new VendingMachine(products);
		//do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
		System.out.println("do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");

	}

}
