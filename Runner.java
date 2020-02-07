package com.abhi;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.ArrayList;
import org.json.*;
import com.abhi.Book;

@Path("/book")
public class Runner {
	Database database=new Database();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> showAll()
	{
	
		 return database.showAll();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{title}")
	public Book show(@PathParam("title") String title)
	{
		return database.show(title);
	}

	@POST
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public String add(@PathParam("title") String title,Book book)
	{
		return database.add(title,book);	
	}
	
	/*@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{title}")
	public String update(@PathParam("title") String title,Book book)
	{
		return database.update(title,book);
	}*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String update(@PathParam("id") int id,Book books)
	{
		return database.update(id,books);
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAll()
	{
		return database.deleteAll();
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String delete(@PathParam("id") int id)
	{
		return database.delete(id);
	}

}
