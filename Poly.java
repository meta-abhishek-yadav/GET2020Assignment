package Assignment6;

import java.util.*;

public class Poly {
	private ArrayList<ArrayList<Integer>> coefficient = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Integer>> power = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Character> variable = new ArrayList<Character>();
	private String stringPoly;

	public Poly(String input)
	{
		stringPoly = input;
		this.makeList(input);
	}

	/**
	 * makeList() method to make list of multiple variable polynomial expression
	 * remove the coefficient if 0
	 * @param input string of polynomial
	 */
	private void makeList(String input) {
		coefficient.clear();
		power.clear();
		variable.clear();
		int i, j, operation = 1, ascii = 0, length = input.length(), code = 2, sign = 1, index = -1;
		String str = "";
		for (i = 0; i <= length; i++) 
		{
			if (i < length) 
			{
				ascii = (int) input.charAt(i);
				if (ascii >= 97 && ascii <= 123)
				{
					operation = 2;
				} else if (ascii == 43 || ascii == 45) {
					operation = 3;
				} else {
					operation = 1;
				}
			}
			if (i == length)
			{
				if (str.length() != 0)
				{
					operation = 3;
				}
			}
			if (operation == 1)
			{
				if (ascii != 32) 
				{
					str = str + Character.toString((char) ascii);
				}
			}
			else if (operation == 2) 
			{
				if (code == 2) 
				{
					int length1 = variable.size();
					if (length1 == 0) 
					{
						variable.add((char) ascii);
						int x = (sign) * (Integer.parseInt(str));
						coefficient.add(new ArrayList<Integer>(Arrays.asList((sign) * (Integer.parseInt(str)))));
						str = "";
					} 
					else
					{
						index = -1;
						for (j = 0; j < length1; j++) 
						{
							if ((int) variable.get(j) == ascii)
							{
								index = j;
								break;
							}
						}
						if (index == -1)
						{
							variable.add((char) ascii);
							coefficient.add(new ArrayList<Integer>(Arrays.asList((sign) * (Integer.parseInt(str)))));
						} 
						else
						{
							coefficient.get(index).add((sign) * (Integer.parseInt(str)));
						}
					}
					sign = 1;
				}
				str = "";
				code = 1;
			} 
			else if (operation == 3)
			{
				if (code == 1)
				{
					code = 2;
					int length2 = power.size();
					if (length2 == 0) 
					{
						power.add(new ArrayList<Integer>(Arrays.asList(Integer
								.parseInt(str))));
					}
					else 
					{
						if (index == -1)
						{
							power.add(new ArrayList<Integer>(Arrays
									.asList(Integer.parseInt(str))));
						} else
						{
							power.get(index).add(Integer.parseInt(str));
						}
					}
					str = "";
				} 
				else if (code == 2) 
				{
					if (coefficient.size() > 0)
					{
						coefficient.get(0).add((sign) * (Integer.parseInt(str)));
						power.get(0).add(0);
					} 
					else 
					{
						coefficient.add(new ArrayList<Integer>(Arrays.asList((sign) * (Integer.parseInt(str)))));
						power.add(new ArrayList<Integer>(Arrays.asList(0)));
						variable.add('x');
					}
					str = "";
					code = 2;
				}
				if (ascii == 43) 
				{
					sign = 1;
				} else if (ascii == 45) 
				{
					sign = -1;
				}
			}
		}
		for (i = 0; i < variable.size(); i++)
		{
			for (j = 0; j < coefficient.get(i).size(); j++)
			{
				int pow = power.get(i).get(j);
				int cofficien = coefficient.get(i).get(j);
				if (cofficien != 0) 
				{
					for (int k = j + 1; k < coefficient.get(i).size(); k++)
					{
						if (power.get(i).get(k) == pow)
						{
							cofficien += coefficient.get(i).get(k);
							coefficient.get(i).remove(k);
							power.get(i).remove(k);
							k--;
						}
					}
					coefficient.get(i).set(j, cofficien);
					power.get(i).set(j, pow);
				} 
				else 
				{
					coefficient.get(i).remove(j);
					power.get(i).remove(j);
				}
			}
		}
	}

	/**
	 * show() show the polynomial expression
	 */
	public void show() {

		for (int i = 0; i < variable.size(); i++)
		{
			for (int j = 0; j < power.get(i).size(); j++)
			{
				if (i == 0 && j == 0)
				{
					System.out.print(coefficient.get(i).get(j));
					if (power.get(i).get(j) > 0) 
					{
						System.out.print(variable.get(i));
						if (power.get(i).get(j) > 1)
						{
							System.out.print(power.get(i).get(j));
						}
					}
				}
				else
				{
					if (coefficient.get(i).get(j) >= 0)
					{
						System.out.print("+");
					}
					System.out.print(coefficient.get(i).get(j));
					if (power.get(i).get(j) > 0) 
					{
						System.out.print(variable.get(i));
						if (power.get(i).get(j) > 1)
						{
							System.out.print(power.get(i).get(j));
						}
					}
				}
			}

		}
		System.out.println();

	}

	/**
	 * calculate the value of expression at variable's given value
	 * 
	 * @return calculated value of polynomial expression
	 */

	public double evaluate() 
	{
		double totalValue = 0;
		for (int i = 0; i < variable.size(); i++) 
		{
			System.out.println("enter value for variable " + variable.get(i));
			Scanner sc = new Scanner(System.in);
			double value1 = sc.nextDouble();
			for (int j = 0; j < power.get(i).size(); j++) 
			{
				double total = coefficient.get(i).get(j);
				for (int k = 1; k <= power.get(i).get(j); k++) 
				{
					total = total * value1;
				}
				totalValue += total;
			}

		}
		return totalValue;
	}

	/**
	 * calculate the highest degree of polynomial expression
	 * 
	 * @return highest degree of polynomial expression
	 */
	public int degree() {
		int degree = -1;
		for (int i = 0; i < variable.size(); i++)
		{
			for (int j = 0; j < power.get(i).size(); j++) 
			{
				int pow = power.get(i).get(j);
				if (pow > degree)
				{
					degree = pow;
				}
			}
		}
		return degree;
	}

	/**
	 * 
	 * @param poly1
	 *            object of first polynomial expression
	 * @param poly2
	 *            object of second polynomial expression
	 * @return the object of Poly class that contains expression of addition of
	 *         polynomial
	 */
	public Poly addPoly(Poly poly1, Poly poly2) {
		Poly poly = new Poly((poly1.stringPoly + "+" + poly2.stringPoly));
		return poly;
	}

	/**
	 * method to update the value of polynomial expression
	 */
	public void setPoly() {
		System.out.println("Enter new Poly ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		this.makeList(str);
	}

	/**
	 * 
	 * @param poly1
	 *            object of first polynomial expression
	 * @param poly2
	 *            object of second polynomial expression
	 * @return the string expression of multiplication of polynomial
	 */
	public String multiplyPoly(Poly poly1, Poly poly2) {
		String str = "";
		int i, j, k, l;
		for (i = 0; i < poly1.variable.size(); i++)
		{
			for (j = 0; j < poly1.power.get(i).size(); j++) 
			{
				for (k = 0; k < poly2.variable.size(); k++) 
				{
					for (l = 0; l < poly2.power.get(k).size(); l++)
					{
						if (poly1.variable.get(i) == poly2.variable.get(k)) 
						{
							if (i != 0 || j != 0 || k != 0 || l != 0)
							{
								if ((poly1.coefficient.get(i).get(j)) * (poly2.coefficient.get(k).get(l)) >= 0)
								{
									str = str + "+";
								}
							}
							str = str+ Integer.toString((poly1.coefficient.get(i).get(j))* (poly2.coefficient.get(k)	.get(l)));
							str = str + poly1.variable.get(i);
							str = str+ Integer.toString((poly1.power.get(i).get(j))	* (poly2.power.get(k).get(l)));
						} 
						else 
						{
							

							if (i != 0 || j != 0 || k != 0 || l != 0)
							{
								if ((poly1.coefficient.get(i).get(j))* (poly2.coefficient.get(k).get(l)) >= 0) 
								{
									str = str + "+";
								}
							}
							str = str+ Integer.toString((poly1.coefficient.get(i).get(j))* (poly2.coefficient.get(k).get(l)));
							str = str + poly1.variable.get(i);
							str = str+ Integer.toString((poly1.power.get(i).get(j)));
							str = str + poly2.variable.get(i);
							str = str+ Integer.toString((poly2.power.get(k).get(l)));
						}

					}
				}
			}
		}
		return str;
	}

	public static void main(String[] args) {
		Poly poly1 = new Poly("2x2+0x1");
		Poly poly2 = new Poly("4y3+6y1");
		System.out.println("Degree of polynomial= " + poly1.degree());
		System.out.println("value of polynomial = " + poly1.evaluate());
		Poly additionPoly = poly1.addPoly(poly1, poly2);
		System.out.println("addition of polynomial = ");
		additionPoly.show();
		poly1.setPoly();
		poly1.show();
		System.out.println("multiplicaton of polynomial is = "+ poly1.multiplyPoly(poly1, poly2));

	}
}
