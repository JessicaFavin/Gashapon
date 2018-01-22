package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	 private void clickItem(ActionEvent event) {
	     // Button was clicked, do something...
	     outputTextArea.appendText("Button Action\n");
	 }
}
