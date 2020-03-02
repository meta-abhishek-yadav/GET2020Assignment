package controller;

import java.util.ArrayList;
import product.*;
import BusinessLogic.*;
public class Controller 
{
	Cart cart=new Cart();
	public ArrayList<Product> action()
	{
		return cart.showCart();
	}
	public String action(int actionCode,int itemCode,int quantity)
	{
		if(actionCode==1)
		{
		return cart.addElementToCart(itemCode,quantity);
		}
		else 
		{
		return cart.updateElementToCart(itemCode,quantity);
		}
	}
	public String action(int itemCode)
	{
		return cart.RemoveElementFromCart(itemCode);
	}
}
