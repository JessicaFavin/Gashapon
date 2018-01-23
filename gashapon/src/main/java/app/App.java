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
			
			final URL url = getClass().getResource("../gui/Main.fxml");
		    final FXMLLoader fxmlLoader = new FXMLLoader(url);
		      
	        final Pane root = (Pane) fxmlLoader.load();

	        final Scene scene = new Scene(root, 1280, 720);
	        primaryStage.setTitle("Gashapon"); 
	        primaryStage.setScene(scene);        
	        primaryStage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
			
		//do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
		System.out.println("do stuff now (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧");
		launch(args);
	}

}
