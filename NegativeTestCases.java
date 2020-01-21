import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class NegativeTestCases {
	ArrOperation arroperationobject=new ArrOperation();

	 /**
     * test case for empty list for fixXY method in ArrOperation class 
     * 
     */
    @Test(expected =AssertionError.class)
    public void fixXYCheckedForEmptyList() {
        arroperationobject.fixXY(new ArrayList<Integer>(Arrays.asList( )),4,5);
    }
    
    /**
     * test case for not equal number of x and y in fixXY method
     * 
     */
    @Test(expected =AssertionError.class)
    public void fixXYCheckedForNotEqualNumberOfXandY() {
    	ArrOperation ao=new ArrOperation();
    	arroperationobject.fixXY(new ArrayList<Integer>(Arrays.asList(5, 4, 9, 4, 5, 5 )),4,5);
    }
    /**
     * test case for x at last index in fixXY method
     * 
     */
    @Test(expected =AssertionError.class)
    public void fixXYCheckedForXAtLastIndex() {
    	ArrOperation ao=new ArrOperation();
    	arroperationobject.fixXY(new ArrayList<Integer>(Arrays.asList(5, 4, 9, 5, 9, 4 )),4,5);
    }
    /**
     * test case for adjacent x in list in fixXY method
     * 
     */
    @Test(expected =AssertionError.class)
    public void fixXYCheckedForAdjacentX() {
    	arroperationobject.fixXY(new ArrayList<Integer>(Arrays.asList(5, 4, 4, 9, 9, 5 )),4,5);
    }
   
    /**
     * test case for empty list for maxMirror method in ArrOperation class
     */
    @Test(expected =AssertionError.class)
    public void maxMirroCcheckedForEmptyList() {
    	arroperationobject.maxMirror(new ArrayList<Integer>(Arrays.asList()));
    }
    /**
     * test case for empty list for splitArray method in ArrOperation class
     */
    @Test(expected =AssertionError.class)
    public void splitArrayCheckedForEmptyList() {
    	arroperationobject.maxMirror(new ArrayList<Integer>(Arrays.asList( )));
    }
  
    /**
     * test case for empty list for countClumps method in ArrOperation class
     */
    @Test(expected =AssertionError.class)
    public void countClumpsCheckedForEmptyList() {
    	arroperationobject.maxMirror(new ArrayList<Integer>(Arrays.asList( )));
    }
  
}
