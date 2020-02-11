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
public class TestSplitArray {
	 @Parameters
	    public static Collection<Object[]> data1() {
	        return Arrays.asList(new Object[][] {     
	                 { new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 1 )),2}, {  new ArrayList<Integer>(Arrays.asList(2, 1, 1, 2, 1)), -1}, { new ArrayList<Integer>(Arrays.asList(1,2,1,4)),2 },{  new ArrayList<Integer>(Arrays.asList(10,10)), 0}  
	           });
	    }
	    private int output;
	    ArrayList<Integer> input=new ArrayList<Integer>();
    	ArrOperation arroperationobject=new ArrOperation();

	    public TestSplitArray(ArrayList<Integer> input,int output) {
	        this.input = input;
	        this.output = output;
	    }
	    /**
	     * test method to all positive values
	     */
	    @Test
	    public void generalTestCase() {
	        assertEquals(output, arroperationobject.splitArray(input));
	    }
	   
}
