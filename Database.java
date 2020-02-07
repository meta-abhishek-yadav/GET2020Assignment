package com.abhi;

import org.json.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
import javax.xml.bind.annotation.XmlRootElement;

public class Database {
	
	ArrayList<Book> list=new ArrayList<Book>();
	public Database()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from book");
		while(rs.next())
		{
		Book book=new Book();
		book.setId(rs.getInt(1));
		book.setTitle(rs.getString(2));
		book.setWriter(rs.getString(3));
		book.setPublisher(rs.getString(4));
		book.setPublishedYear(rs.getInt(5));
		list.add(book);
		}
		con.close();

		}
		catch(Exception e){}
	}
	/**
	 * @return list of inventory contains details of fruits and their quantity
	 */
	public ArrayList<Book>  showAll()
	{
		return list;
	}
	/**
	 * @return message after addition the book to Database according to book title
	 */
	public String add(String title,Book book)
	{
		int i=0,length=list.size(),find=0;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getTitle().equalsIgnoreCase(title))
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
				PreparedStatement pstmt=con.prepareStatement("update book set id=? ,title=?,writer=?,publisher=?,publishedyear=?  where title=?");
				pstmt.setInt(1,book.getId());
				pstmt.setString(2, book.getTitle());
				pstmt.setString(3, book.getWriter());
				pstmt.setString(4, book.getPublisher());
				pstmt.setInt(5,book.getPublishedYear());
				pstmt.setString(6, book.getTitle());

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
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
			PreparedStatement pstmt1=con1.prepareStatement("insert into book values(?,?,?,?,?)");
			
			pstmt1.setInt(1,book.getId());
			pstmt1.setString(2, book.getTitle());
			pstmt1.setString(3, book.getWriter());
			pstmt1.setString(4, book.getPublisher());
			pstmt1.setInt(5,book.getPublishedYear());
			pstmt1.executeUpdate();
			con1.close();

			}
			catch(Exception e){}
		}
		return "Added Successfully";
		
	}

	/**
	 * this method update data as id of book
	 * @param id of book to update
	 * @param book the details of book in object form
	 * @return message of update
	 */
	public String update(int id,Book book)
	{
		int i=0,length=list.size(),find=0;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getId()==(id))
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
					PreparedStatement pstmt=con.prepareStatement("update book set id=? ,title=?,writer=?,publisher=?,publishedyear=?  where id=?");
					pstmt.setInt(1,book.getId());
					pstmt.setString(2, book.getTitle());
					pstmt.setString(3, book.getWriter());
					pstmt.setString(4, book.getPublisher());
					pstmt.setInt(5,book.getPublishedYear());
					pstmt.setInt(6, book.getId());
					pstmt.executeUpdate();
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
		return "updated Successfully by id";
		}
	}
	/**
	 * 
	 * @param title of the book to show 
	 * @return the details of book
	 */
	public Book show(String title)
	{
		Book book=null;
		int i=0,length=list.size(),quantity=-1;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getTitle().equalsIgnoreCase(title))
			{
				book=list.get(i);
				break;
			}
		}
		return book;
	}
	/**
	 * @return message after adding books to database
	 */
	public String deleteAll()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
		PreparedStatement pstmt1=con1.prepareStatement("DELETE FROM book");
		pstmt1.execute();
		con1.close();

		}
		catch(Exception e){}
		return "Deleted table Successfully";
	}
	/**
	 * @return message after deletion of books from database according to book id
	 */
	public String delete(int id)
	{
		int i=0,length=list.size(),find=0;
		for(i=0;i<length;i++)
		{
			if(list.get(i).getId()==(id))
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con1 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/bookstore", "root", "abhishek");
				PreparedStatement pstmt1=con1.prepareStatement("DELETE FROM book where id=?");
				pstmt1.setInt(1,id);
				pstmt1.executeUpdate();
				con1.close();
				find=1;
				break;
				}
				catch(Exception e){}
				
			}
		}
		if(find==1)
		{
			return "Deleted Successfully by id";
		}
		else
		{
		return "Element not found";
		}
	}
}
