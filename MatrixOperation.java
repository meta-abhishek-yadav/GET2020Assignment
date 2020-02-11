package Assignment7;
import java.util.*;

public class MatrixOperation 
{
	final private ArrayList<Integer> rowIndex=new ArrayList<Integer>();
	final private ArrayList<Integer> columnindex=new ArrayList<Integer>();
	final private ArrayList<Integer> value=new ArrayList<Integer>();
	final int numberOfRow ,numberOfColumn;
	/**
	 * constructor MatrixOperation allocate values of variables of class
	 * @param matrix contains the matrix values in 2-D array
	 * @param numberOfRow is number of rows in matrix
	 * @param numberOfColumn is number of column in matrix
	 * it store only non-zero values of matrix to save memory using storing the index and values of non-zero items
	 */
	public MatrixOperation(int[][] matrix,int numberOfRow,int numberOfColumn)
	{
		this.numberOfRow=numberOfRow;
		this.numberOfColumn=numberOfColumn;
		for(int i=0;i<numberOfRow;i++)
		{
			for(int j=0;j<numberOfColumn;j++)
			{
				if(matrix[i][j]!=0)
				{
					rowIndex.add(i);
					columnindex.add(j);
					value.add(matrix[i][j]);

				}
			}
		}
		
	}
	/**
	 * transpose() method find the transpose of given matrix
	 * @return matrix that contains the transpose of given matrix
	 */
	 int[][] transpose()
	 {
		int i;
		int arr[][]=new int[numberOfColumn][numberOfRow];
		try
		{
		if((rowIndex.size())>((numberOfRow*numberOfColumn)/2))
		{
			throw new AssertionError("Invalid Sparse Matrix");
		}
		else
		{
			for(i=0;i<rowIndex.size();i++)
			{
				arr[columnindex.get(i)][rowIndex.get(i)]=value.get(i);
				
			}
		}
		}
		catch(Exception e)
		{}
		
		return arr;
	}
	/**
	 * isSymmetrical() method check whether the matrix is symmetric or not
	 * @return true if the matrix is symmetric else return false
	 */
	 boolean isSymmetrical()
	{
		int i,j;
		boolean symmetry=false;
		try
		{
		if((rowIndex.size())>((numberOfRow*numberOfColumn)/2))
		{
			throw new AssertionError("Invalid Sparse Matrix");
		}
		else
		{
		for(i=0;i<rowIndex.size();i++)
		{
			symmetry=false;
			for(j=0;j<rowIndex.size();j++)
			{
			if(i!=j)
			{
				if((rowIndex.get(i)==columnindex.get(j)) && (columnindex.get(i)==rowIndex.get(j)))
				{
					if(value.get(i)==value.get(j))
					{
						symmetry=true;
					}
				}
			}
			}
			if(symmetry==false)
			{
				break;
			}
		}
		}
		}
		catch(Exception e){}
		return symmetry;
	}
	/**
	 * addMatrix() Add two Matrix
	 * @param matrixOperation object of matrixOperation class that contains second matrix to addition
	 * @return matrix that contains the addition of this class matrix and matrixOperation object's matrix
	 */
	 int[][] addMatrix(MatrixOperation matrixOperation)
	{
		int matrix[][]=new int[numberOfRow][numberOfColumn];
		try
		{
			if((this.numberOfRow != matrixOperation.numberOfRow) && (this.numberOfColumn !=matrixOperation.numberOfColumn))
			{
				throw new AssertionError("Addition Matrix must be same in Dimension");
			}
			else
			{
				int i,j,length=0;
				if(this.rowIndex.size()>matrixOperation.rowIndex.size())
				{
					length=matrixOperation.rowIndex.size();
				}
				else
				{
					length=this.rowIndex.size();
				}
				for(i=0;i<length;i++)
				{
					matrix[this.rowIndex.get(i)][this.columnindex.get(i)]+=this.value.get(i);
					matrix[matrixOperation.rowIndex.get(i)][matrixOperation.columnindex.get(i)]+=matrixOperation.value.get(i);

				}
				for(i=length;i<this.rowIndex.size();i++)
				{
					matrix[this.rowIndex.get(i)][this.columnindex.get(i)]+=this.value.get(i);
				}
				for(i=length;i<matrixOperation.rowIndex.size();i++)
				{
					matrix[matrixOperation.rowIndex.get(i)][matrixOperation.columnindex.get(i)]+=matrixOperation.value.get(i);
				}
				
			}
		}
		catch(Exception e){}
		
		return matrix;
	}
	/**
	 * multiplyMatrix() method multiply the matrices 
	 * @param matrixOperation object of another class that contains the second matrix
	 * @return matrix contains the multiplication of this class matrix and matrixOperation object(passed as argument) matrix
	 */
	 int[][] multiplyMatrix(MatrixOperation matrixOperation)
	{
		int multiplymatrix[][]=new int[this.numberOfRow][matrixOperation.numberOfColumn];
		try
		{
		if(this.numberOfColumn!=matrixOperation.numberOfRow)
		{
			throw new AssertionError("Matrix does not support the multiplication rule");
		}
		else
		{
		int i,j,k,length=0,total=0;
		int thisClassMatrix[][]=new int[numberOfRow][numberOfColumn];
		int passedObjectMatrix[][]=new int[numberOfRow][numberOfColumn];

		for(i=0;i<this.rowIndex.size();i++)
		{
			thisClassMatrix[this.rowIndex.get(i)][this.columnindex.get(i)]=this.value.get(i);
		}
		for(i=0;i<matrixOperation.rowIndex.size();i++)
		{
			passedObjectMatrix[matrixOperation.rowIndex.get(i)][matrixOperation.columnindex.get(i)]=matrixOperation.value.get(i);
		}
		for(i=0;i<numberOfRow;i++)
		{
			for(j=0;j<numberOfColumn;j++)
			{
				total=0;
				for(k=0;k<numberOfColumn;k++)
				{
					total+=thisClassMatrix[i][k]*passedObjectMatrix[k][j];
				}
				multiplymatrix[i][j]=total;
			}
		}
		}
		}
		catch(Exception e){}
		return multiplymatrix;
	}
	public static void main(String []args)
	{
		int i,j,x[][]=new int[5][4];
		x[1][2]=2;
		x[2][3]=4;
		x[0][1]=7;
		MatrixOperation mo=new MatrixOperation(x,5,4);
		int y[][]=new int[6][5];
		y[1][2]=2;
		y[2][3]=4;
		y[0][1]=7;
		MatrixOperation mo1=new MatrixOperation(y,6,5);
		//System.out.println(mo.isSymmetrical());
		int v[][]=mo.addMatrix(mo1);
		for(i=0;i<5;i++)
		{
			for(j=0;j<4;j++)
			{
				System.out.print(v[i][j]+"  " );
			}
			System.out.println();
		}
	}
}
