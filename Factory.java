package assignment_9;

import java.util.ArrayList;
import java.util.Date;



/**
 * Factory method create the object of and return as shape to user without showing the specific shape object
 * @author Abhishek
 */
class Factory
{
	/**
	 * createShape method create the object of specific class using switch case 
	 * this method return the object of specific class as object of its parents class  
	 * @param shapeName is name of shape of which we have to create object
	 * @param point object of point class that hold the origin values
	 * @param dimensions arrayList of dimensions of shape we have to create
	 * @return object of specific class as parent class object
	 */
	public static IShape createShape(String shapeName,Point point,ArrayList<Integer> dimensions)
	{
		IShape shape=null;
		switch(shapeName.toUpperCase())
		{
		case "TRIANGLE":
			shape=new Triangle(point.getXOrigin(),point.getYOrigin(),dimensions.get(0),dimensions.get(1),new Date());
			Screen.addShape(shape);
			break;
		case "RECTANGLE":
			shape=new Rectangle(point.getXOrigin(),point.getYOrigin(),dimensions.get(0),dimensions.get(1),new Date());
			Screen.addShape(shape);
			break;
		case "CIRCLE":
			shape =new Circle(point.getXOrigin(),point.getYOrigin(),dimensions.get(0),new Date());
			Screen.addShape(shape);
			break;
		case "SQUARE":
			shape =new Square(point.getXOrigin(),point.getYOrigin(),dimensions.get(0),new Date());
			Screen.addShape(shape);
			break;
		}
		return shape;
	}
}
