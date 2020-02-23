package assignment_9;

import java.util.*;
/**
 * Screen class is used to plot the shape virtually on screen 
 * @author Abhishek
 */
class Screen
{
	private static ArrayList<IShape> createdShapes=new ArrayList<IShape>();
	/**
	 * @param shape object of shape to add on screen 
	 */
	public static  void addShape(IShape shape)
	{
		createdShapes.add(shape);
	}
	/**
	 * @param shape object of shape to remove from screen
	 */
	public static void removeShape(IShape shape)
	{
		createdShapes.remove(shape);
	}
	/**
	 * this method remove the shape and all same type of same from screen using the shape object
	 * @param shape object of shape which have to remove from screen and all the shape of that type of shape have to remove from screen
	 */
	public static void removeAllShapeOfOneType(IShape shape)
	{
		for(int i=0;i<createdShapes.size();i++)
		{
			if(shape.getClass()==createdShapes.get(i).getClass())
			{
				createdShapes.remove(i);
				i--;
			}
		}
	}
	/** 
	 * this method return the arrayList containing  objects of all shapes which are enclosing the point 
	 * @param xCoordinate the position of point at xAxis 
	 * @param yCoordinate the position of point at yAxis 
	 * @return arrayList of object of shapes
	 */
	public static ArrayList<IShape> shapesEnclosingPoint(int xCoordinate,int yCoordinate)
	{
		ArrayList<IShape> enclosingShapes=new ArrayList<IShape>();
		for(int i=0;i<createdShapes.size();i++)
		{
			ArrayList<Integer> origin=createdShapes.get(i).getOrigin();
			ArrayList<Integer> dimension=createdShapes.get(i).getDimension();
			int code=dimension.get(0);
			System.out.println(code+"   "+origin+"  "+dimension);

			if(code==1)
			{
				if((Math.abs(xCoordinate -origin.get(0))<=dimension.get(1))&& (Math.abs(yCoordinate-origin.get(1))<=dimension.get(1)))
				{
					enclosingShapes.add(createdShapes.get(i));
				}
			}
			else if(code==2)
			{
				if((xCoordinate>=origin.get(0) && xCoordinate<=(origin.get(0)+dimension.get(1))) && (yCoordinate>=origin.get(1) && (yCoordinate<=(origin.get(1)+dimension.get(2)))))
				{
					enclosingShapes.add(createdShapes.get(i));
				}
			}
			else if(code==3)
			{
				if(((xCoordinate-origin.get(0))<dimension.get(1)) && ((xCoordinate-origin.get(0))>0) && ((yCoordinate-origin.get(1))<dimension.get(2))&& ((yCoordinate-origin.get(1))>0))
				{
					double slope=(dimension.get(2)-origin.get(1))/(dimension.get(1)-origin.get(0));
					double yResult=slope*(xCoordinate-origin.get(0));
					yResult=yResult+origin.get(1);
					if(yResult>=yCoordinate && yResult>=0)
					{
						enclosingShapes.add(createdShapes.get(i));
					}
				}
			}
			else if(code==4)
			{
				if((xCoordinate>=origin.get(0) && ((xCoordinate-origin.get(0))<=dimension.get(1))) && (yCoordinate>=origin.get(0) && ((yCoordinate-origin.get(0))<=dimension.get(1))))
					{
							enclosingShapes.add(createdShapes.get(i));
					}
				
			}
		}
		return enclosingShapes;
	}
	/**
	 * this method sort all the shapes as the ShapeComparator defined by user
	 * @return arryaList of objects of all shapes in sorted order as shapeComparator
	 */
	public static ArrayList<IShape> shapesInSortedOrder()
	{
		Collections.sort(createdShapes,new ShapeComparator());
		return createdShapes;
	}
	/**
	 * @return ArrayList of objects of all shapes 
	 */
	public static ArrayList<IShape> showShapes()
	{
		return createdShapes;
	}
}