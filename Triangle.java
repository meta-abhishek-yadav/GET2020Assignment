package assignment_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Triangle class implements the ishape interface and implement all the method of shape as same signature but according Triangle class functionality
 * @author Abhishek
 */
class Triangle implements IShape
{
	int xOrigin,yOrigin,width,height;
	Date timeStamp;
	public Triangle(int xOrigin,int yOrigin,int width,int height,Date timeStamp)
	{
		this.xOrigin=xOrigin;	
		this.yOrigin=xOrigin;
		this.width=width;
		this.height=height;
		this.timeStamp=timeStamp;
	}
	public double getArea()
	{
		double half=0.5;
		return (half*width*height);
	}
	public double getPerimeter()
	{
		return height+width+Math.sqrt((width*width)+(height*height));
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
		return new ArrayList<Integer>(Arrays.asList(3,width,height));
	}
	public double originDistance()
	{
		return Math.sqrt((xOrigin*xOrigin+yOrigin*yOrigin));
	}
}
