package assignment5;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;
public class TestHcfLcm 
{
	@Test
	public void hcfTestCaseforNonDivisbleByEachOther()
	{
		LcmHcf lf=new LcmHcf();
		int y=lf.hcf(9,5);
		assertEquals(1,y);
	}
	@Test
	public void lcmTestCaseforNonDivisbleByEachOther()
	{
		LcmHcf lf=new LcmHcf();
		int x=lf.lcm(9,5);
		assertEquals(45,x);
	}
	
	@Test
	public void hcfTestCaseforDivisbleByEachOther()
	{
		LcmHcf lf=new LcmHcf();
		int y=lf.hcf(15,45);
		assertEquals(15,y);

	}
	
	@Test
	public void lcmTestCaseforDivisbleByEachOther()
	{
		LcmHcf lf=new LcmHcf();
		int x=lf.lcm(15,45);
		assertEquals(45,x);

	}
	
	
}
