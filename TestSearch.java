package assignment5;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;
public class TestSearch 
{
	@Test
	public void testCaseforLinearSearchItemFound()
	{
		Search s=new Search();
		ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1));
		int x=s.linearSearch(list,1,0);
		assertEquals(0,x);
	}
	@Test
	public void testCaseforBinarySearchItemFound()
	{
		Search s=new Search();
		ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1));
		int y=s.binarySearch(list,1,0,5);
		assertEquals(2,y);
	}
	@Test
	public void testCaseforLinearSearchItemNotFound()
	{
		Search s=new Search();
		ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		int x=s.linearSearch(list,8,0);
		assertEquals(-1,x);

	}
	@Test
	public void testCaseforBinarySearchItemNotFound()
	{
		Search s=new Search();
		ArrayList<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		int y=s.binarySearch(list,8,0,6);
		assertEquals(-1,y);

	}
	
	
	
}
