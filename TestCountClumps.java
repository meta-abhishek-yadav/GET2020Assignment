import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class TestCountClumps {
	

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 2, new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 4, 4 ))}, { 2, new ArrayList<Integer>(Arrays.asList(1, 1, 2, 1, 1)) }, { 1,  new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)) }  
           });
    }
    
   
    private int output;
    ArrayList<Integer> input=new ArrayList<Integer>();
	ArrOperation arroperationobject=new ArrOperation();

    public TestCountClumps(int output,ArrayList<Integer> input) {
        this.input = input;
        this.output = output;
    }
    /**
     * test method to all positive values
     */
    @Test
    public void generalTestCase() {
        assertEquals(output, arroperationobject.countClumps(input));
    }
   
    
}