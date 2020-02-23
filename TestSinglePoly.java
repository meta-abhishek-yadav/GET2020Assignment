package Assignment6;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestSinglePoly {
	SinglePoly poly1 = new SinglePoly(new ArrayList<Integer>(Arrays.asList(2,2, 3, 1, 1, 0)));
	SinglePoly poly2 = new SinglePoly(new ArrayList<Integer>(Arrays.asList(4,1, 9, 0)));

	@Test
	public void testCaseToFindOfGIvenPolynomialUsingDegreeMethod() {
		assertEquals(2, poly1.degree());
	}

	@Test
	public void testCaseToEvaluateValueOfPolynomialWhenvalueOfVariableIsPassed() {
		assertEquals(21.0, poly1.evaluate(2.5), 0.01);
	}

	@Test
	public void testCaseToAddPolyonomialPoly1andPoly2AndReturnTheAddition() {
		ArrayList<Integer> addition = new ArrayList<Integer>(Arrays.asList(2, 2, 7,1, 10, 0));
		assertEquals(addition, poly1.addPoly(poly1, poly2));
	}

	@Test
	public void testCaseToMultiplyPolyonomialPoly1andPoly2AndReturnTheAddition() {
		ArrayList<Integer> multiply = new ArrayList<Integer>(Arrays.asList(8,3, 30, 2, 31, 1, 9, 0));
		assertEquals(multiply, poly1.multiply(poly1, poly2));
	}

}
