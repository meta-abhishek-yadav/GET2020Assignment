package assignment_9;

import java.util.ArrayList;
import java.util.Arrays;



public class Graphics {

	public static void main(String[] args)
	{
		Point point=new Point(0,0);
		IShape shape1=Factory.createShape("triangle",point,new ArrayList<Integer>(Arrays.asList(10,20)));
		IShape shape2=Factory.createShape("rectangle",point,new ArrayList<Integer>(Arrays.asList(157,29)));
		IShape shape3=Factory.createShape("square",point,new ArrayList<Integer>(Arrays.asList(40)));
		IShape shape4=Factory.createShape("circle",point,new ArrayList<Integer>(Arrays.asList(10)));
		
		System.out.println(shape1.getArea()+" "+shape1.getPerimeter());
		System.out.println(shape2.getArea()+" "+shape2.getPerimeter());
		System.out.println(shape3.getArea()+" "+shape3.getPerimeter());
		System.out.println(shape4.getArea()+" "+shape4.getPerimeter());
		ArrayList<IShape> list=Screen.shapesInSortedOrder();
		System.out.println(list);
		System.out.println(Screen.showShapes());
		Screen.removeAllShapeOfOneType(shape1);
		System.out.println(Screen.showShapes());
	}

}
