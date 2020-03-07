package assignment_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Circle class implements the ishape interface and implement all the method of ishape as same signature but according Circle class functionality
 * @author Abhishek
 */
class Circle implements IShape
{
	int xOrigin,yOrigin,radius;
	Date timeStamp;

	public Circle(int xOrigin,int yOrigin,int radius,Date timeStamp)
	{
		this.xOrigin=xOrigin;	
		this.yOrigin=xOrigin;
		this.radius=radius;
		this.timeStamp=timeStamp;
	}
	public double getArea()
	{
		double pi=3.14;
		return (pi*radius*radius);
	}
	public double getPerimeter()
	{
		double pi=3.14;
		return (2*pi*radius);
	}
	public ArrayList<Integer> getOrigin()
	{
		ArrayList<Integer> origin=new ArrayList<Integer>(Arrays.asList(xOrigin,yOrigin));
		return origin;
	}
	public boolean isPointEnclosed()
	{
		ArrayList<IShape> shapes=Screen.shapesEnclosingPoint(xOrigin, yOrigin);
		if(shapes.size()>1)
		{
			return true;	
		}
		else
		{
			return false;
		}	}
	public Date getTimeStamp()
	{
		return timeStamp;
	}
	public ArrayList<Integer> getDimension()
	{
		return new ArrayList<Integer>(Arrays.asList(1,radius));
	}
	public double originDistance()
	{
		return Math.sqrt((xOrigin*xOrigin+yOrigin*yOrigin));
	}
}