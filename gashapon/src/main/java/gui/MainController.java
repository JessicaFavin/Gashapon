package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import exception.InitException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vendingMachine.Product;
import vendingMachine.VendingMachine;

public class MainController implements Initializable {

	// Products id
	@FXML private Label id_1;
	@FXML private Label id_2;
	@FXML private Label id_3;
	@FXML private Label id_4;
	@FXML private Label id_5;
	@FXML private Label id_6;
	@FXML private Label id_7;
	@FXML private Label id_8;
	@FXML private Label id_9;
	
	// Products price
	@FXML private Label price_1;
	@FXML private Label price_2;
	@FXML private Label price_3;
	@FXML private Label price_4;
	@FXML private Label price_5;
	@FXML private Label price_6;
	@FXML private Label price_7;
	@FXML private Label price_8;
	@FXML private Label price_9;
	
	// Products image
	@FXML private ImageView img_1;
	@FXML private ImageView img_2;
	@FXML private ImageView img_3;
	@FXML private ImageView img_4;
	@FXML private ImageView img_5;
	@FXML private ImageView img_6;
	@FXML private ImageView img_7;
	@FXML private ImageView img_8;
	@FXML private ImageView img_9;
	
	// Text area where you see what was written
	@FXML private TextArea order_field;
	
	// Order buttons
	@FXML private Button button_1;
	@FXML private Button button_2;
	@FXML private Button button_3;
	@FXML private Button button_4;
	@FXML private Button button_5;
	@FXML private Button button_6;
	@FXML private Button button_7;
	@FXML private Button button_8;
	@FXML private Button button_9;
	@FXML private Button button_v;
	@FXML private Button button_p;
	@FXML private Button button_c;
	
	// Coins and bills
	@FXML private Button coin_0_50;
	@FXML private Button coin_1;
	@FXML private Button coin_2;
	@FXML private Button coin_5;
	@FXML private Button coin_10;
	@FXML private Button coin_20;
	

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
			System.out.println("The products array does not contain enough products (9)");
		}
		
		initView(products);
		initOrderButtonAction();
		
	}
	
	private void initView(ArrayList<Product> products) {
		String path = "../../../ressources/img/";
		
		Iterator<Product> itr = products.iterator();
		Product product;
		
		if (itr.hasNext()) {
			product = itr.next();
			price_1.setText(product.getPrice() + " €");
			id_1.setText("" + product.getId());
			//img_1.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_2.setText(product.getPrice() + " €");
			id_2.setText("" + product.getId());
			//img_2.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_3.setText(product.getPrice() + " €");
			id_3.setText("" + product.getId());
			//img_3.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_4.setText(product.getPrice() + " €");
			id_4.setText("" + product.getId());
			//img_4.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_5.setText(product.getPrice() + " €");
			id_5.setText("" + product.getId());
			//img_5.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_6.setText(product.getPrice() + " €");
			id_6.setText("" + product.getId());
			//img_6.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_7.setText(product.getPrice() + " €");
			id_7.setText("" + product.getId());
			//img_7.setImage(new Image(path + product.getImg()));
		}
		
		if (itr.hasNext()) {
			product = itr.next();
			price_8.setText(product.getPrice() + " €");
			id_8.setText("" + product.getId());
			//img_8.setImage(new Image(path + product.getImg()));
		}

		if (itr.hasNext()) {
			product = itr.next();
			price_9.setText(product.getPrice() + " €");
			id_9.setText("" + product.getId());
			//img_9.setImage(new Image(path + product.getImg()));
		}
	}
	
	private void initOrderButtonAction() {
		button_1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        order_field.setText(order_field.getText() + "1");
		    }
		});
	}
}
