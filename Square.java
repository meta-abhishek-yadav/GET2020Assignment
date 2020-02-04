package assignment_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Square class implements the ishape interface and implement all the method of shape as same signature but according Square class functionality
 * @author Abhishek
 */
class Square implements IShape
{
	int xOrigin,yOrigin,side;
	Date timeStamp;

	public Square(int xOrigin,int yOrigin,int side,Date timeStamp)
	{
		this.xOrigin=xOrigin;	
		this.yOrigin=xOrigin;
		this.side=side;
		this.timeStamp=timeStamp;
	}
	public double getArea()
	{
		return (side*side);
	}
	public double getPerimeter()
	{
		return (4*side);
	}
	public ArrayList<Integer> getOrigin()
	{
		ArrayList<Integer> origin=new ArrayList<Integer>(Arrays.asList(xOrigin,yOrigin));
		return origin;
	}
	public Date getTimeStamp()
	{
		return timeStamp;
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
	public ArrayList<Integer> getDimension()
	{
		return new ArrayList<Integer>(Arrays.asList(4,side));
	}
	public double originDistance()
	{
		return Math.sqrt((xOrigin*xOrigin+yOrigin*yOrigin));
	}
}