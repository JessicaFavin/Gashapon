package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import vendingMachine.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		//new ProductHandlerController();
		primaryStage.setTitle("Vending Machine - Gashapon");
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/main.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			
			/*
			// Give the controller access to the main app.
			ProductHandlerController controller = loader.getController();
	        controller.setMainApp(this);
	        */
			
			//new ProductHandlerController(scene);
	        
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//System.out.println(page.lookup("#product_3n")); //returns 
			
			ArrayList<Product> products = new ArrayList<Product>();
			products.add(new Product(2,"mms.jpg","Coke"));
			
			new ProductHandlerController(page, products);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
