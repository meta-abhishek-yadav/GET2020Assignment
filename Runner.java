package com.abhi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.abhi.Inventory;

import java.io.*;
import java.util.ArrayList;

import org.json.*;
 
@Path("/inventory")
public class Runner {
	Database database=new Database();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> showAll()
	{
	
		 return database.showAll();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public int show(@PathParam("name") String name)
	{
		return database.show(name);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addAll(ArrayList<Inventory> fruits)
	{
		
		return database.addAll(fruits);
		
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public String add(@PathParam("name") String name,Inventory inven)
	{
		return database.add(name,inven);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String updateAll(ArrayList<Inventory> fruits)
	{
		return database.updateAll(fruits);
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public String update(@PathParam("name") String name,Inventory fruit)
	{
		return database.update(name,fruit);
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAll()
	{
		return database.deleteAll();
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{name}")
	public String delete(@PathParam("name") String name)
	{
		return database.delete(name);
	}

}
