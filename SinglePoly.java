package Assignment6;

import java.util.*;

public class SinglePoly {
	final private ArrayList<Integer> list=new ArrayList<Integer>();
	/**
	 * @param list contains the coefficient and power of single variable polynomial 
	 * At Even Index coefficient is stored and power is stored at odd index
	 * Assign Values of list passed as parameter to class list
	 * removing the coefficient if coefficient 0 else arranging in order
	 */
	public  SinglePoly(ArrayList<Integer> list)
	{
		int i,j,cofficient,power=0,length=list.size();
		for(i=1;i<length;i=i+2)
		{
			if(list.get(i)>=0)
			{
				cofficient=list.get(i-1);
				if(cofficient!=0)
				{
					power=list.get(i);
					for(j=i+2;j<length;j=j+2)
					{
						if(list.get(j)==power)
						{
							cofficient+=list.get(j-1);
							list.set(j,-1);
						}
					}
					if(i==1)
					{	
						this.list.add(cofficient);
						this.list.add(power);
				
					}
					else
					{
						int find=0;
						for(j=1;j<this.list.size();j=j+2)
						{
							if(this.list.get(j)<power)
							{
								find=1;
								break;
							}
						}
						if(find==0)
						{
							this.list.add(cofficient);
							this.list.add(power);
						}
						else
						{
							this.list.add(j-1,cofficient);
							this.list.add(j,power);
						}
					}
				}
			}
		}	
	}
	
	/**
	 * evaluate() method evaluate value of polynomial at variable=value
	 * @param value of variable to calculate polynomial value
	 * @return calculated value of polynomial at variable = value
	 */
	public double evaluate(double value)
	{
		double totalValue=0,total=1;
		int length=list.size();
		for(int i=1;i<length;i=i+2)
		{
			total=list.get(i-1);
			for(int j=1;j<=list.get(i);j++)
			{
				total=total*value;
			}
			totalValue+=total;
		}
		return totalValue;
	}
	
	/**
	 * @return the highest degree of polynomial
	 */
	public int degree()
	{
		int degree=0,length=list.size();
		for(int i=1;i<length;i=i+2)
		{
			if(list.get(i)>degree)
			{
				degree=list.get(i);
			}
		}
		
		return degree;
	}
	
	/**
	 * addPoly() method add the polynomials passed as arguments
	 * @param poly1 object of first SinglePoly class to add polynomial
	 * @param poly2 object of second SinglePoly class to add polynomial
	 * @return ArrayList contains addition of polynomials  
	 */
	public ArrayList<Integer> addPoly(SinglePoly poly1,SinglePoly poly2)
	{
		ArrayList<Integer> list1=new ArrayList<Integer>();
		int lengthOfSet1=poly1.list.size();
		int lengthOfSet2=poly2.list.size();
		int i=1;
		for(i=0;i<lengthOfSet1-1;i=i+2)
		{
			list1.add(poly1.list.get(i));
			list1.add(poly1.list.get(i+1));
		}
		for(i=0;i<lengthOfSet2-1;i=i+2)
		{
			list1.add(poly2.list.get(i));
			list1.add(poly2.list.get(i+1));
		}
		SinglePoly sp=new SinglePoly(list1);
		list1=sp.list;
		return list1;
	}
	
	/**
	 * multiply() method multiply the polynomials
	 * @param poly1 object of first SinglePoly class to multiply the polynomial
	 * @param poly2 object of second SinglePoly class to multiply the polynomial
	 * @return ArrayList that contains multiplication of polynomials  
	 */
	public ArrayList<Integer> multiply(SinglePoly poly1,SinglePoly poly2)
	{
		int lengthOfSet1=poly1.list.size();
		int lengthOfSet2=poly2.list.size();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		int i,j;
		for(i=0;i<lengthOfSet1;i=i+2)
		{
			for(j=0;j<lengthOfSet2;j=j+2)
			{
				list1.add(poly1.list.get(i)*poly2.list.get(j));
				list1.add(poly1.list.get(i+1)+poly2.list.get(j+1));
			}
		}
		SinglePoly sp=new SinglePoly(list1);
		list1=sp.list;
		return list1;
	}
	
	
	
}
