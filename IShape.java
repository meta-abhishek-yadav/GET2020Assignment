package assignment_9;

import java.util.ArrayList;
import java.util.Date;

/**
 * Shape interface contains all the layout and operation method of all shapes 
 *getArea() method return the Area of shape using their dimensions and origin
 *getPerimeter() method return the Perimeter of shape using their boundaries
 *getOrigin() method return the ArrayList containing xCoodinate at 0 index and yCoordinate at 1 index
 *isPointEnclosed() method return true if the origin of shape is enclosed by other shapes else return true
 *getTimeStamp() method the time when the shape was plotted on screen or created
 *getDimension() method return the ArrayList of boundaries of shape as list where a code is added at index 0 to specify the shape
 *originDistance() method return the distance of origin of shape from origin of screen(0,0)
 */
interface  IShape
{
	public  double  getArea();
	public  double getPerimeter();
	public  ArrayList<Integer> getOrigin();
	public  boolean isPointEnclosed();
	public Date getTimeStamp();
	public ArrayList<Integer> getDimension();
	public double originDistance();
	
}
