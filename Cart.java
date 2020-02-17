package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;
import product.*;
public class Cart extends CartModel {
	/**
	 * @param itemCode code of item
	 * @param quantity of items to add in cart
	 * @return the status message after addition 
	 */
	public String addElementToCart(int itemCode,int quantity)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cart", "root", "abhishek");
		Statement statement = con.createStatement();
		int quant=0;
		ResultSet rs=statement.executeQuery("select * from product");
		int find=0;
		while(rs.next())
		{
		if(rs.getInt(1)==itemCode)
		{
			find=1;
			quant=rs.getInt(5);
			break;
		}
		}
		Product product=new Product();
		PreparedStatement pstmt;
		if(find==0)
		{
			pstmt=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			pstmt.setInt(1, itemCode);
			pstmt.setString(2, product.getName(itemCode));
			pstmt.setString(3, product.getType(itemCode));
			pstmt.setInt(4, product.getPrice(itemCode));
			pstmt.setInt(5, quantity);
			pstmt.setInt(6, product.getPrice(itemCode)*quantity);
		}
		else
		{
			pstmt=con.prepareStatement("update product set quantity=? where code=?");
			pstmt.setInt(2, itemCode);
			pstmt.setInt(1, quantity+quant);
		}

		pstmt.executeUpdate();
		}
		catch(Exception e){}
		return "Item Added Successfully";
	}
	/** 
	 * return list of objects of product to cart
	 */
	public ArrayList<Product> showCart()
	{
		ArrayList<Product> list=new ArrayList<Product>();

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cart", "root", "abhishek");
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from product");
		while(rs.next())
		{
			Product product=new Product();
			product.setCode(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setType(rs.getString(3));
			product.setPrice(rs.getInt(4));
			product.setQuantity(rs.getInt(5));
			product.setTotalCost(rs.getInt(6));
			list.add(product);
		}
		}
		catch(Exception e){}
		return list;
	}
	/**
	 * @param itemCode code of item
	 * @param quantity of items to add in cart
	 * @return the status message after update 
	 */
	public String updateElementToCart(int itemCode ,int quantity)
	{
		String returnString="";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cart", "root", "abhishek");
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from product");
		int find=0;
		while(rs.next())
		{
		if(rs.getInt(1)==itemCode)
		{
			find=1;
			break;
		}
		}
		Product product=new Product();
		if(find==0)
		{			
			returnString="Item is not in cart Please Add it first";
		}
		else
		{	
			PreparedStatement pstmt=con.prepareStatement("update product set quantity=? where code=?");
			pstmt.setInt(2, itemCode);
			pstmt.setInt(1, quantity);
			pstmt.executeUpdate();
			returnString="Item Updated Successfully";
		}
		}
		catch(Exception e){}
		return returnString;
	}
	/**
	 * @param itemCode code of item
	 * @return the status message after deletion of element 
	 */
	public String RemoveElementFromCart(int itemCode)
	{
		String returnString="Item not found in cart";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cart", "root", "abhishek");
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from product");
		int find=0;
		while(rs.next())
		{
		if(rs.getInt(1)==itemCode)
		{
			PreparedStatement pstmt=con.prepareStatement("DELETE FROM product where code=?");
			pstmt.setInt(1, itemCode);
			pstmt.executeUpdate();
			returnString="Item Deleted";	
			break;
			}
		}
		}
		catch(Exception e){}
		return returnString;
	}

}
