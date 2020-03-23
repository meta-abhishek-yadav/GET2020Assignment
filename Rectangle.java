package assignment_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Rectangle class implements the ishape interface and implement all the method of ishape as same signature but according Rectangle class functionality
 * @author Abhishek
 */
class Rectangle implements IShape
{
	int xOrigin,yOrigin,width,height;
	Date timeStamp;

	public Rectangle(int xOrigin,int yOrigin,int width,int height,Date timeStamp)
	{
		this.xOrigin=xOrigin;	
		this.yOrigin=xOrigin;
		this.width=width;
		this.height=height;
		this.timeStamp=timeStamp;
	}
	public double getArea()
	{
		return (width*height);
	}
	public double getPerimeter()
	{
		return 2*(height+width);
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
		}
	}
	public Date getTimeStamp()
	{
		return timeStamp;
	}
	public ArrayList<Integer> getDimension()
	{
		return new ArrayList<Integer>(Arrays.asList(2,width,height));
	}
	public double originDistance()
	{
		return Math.sqrt((xOrigin*xOrigin+yOrigin*yOrigin));
	}
}
