package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import model.ProductModel;
import model.VBoxProduct;
import vendingMachine.Product;

/**
 * The products are from 0 to 8 in row.
 * @author Célande
 *
 */
public class ProductHandlerController implements Initializable {

	// Reference to the main application.
	private AnchorPane page;

	@FXML
	private static VBox product_0;
	private static VBox product_1;
	private static VBox product_2;
	private static VBox product_3;
	private static VBox product_4;
	private static VBox product_5;
	private static VBox product_6;
	private static VBox product_7;
	private static VBox product_8;

	@FXML
	private static VBox product_3n;
	private static VBox product_3n_1;
	private static VBox product_3n_2;

	public ProductHandlerController(AnchorPane anchorPage) {	
		this.page = anchorPage;

		product_0 = (VBox) this.page.lookup("#product_0");
		product_1 = (VBox) this.page.lookup("#product_1");
		product_2 = (VBox) this.page.lookup("#product_2");
		product_3 = (VBox) this.page.lookup("#product_3");
		product_4 = (VBox) this.page.lookup("#product_4");
		product_5 = (VBox) this.page.lookup("#product_5");
		product_6 = (VBox) this.page.lookup("#product_6");
		product_7 = (VBox) this.page.lookup("#product_7");
		product_8 = (VBox) this.page.lookup("#product_8");
		
		System.out.println(product_0.getChildren());
		System.out.println(((TextArea)((HBox) product_0.getChildren().get(1)).getChildren().get(1)).getText());
	}

	ProductHandlerController(AnchorPane page, ArrayList<Product> products){
		this.page = page;
		Iterator<Product> itr = products.iterator();

		//System.out.println("id = " + product_0.getId());
		//System.out.println("properties = " + product_0.getProperties());
		
		product_0 = (VBox) this.page.lookup("#product_0");
		product_1 = (VBox) this.page.lookup("#product_1");
		product_2 = (VBox) this.page.lookup("#product_2");
		product_3 = (VBox) this.page.lookup("#product_3");
		product_4 = (VBox) this.page.lookup("#product_4");
		product_5 = (VBox) this.page.lookup("#product_5");
		product_6 = (VBox) this.page.lookup("#product_6");
		product_7 = (VBox) this.page.lookup("#product_7");
		product_8 = (VBox) this.page.lookup("#product_8");

		if (itr.hasNext()) {
			ProductModel product = new ProductModel(itr.next());
			product_0 = new VBoxProduct(product_0.getId(), product).getVBox();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {		
		System.out.println("id = " + product_3n.getId());
		System.out.println("properties = " + product_3n.getProperties());
		System.out.println("children = " + product_3n.getChildren());
	}	

	@FXML
	private void clickProduct(ActionEvent event) {
		// Button was clicked, do something...
		//outputTextArea.appendText("Button Action\n");
	}
	/*
	public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        //personTable.setItems(mainApp.getPersonData());
    }
	 */
}