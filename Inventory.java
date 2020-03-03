package com.abhi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inventory {
	private String name;
	private int value;
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return value;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setQuantity(int quantity)
	{
		this.value=quantity;
		
	}
}
