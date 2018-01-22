package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vendingMachine.Product;

public class VBoxProduct{
	
	private final String id;
	/*
	private final double price;
	private final String img;
	private final int productId;
	*/
	
	private ProductModel product;
	
	private VBox vBox;
/*
	public VBoxProduct(String id, double price, String img, int productId){
		
		this.id = id;
		
		this.product = new ProductModel(productId, price, img);
		
		build();
	}
	*/
public VBoxProduct(String id, Product product){
		
		this.id = id;
		/*
		this.price = price;
		this.img = img;
		this.productId = productId;
		*/
		
		this.product = new ProductModel(product);
		
		build();
	}

public VBoxProduct(String id, ProductModel product){
	
	this.id = id;
	/*
	this.price = price;
	this.img = img;
	this.productId = productId;
	*/
	
	this.product = product;
	
	build();
}
	
	public void build() {
		//ImageView imageView = new ImageView(img);
		//HBox hBox = new HBox(new TextArea(""+productId), new TextArea(""+price));
		this.vBox = new VBox(
				/*new ImageView("@../../ressources/img/" + product.getImg()), */
				new HBox(
						new TextArea(""+product.getId()), 
						new TextArea(""+product.getPrice())
						)
				);
		this.vBox.setId(id);
	}
	
	public VBox getVBox() {
		return vBox;
	}
/*
	@SuppressWarnings("deprecation")
	public VBoxProduct(VBox vBox){
		System.out.println(vBox.getChildren());
		this.id = new SimpleStringProperty(vBox.getId());
		this.price = new SimpleDoubleProperty(
				Double.parseDouble(
						((TextArea)
								((HBox) 
										vBox.getChildren().get(1))
								.getChildren().get(1))
						.getText()
						.replaceAll(" ", "")
						.replaceAll("€", "")));
		this.img = new SimpleStringProperty(
				((ImageView) 
						vBox.getChildren().get(0))
				.getImage().impl_getUrl());
		this.productId = new SimpleIntegerProperty(
				((TextArea)
						((HBox) 
								vBox.getChildren().get(1))
						.getChildren().get(0))
				.getText());
	}
	*/
}
