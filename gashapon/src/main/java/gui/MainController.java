package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exception.InitException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

public class MainController implements Initializable {

	@FXML
	private Label id_1;
	
	@FXML
	private Label price_1;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
		try{
			VendingMachine vendingMachine = new VendingMachine(products);
		} catch(InitException e) {
			System.out.println("The products array does not contain enough products (9");
		}
		
		price_1.setText(Double.toString(products.get(0).getPrice())+" €");
		
		
		
		
		
		
	}
}
