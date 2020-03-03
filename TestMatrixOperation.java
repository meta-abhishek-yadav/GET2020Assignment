package Assignment7;

import static org.junit.Assert.*;

import org.junit.*;

public class TestMatrixOperation
{
	static int noOfRows=4,noOfColumns=4,numberOfRow=2,numberOfColumn=2;
	static int matrix1[][]=new int[noOfRows][noOfColumns];
	static int matrix2[][]=new int[noOfRows][noOfColumns];
	static int matrix3[][]=new int[numberOfRow][numberOfColumn];
	static int transposeOfMatrix1[][]=new int[noOfRows][noOfColumns];
	static int additionMatrix[][]=new int[noOfRows][noOfColumns];
	static int multiplicationMatrix[][]=new int[noOfRows][noOfColumns];
	MatrixOperation matrixOperation1=new MatrixOperation(matrix1,noOfRows,noOfColumns);
	MatrixOperation matrixOperation2=new MatrixOperation(matrix2,noOfRows,noOfColumns);
	MatrixOperation matrixOperation3=new MatrixOperation(matrix3,numberOfRow,numberOfColumn);

	
	@BeforeClass
	public static void initilizeMatrix()
	{
		matrix3[1][1]=1;
		matrix3[0][1]=1;
		matrix3[0][0]=1;
		matrix2[3][1]=7;
		matrix2[1][3]=7;
		matrix1[1][2]=5;
		matrix1[1][3]=4;
		matrix1[2][3]=9;
		matrix1[3][3]=8;
		transposeOfMatrix1[2][1]=5;
		transposeOfMatrix1[3][1]=4;
		transposeOfMatrix1[3][2]=9;
		transposeOfMatrix1[3][3]=8;
		additionMatrix[3][1]=7;
		additionMatrix[1][3]=11;
		additionMatrix[1][2]=5;
		additionMatrix[2][3]=9;
		additionMatrix[3][3]=8;
		multiplicationMatrix[1][1]=28;
		multiplicationMatrix[2][1]=63;
		multiplicationMatrix[3][1]=56;
	}
@Test(expected =AssertionError.class)
public void testCaseToCheckWhetherTheMatrixIsSymmtericalOrNotWhenMatrix3IsPassedAsArgumentThenExpectedResultIsToThrowExceptionAsMatrixIsNotASparseMatrix()
{
matrixOperation3.isSymmetrical();
}

@Test(expected =AssertionError.class)
public void testCaseToFindTransposeOfMatrixWhenMatrix3IsPassedisAsArgumentThenExpectedResultIsToThrowExceptionAsMatrixIsNotASparseMatrix()
{
	matrixOperation3.transpose();
}
@Test(expected =AssertionError.class)
public void testCaseToFindAdditionOfMatrixWhenMatrix3IsPassedToMatrix1AsArgumentThenExpectedResultIsToThrowExceptionAsMatrixAreNotEqualInSizeMatrix()
{
	matrixOperation1.addMatrix(matrixOperation3);
}

@Test(expected =AssertionError.class)
public void testCaseToFindMultiplicationOfMatrixWhenMatrix3IsPassedToMatrix1AsArgumentAndResultIsToThrowExceptionAsMatrixDoesNotSupportMultiplicationRuleAsNumberOfColumnOfFirstMatrixIsEqualToNumberOfColumnOfSecondMatrix()
{
	matrixOperation1.multiplyMatrix(matrixOperation3);

}
@Test
public void testCaseToCheckWhetherTheMatrixIsSymmtericalOrNotWhenMatrix1IsPassedAsArgumentWhenExpectedResultISFalse()
{
	assertEquals(false,matrixOperation1.isSymmetrical());
}
@Test
public void testCaseToCheckWhetherTheMatrixIsSymmtericalOrNotWhenMatrix2IsPassedAsArgumentWhenExpectedResultISTrue()
{
	assertEquals(true,matrixOperation2.isSymmetrical());
}
@Test
public void testCaseToFindTransposeOfMatrixWhenMatrix1IsPassedisAsArgumentWhentransposeOfMatrix1isExpectedOutPut()
{
	assertEquals(transposeOfMatrix1,matrixOperation1.transpose());
}
@Test
public void testCaseToFindAdditionOfMatrixWhenMatrix2IsPassedToMatrix1AsArgumentWhenadditionMatrix1isExpectedOutPut()
{
	assertEquals(additionMatrix,matrixOperation1.addMatrix(matrixOperation2));
}
@Test
public void testCaseToFindMultiplicationOfMatrixWhenMatrix2IsPassedToMatrix1AsArgumentWhenMultiplicationMatrixisExpectedOutPut()
{
	assertEquals(multiplicationMatrix,matrixOperation1.multiplyMatrix(matrixOperation2));

}
}