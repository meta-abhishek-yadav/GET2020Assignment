package assignment_9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestShape
{
	Point point=new Point(0,0);
	IShape triangle=Factory.createShape("triangle",point,new ArrayList<Integer>(Arrays.asList(10,20)));
	IShape rectangle=Factory.createShape("rectangle",point,new ArrayList<Integer>(Arrays.asList(20,30)));
	IShape square=Factory.createShape("square",point,new ArrayList<Integer>(Arrays.asList(40)));
	IShape circle=Factory.createShape("circle",point,new ArrayList<Integer>(Arrays.asList(10)));
	ArrayList<IShape> shapesInSortedOrder=new ArrayList<IShape>(Arrays.asList());
@Test
public void testCaseForTriangleGetAreaMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(100.0,triangle.getArea(),0.01);
}

@Test
public void testCaseForRectangleGetAreaMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(600.0,rectangle.getArea(),0.01);
}

@Test
public void testCaseForSquareGetAreaMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(1600.0,square.getArea(),0.01);
}

@Test
public void testCaseForcircleGetAreaMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(314.0,circle.getArea(),0.01);
}

@Test
public void testCaseForTriangleGetPerimeterMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(52.36,triangle.getPerimeter(),0.01);
}

@Test
public void testCaseForRectangleGetPerimeterMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(100,rectangle.getPerimeter(),0.01);
}

@Test
public void testCaseForSquareGetPerimeterMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(160.0,square.getPerimeter(),0.01);
}

@Test
public void testCaseForcircleGetPerimeterMethodWhenValueIsPassedAsArrayListAndExpectedResultISPositive()
{
	assertEquals(62.80,circle.getPerimeter(),0.01);
}


}
