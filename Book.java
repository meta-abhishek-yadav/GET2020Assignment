package com.abhi;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int id;
	private int publishedYear;
	private String title;
	private String writer;
	private String publisher;
	public String getTitle()
	{
		return title;
	}
	public String getWriter()
	{
		return writer;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public int getId()
	{
		return id;
	}
	public int getPublishedYear()
	{
		return publishedYear;
	}
	public void setTitle(String title)
	{
		this.title= title;
	}
	public void setWriter(String writer)
	{
		this.writer= writer;
	}
	public void setPublisher(String publisher)
	{
		this.publisher= publisher;
	}
	public void setId(int id)
	{
		this.id= id;
	}
	public void setPublishedYear(int publishedYear)
	{
		this.publishedYear= publishedYear;
	}

}
