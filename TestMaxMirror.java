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
public class TestMaxMirror {
	 @Parameters
	    public static Collection<Object[]> data1() {
	        return Arrays.asList(new Object[][] {     
	                 { new ArrayList<Integer>(Arrays.asList(1,2,3,8,1,2,3,2,1,9,3,2,1 )),5}, {  new ArrayList<Integer>(Arrays.asList(7, 1, 4, 9, 7, 4, 1)), 2}, { new ArrayList<Integer>(Arrays.asList(1,2,1,4)),3 },{  new ArrayList<Integer>(Arrays.asList(1,2,3,4,3,2,1)), 7}  
	           });
	    }
	    private int output;
	    ArrayList<Integer> input=new ArrayList<Integer>();
    	ArrOperation arroperationobject=new ArrOperation();

	    public TestMaxMirror(ArrayList<Integer> input,int output) {
	        this.input = input;
	        this.output = output;
	    }
	    /**
	     * test method to all positive values
	     */
	    @Test
	    public void generalTestCase() {
	        assertEquals(output, arroperationobject.maxMirror(input));
	    }
	    

}
