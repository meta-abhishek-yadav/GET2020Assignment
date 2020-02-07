package com.abhi;
import org.json.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

import javax.xml.bind.annotation.XmlRootElement;

import com.abhi.Inventory;

public class Database {
	
	ArrayList<Inventory> list=new ArrayList<Inventory>();
	public Database()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from fruits");
		while(rs.next())
		{
		Inventory inven=new Inventory();
		inven.setName(rs.getString(1));
		inven.setQuantity(rs.getInt(2));
		list.add(inven);
		}
		con.close();

		}
		catch(Exception e){}
	}
	/**
	 * @return list of inventory contains details of fruits and their quantity
	 */
	public ArrayList<Inventory>  showAll()
	{
		return list;
	}
	/**
	 * @return message after addition the fruits to Database
	 */
	public String add(String name,Inventory fruit)
	{
		int i=0,length=list.size(),find=0;
		System.out.println(length+" "+name+" "+fruit.getName()+length);
		for(i=0;i<length;i++)
		{
			if(list.get(i).getName().equalsIgnoreCase(name))
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
				PreparedStatement pstmt=con.prepareStatement("update fruits set quantity=? where name=?");
				pstmt.setInt(1, list.get(i).getQuantity()+fruit.getQuantity());
				pstmt.setString(2, list.get(i).getName());
				pstmt.executeUpdate();
				con.close();
				find=1;
				break;
				}
				catch(Exception e){}
			}
		}
		if(find==0)
		{
			System.out.println("come till here2 "+name+" "+fruit.getQuantity()+"  "+fruit.getName());
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
			PreparedStatement pstmt1=con1.prepareStatement("insert into fruits values(?,?)");
			pstmt1.setString(1,fruit.getName());
			pstmt1.setInt(2,fruit.getQuantity());
			pstmt1.executeUpdate();
			con1.close();

			}
			catch(Exception e){}
		}
		return "Added Successfully";
		
	}
	/**
	 * this method update the database with list of fruits
	 * @return message after update the fruits to Database
	 */
	public String updateAll(ArrayList<Inventory> fruits)
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
		PreparedStatement pstmt1=con1.prepareStatement("DELETE FROM fruits");
		pstmt1.execute();
		for(int i=0;i<fruits.size();i++)
		{
			PreparedStatement pstmt2=con1.prepareStatement("insert into fruits values(?,?)");
			pstmt2.setString(1, fruits.get(i).getName());
			pstmt2.setInt(2, fruits.get(i).getQuantity());
			pstmt2.executeUpdate();
		}
		con1.close();

		}
		catch(Exception e){}

		return "updated Successfully";
	}
	/**
	 * this method update data as name of fruits
	 * @param name of fruit to update
	 * @param fruit the details of fruits in object form
	 * @return
	 */
	public String update(String name,Inventory fruit)
	{
		int i=0,length=list.size(),find=0;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getName().equalsIgnoreCase(name))
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/fruitTable", "root", "abhishek");
				PreparedStatement pstmt=con.prepareStatement("update fruits set quantity=? where name=?");
				pstmt.setInt(1, list.get(i).getQuantity()+fruit.getQuantity());
				pstmt.setString(2, list.get(i).getName());
				pstmt.executeUpdate();
				find=1;
				con.close();

				break;
				}
				catch(Exception e){}
			}
		}
		if(find==0)
		{
			return "Element not found";
		}
		else
		{
		return "updated Successfully";
		}
	}
	/**
	 * 
	 * @param name of the fruit to show 
	 * @return the quantity of fruits
	 */
	public int show(String name)
	{
		int i=0,length=list.size(),quantity=-1;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getName().equalsIgnoreCase(name))
			{
				quantity=list.get(i).getQuantity();
				break;
			}
		}
		return quantity;
	}
	/**
	 * @param fruits the list of fruits
	 * @return message after adding fruits to database
	 */
	public String addAll(ArrayList<Inventory> fruits)
	{

		int i=0,length=list.size(),find=0,j=0;
		System.out.println("it "+length+" "+fruits.size());

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
		for(j=0;j<fruits.size();j++)
		{
			find=0;
		for(i=0;i<length;i++)
		{
			System.out.println("it comes");

			if(list.get(i).getName().equalsIgnoreCase(fruits.get(j).getName()))
			{
				System.out.println("it not comes");

				PreparedStatement pstmt=con.prepareStatement("update fruits set quantity=? where name=?");
				pstmt.setInt(1, list.get(i).getQuantity()+fruits.get(j).getQuantity());
				pstmt.setString(2, list.get(i).getName());
				pstmt.executeUpdate();
				find=1;
				break;
			}
		}
		if(find==0)
		{
			System.out.println("it comes here");
			PreparedStatement pstmt1=con.prepareStatement("insert into fruits values(?,?)");
			pstmt1.setInt(2,fruits.get(j).getQuantity());
			pstmt1.setString(1, fruits.get(j).getName());
			pstmt1.executeUpdate();		
			System.out.println("it comes here also");
	
		}
		}
		con.close();
		}
		catch(Exception e){}
		return "Added Successfully";
	}
	/**
	 * @return message after deletion of fruits from database
	 */
	public String deleteAll()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
		PreparedStatement pstmt1=con1.prepareStatement("DELETE FROM fruits");
		pstmt1.executeUpdate();
		con1.close();

		}
		catch(Exception e){}
		return "Deleted Successfully";
	}
	/**
	 * @param name of fruit to delete from database
	 * @return the message after deletion
	 */
	public String delete(String name)
	{
		int i=0,length=list.size(),find=0;
		for(i=0;i<length;i++)
		{
			System.out.println(list.get(i).getName()+"  "+name);

			if(list.get(i).getName().equalsIgnoreCase(name))
			{
				System.out.println(list.get(i).getName()+"  "+name);

				try
				{
					find=1;

				Class.forName("com.mysql.jdbc.Driver");
				Connection con1 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/fruittable", "root", "abhishek");
				PreparedStatement pstmt1=con1.prepareStatement("DELETE FROM fruits where name= ?");
				pstmt1.setString(1,name);
				pstmt1.executeUpdate();
				con1.close();

				System.out.println(list.get(i).getName()+"  "+name);

				break;
				}
				catch(Exception e){}
				
			}
		}
		if(find==1)
		{
			return "Deleted Successfully";
		}
		else
		{
		return "Element not found";
		}
	}
}
