package model;

import java.util.ArrayList;

import product.Product;

public abstract class CartModel {
	public abstract String addElementToCart(int itemCode,int quantity);
	public abstract String RemoveElementFromCart(int itemCode);
	public abstract ArrayList<Product> showCart();
	public abstract String updateElementToCart(int itemCode ,int quantity);
	
}

