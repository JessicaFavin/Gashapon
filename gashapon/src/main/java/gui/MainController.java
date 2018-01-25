package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import exception.InitException;
import exception.NotEnoughProductException;
import exception.ProductDoesNotExistException;
import exception.SoldOutException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	@FXML private TextField order_field;

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

	// Text area where the change is given
	@FXML private TextField change_field;

	// Coins and bills
	@FXML private Button coin_0_50;
	@FXML private Button coin_1;
	@FXML private Button coin_2;
	@FXML private Button coin_5;
	@FXML private Button coin_10;
	@FXML private Button coin_20;

	private VendingMachine vendingMachine;
	private static double payment = 0;
	private static double price;
	private static double change = 0;


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
			vendingMachine = new VendingMachine(products);
		} catch(InitException e) {
			System.err.println("Initialize - The products array does not contain enough products (9)");
		}

		initView(products);
		initOrderButtonAction();
		initCoinButton();

		System.out.println(vendingMachine.printContent());
	}

	private void initView(ArrayList<Product> products) {
		String path = "../img/";

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

		button_2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "2");
			}
		});

		button_3.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "3");
			}
		});

		button_4.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "4");
			}
		});

		button_5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "5");
			}
		});

		button_6.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "6");
			}
		});

		button_7.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "7");
			}
		});

		button_8.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "8");
			}
		});

		button_9.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(order_field.getText() + "9");
			}
		});

		button_v.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				try {
					String[] order = order_field.getText().split(" ");
					for(String product : order) {
						if(!product.contains("+") && !product.isEmpty() && !product.contains(" ")) {
							int productId = Integer.parseInt(product);
							vendingMachine.stateAddProduct(productId, 1);
							price += vendingMachine.getPrice(productId);
						}
					}
					checkPayment();
				} catch(NotEnoughProductException ne) {
					System.err.println("Button V Action - The product is not available. productId = " + order_field.getText());
					change_field.setText("Product not available.");
				} catch (SoldOutException se) {
					System.err.println("Button V Action - At leat one product has been sold out. productId = " + order_field.getText());
				} catch (ProductDoesNotExistException pe) {
					System.err.println("Button V Action - The product does not exist. productId = " + order_field.getText());
				}catch (Exception ex) {
					ex.printStackTrace();
					System.err.println("Button V Action - Error in validation. productId = " + order_field.getText());
				}
			}
		});

		// add product
		button_p.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				// can not use '+', create error, linked to regex
				order_field.setText(order_field.getText() + " + "); 
			}
		});

		button_c.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				order_field.setText(""); // erase all
				try {
					vendingMachine.stateCancelOrder();
				} catch (SoldOutException e1) {
					System.err.println("Button C Action - At least one product is sold out.");
					e1.printStackTrace();
				}
			}
		});
	}

	private void initCoinButton() {
		coin_0_50.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 0.5;
				checkPayment();
			}
		});

		coin_1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 1;
				checkPayment();
			}
		});

		coin_2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 2;
				checkPayment();
			}
		});

		coin_5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 5;
				checkPayment();
			}
		});

		coin_10.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 10;
				checkPayment();
			}
		});

		coin_20.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				payment += 20;
				checkPayment();
			}
		});
	}

	private void checkPayment() {
		change_field.setText(price-payment + "€ left");
		if(payment >= price) {
			giveChange();
		}
	}

	private void giveChange() {
		change = payment - price;
		change_field.setText("give " + change + " €");
		this.vendingMachine.addCash(price);
		try {
			this.vendingMachine.stateRetriveOrder();
			this.vendingMachine.statePayOrder(payment);
		} catch (SoldOutException e) {
			System.err.println("GiveCHange - At least one product is sold out.");
			e.printStackTrace();
		}

		order_field.setText("");
		//change_field.setText("");
		price = 0;
		payment = 0;
		change = 0;

		System.out.println(vendingMachine.printContent());
	}
}
