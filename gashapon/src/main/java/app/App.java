package app;



import java.net.URL;
import java.util.ArrayList;

import exception.InitException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vendingMachine.VendingMachine;
import vendingMachine.Product;

public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			final URL url = getClass().getResource("../gui/main.fxml");
		    final FXMLLoader fxmlLoader = new FXMLLoader(url);
		      
	        final Pane root = (Pane) fxmlLoader.load();

	        final Scene scene = new Scene(root, 350, 300);
	        primaryStage.setTitle("Gashapon"); 
	        primaryStage.setScene(scene);        
	        primaryStage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		launch(args);
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
		
		//do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
		System.out.println("do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
	}

}
