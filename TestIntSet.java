package Assignment6;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestIntSet 
{
	IntSet set1=new IntSet(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)));
	IntSet set2=new IntSet(new ArrayList<Integer>(Arrays.asList(1,3,6)));
	IntSet set3=new IntSet(new ArrayList<Integer>(Arrays.asList(3,5,2,7)));

	@Test
	public void testCaseToCheck5isItemOfSet1AndTheExpectedResultIsTrue()
	{
		assertEquals(true,set1.isMember(5));
	}
	
	@Test
	public void testCaseToCheck7IsMemberOfSet1AndTheExpectedResultIsTrue()
	{
		assertEquals(false,set1.isMember(7));
	}
	
	@Test
	public void testCaseToGetSizeOfGivenSet()
	{
		assertEquals(6,set1.size());
	}
	@Test
	public void testCaseToCheckSet2IsSubsetOfSet1AndTheExpectedResultIsTrue()
	{
		assertEquals(true,set1.isSubSet(set2));
	}
	@Test
	public void testCaseToCheckSet3IsSubsetOfSet1AndTheExpectedResultIsFalse()
	{
		assertEquals(false,set1.isSubSet(set3));		
	}
	@Test
	public void testCaseToFindComplementOfGivenSetMethodSet1AndSet2()
	{
		ArrayList<Integer> union=new ArrayList<Integer>(Arrays.asList(1,2,3,6,4,5));
		assertEquals(union,set1.union(set1,set2));		
	}
	@Test
	public void testCaseTOFindComplementOfGivenSetMethod()
	{
		ArrayList<Integer> complement=new ArrayList<Integer>();
		for(int i=7;i<=1000;i++)
		{
			complement.add(i);
		}
		assertEquals(complement,set1.getComplement());		

	}
	
	
}

