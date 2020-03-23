import java.util.ArrayList;
import java.util.Scanner;
/**
 * HighestDegree class to find the highest degree of the polynomial variant using the nested list implementation
 *
 */
public class HighestDegree {
/**
 * this method create polynomial expression in nested list form
 * @return Polynomial expression in form of nested list
 */
	public ArrayList<ArrayList<String>> createPolynomial()
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<String>> polynomial=new ArrayList<ArrayList<String>>();
		ArrayList<String> term1=new ArrayList<String>();
		term1.add("13");
		term1.add("x");
		term1.add("2");
		term1.add("y");
		term1.add("5");
		ArrayList<String> term2=new ArrayList<String>();
		term2.add("13");
		term2.add("x");
		term2.add("0");
		term2.add("y");
		term2.add("3");
		ArrayList<String> term3=new ArrayList<String>();
		term3.add("13");
		term3.add("x");
		term3.add("-2");
		term3.add("y");
		term3.add("8");
		polynomial.add(term1);
		polynomial.add(term2);
		polynomial.add(term3);


		return polynomial;
	}
	/**
	 * 
	 * @param polynomial is the polynomial expression in form of nested list
	 * @return the highest degree of the multi variant polynomial 
	 */
	public int getHighestDegree(ArrayList<ArrayList<String>> polynomial)
	{
		int max=0;
		for(int i=0;i<polynomial.size();i++)
		{
			int count=0;
			for(int j=2;j<polynomial.get(i).size();j=j+2)
			{
				int degree=Integer.parseInt(polynomial.get(i).get(j));
				count=count+degree;
			}
			if(count>max)
			{
				max=count;
			}
		}
		return max;
	}
	public static void main(String []args)
	{
		HighestDegree hightestdegree=new HighestDegree();
		ArrayList<ArrayList<String>> polynomial=hightestdegree.createPolynomial();
		System.out.println(polynomial);
		System.out.println("Highest Degree is = "+hightestdegree.getHighestDegree(polynomial));
	}
	
	
}
