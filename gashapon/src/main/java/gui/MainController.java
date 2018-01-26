package gui;

import java.io.File;
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
import javafx.scene.effect.GaussianBlur;
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
	private static String order = "";
	private static boolean gaveChange = false;
	private static boolean paymentPhase = false;
	
	private ArrayList<Product> products = new ArrayList<Product>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// create products
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


		Iterator<Product> itr = products.iterator();

		if (itr.hasNext()) {
			setProduct(itr.next(), price_1, id_1, img_1);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_2, id_2, img_2);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_3, id_3, img_3);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_3, id_4, img_4);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_5, id_5, img_5);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_6, id_6, img_6);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_7, id_7, img_7);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_8, id_8, img_8);
		}

		if (itr.hasNext()) {
			setProduct(itr.next(), price_9, id_9, img_9);
		}
	}

	private void setProduct(Product product, Label price, Label id, ImageView img) {
		String path = "@./../img/";
		
		price.setText(product.getPrice() + " €");
		id.setText("" + product.getId());
		img.setImage(new Image(path + product.getImg()));
	}

	private void initOrderButtonAction() {
		button_1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("1");
				}
		});

		button_2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("2");
			}
		});

		button_3.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("3");
			}
		});

		button_4.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("4");
			}
		});

		button_5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("5");
			}
		});

		button_6.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("6");
			}
		});

		button_7.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("7");
			}
		});

		button_8.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("8");
			}
		});

		button_9.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				buttonAction("9");
			}
		});

		button_v.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if(!paymentPhase) {
					try {
						String[] orderArray = order.split(" ");
						for(String product : orderArray) {
							if(!product.contains("+") && !product.isEmpty() && !product.contains(" ")) {
								int productId = Integer.parseInt(product);
								vendingMachine.stateAddProduct(productId, 1);
								price += vendingMachine.getPrice(productId);
							}
						}
						paymentPhase = true;
						order_field.setText("price: " + price + "€");
						change_field.setText(price-payment + "€ left");
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
			}
		});

		// add product
		button_p.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				// can not use '+', create error, linked to regex
				order += " + ";
			}
		});

		button_c.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				// erase all
				order = "";
				order_field.setText("");
				change_field.setText("");
				price = 0;
				payment = 0;
				change = 0;
				paymentPhase = false;
				gaveChange = false;
				try {
					vendingMachine.stateCancelOrder();
				} catch (SoldOutException e1) {
					System.err.println("Button C Action - At least one product is sold out.");
					e1.printStackTrace();
				}
			}
		});
	}

	private void buttonAction(String n) {
		if(!paymentPhase) {
			order += n;
			order_field.setText(n);
			if (gaveChange) {
				change_field.setText("");
				gaveChange = false;
			}
		}
	}

	private void initCoinButton() {
		coin_0_50.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(0.5);
			}
		});

		coin_1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(1);
			}
		});

		coin_2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(2);
			}
		});

		coin_5.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(5);
			}
		});

		coin_10.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(10);
			}
		});

		coin_20.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				coinAction(20);
			}
		});
	}

	private void coinAction(double coin) {
		payment += coin;
		checkPayment();
	}

	private void checkPayment() {
		if(payment >= price) {
			if(price == 0) {
				change = payment - price;
				change_field.setText("in: " + change + " €");
			} else {
				giveChange();
			}
		}
	}

	private void giveChange() {
		change = payment - price;
		this.vendingMachine.addCash(price);
		try {
			this.vendingMachine.stateRetriveOrder();
			this.vendingMachine.statePayOrder(payment);
		} catch (SoldOutException e) {
			System.err.println("GiveCHange - At least one product is sold out.");
			setImageSoldOut();
			e.printStackTrace();
		}

		change_field.setText("give " + change + " €");
		order_field.setText("");
		//change_field.setText("");
		price = 0;
		payment = 0;
		change = 0;
		gaveChange = true;
		paymentPhase = false;
		order = "";

		System.out.println(vendingMachine.printContent());
	}
	
	private void setImageSoldOut() {
		
		for(Product p : products) {
			if(p.getQuantity() == 0) {
				switch(p.getId()) {
					case 1:
						img_1.setEffect(new GaussianBlur());
						id_1.setEffect(new GaussianBlur());
						price_1.setEffect(new GaussianBlur());
						break;
					case 2:
						img_2.setEffect(new GaussianBlur());
						id_2.setEffect(new GaussianBlur());
						price_2.setEffect(new GaussianBlur());
						break;
					case 3:
						img_3.setEffect(new GaussianBlur());
						id_3.setEffect(new GaussianBlur());
						price_3.setEffect(new GaussianBlur());
						break;
					case 4:
						img_4.setEffect(new GaussianBlur());
						id_4.setEffect(new GaussianBlur());
						price_4.setEffect(new GaussianBlur());
						break;
					case 5:
						img_5.setEffect(new GaussianBlur());
						id_5.setEffect(new GaussianBlur());
						price_5.setEffect(new GaussianBlur());
						break;
					case 6:
						img_6.setEffect(new GaussianBlur());
						id_6.setEffect(new GaussianBlur());
						price_6.setEffect(new GaussianBlur());
						break;
					case 7:
						img_7.setEffect(new GaussianBlur());
						id_7.setEffect(new GaussianBlur());
						price_7.setEffect(new GaussianBlur());
						break;
					case 8:
						img_8.setEffect(new GaussianBlur());
						id_8.setEffect(new GaussianBlur());
						price_8.setEffect(new GaussianBlur());
						break;
					case 9:
						img_9.setEffect(new GaussianBlur());
						id_9.setEffect(new GaussianBlur());
						price_9.setEffect(new GaussianBlur());
						break;
					default:
						System.out.println("No case Found for blurring image");						
				}	
			}
			
		}
	}
}
