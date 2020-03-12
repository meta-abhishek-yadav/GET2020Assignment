import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestfixXY {

    ArrayList<Integer> output=new ArrayList<Integer>();
    ArrayList<Integer> input=new ArrayList<Integer>();
	ArrOperation arroperationobject=new ArrOperation();

	 @Parameters
	    public static Collection<Object[]> data1()
	    {
	        return Arrays.asList(new Object[][] {     
	                 { new ArrayList<Integer>(Arrays.asList(5, 4, 9, 4, 9, 5 )),new ArrayList<Integer>(Arrays.asList(9,4,5,4,5,9))}, {  new ArrayList<Integer>(Arrays.asList(1,4,1,5)), new ArrayList<Integer>(Arrays.asList(1,4,5,1))}, { new ArrayList<Integer>(Arrays.asList(1,4,1,5,5,4,1)),new ArrayList<Integer>(Arrays.asList(1,4,5,1,1,4,5)) },{  new ArrayList<Integer>(Arrays.asList(5,4,5,4,5,4,6)), new ArrayList<Integer>(Arrays.asList(6,4,5,4,5,4,5))}
	           });
	    }
	  
	    public TestfixXY(ArrayList<Integer> input,ArrayList<Integer> output) {
	    	
	        this.input = input;
	        this.output = output;
	    }
	    /**
	     * test method to all positive values
	     */
	    @Test
    	public void generalTestCase()
    	{
        	assertEquals(output, arroperationobject.fixXY(input,4,5));
    	}
	   

}
