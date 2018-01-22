package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vendingMachine.Product;

public class ProductModel {
	private final IntegerProperty id;
	private final DoubleProperty price;
	//private IntegerProperty quantity;
	private final StringProperty img;

	public ProductModel(int id, double price/*, int quantity*/, String img) {
		this.id = new SimpleIntegerProperty(id);
		this.price = new SimpleDoubleProperty(price);
		//this.quantity = new SimpleIntegerProperty(quantity);
		this.img = new SimpleStringProperty(img);
	}
	
	public ProductModel(Product product) {
		this.id = new SimpleIntegerProperty(product.getId());
		this.price = new SimpleDoubleProperty(product.getPrice());
		//this.quantity = new SimpleIntegerProperty(product.getQuantity());
		this.img = new SimpleStringProperty(product.getImg());
	}
	
	public int getId() {
		return this.id.get();
	}
	
	public double getPrice() {
		return this.price.get();
	}
	/*
	public int getQuantity() {
		return this.quantity.get();
	}
	*/
	public String getImg() {
		return this.img.get();
	}
	
	public String idToString() {
		if(id.get() < 10) {
			return "0" + this.id.get();
		}
		
		return "" + this.id.get();
	}
}
