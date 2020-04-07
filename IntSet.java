package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;

public class IntSet {
	final private ArrayList<Integer> array;
	private int length = 0, i, j;

	/**
	 * @param array
	 *            of set of items constructor assign array to class array
	 */
	public IntSet(ArrayList<Integer> array) {
		this.array = array;
	}

	/**
	 * isMember() method check whether the item is exists in the array or not
	 * @param item that have to check in array
	 * @variable returnAnswer to hold the local value of result as boolean
	 * @return true if array contain the item else return false
	 */
	public boolean isMember(int item) 
	{
		length = array.size();
		boolean returnAnswer = false;
		try {
			for (i = 0; i < length; i++) 
			{
				if (array.get(i) == item)
				{
					returnAnswer = true;
					break;
				}
			}
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return returnAnswer;

	}

	/**
	 * @param item
	 *            to check that it exists in passed ArrayList or not
	 * @param PassedArrayAsArgument
	 *            the arrayList of items
	 * @return true PassedArrayAsArgument contains the item else return false
	 */
	private static boolean findMember(int item,
			ArrayList<Integer> PassedArrayAsArgument) 
	{

		int length = PassedArrayAsArgument.size();
		boolean returnAnswer = false;
		for (int i = 0; i < length; i++) 
		{
			if (PassedArrayAsArgument.get(i) == item)
			{
				returnAnswer = true;
			}
		}

		return returnAnswer;
	}

	/**
	 * @return size of set
	 */
	public int size()
	{
		return array.size();
	}

	/**
	 * isSubset() method check whether the passed set as argument is subset of
	 * given class set
	 * 
	 * @param passedIntSet
	 * @return true if the passedIntSet is subset of class Set else return false
	 */
	public boolean isSubSet(IntSet passedIntSet)
	{
		int inputSubSetLength = passedIntSet.array.size();
		int lengthOfSet = this.array.size();
		int find = 0;
		boolean returnAnswer = true;
		try {
			for (i = 0; i < inputSubSetLength; i++)
			{
				find = 0;
				for (j = 0; j < lengthOfSet; j++) 
				{
					if (passedIntSet.array.get(i) == this.array.get(j))
					{
						find = 1;
						break;
					}
				}
				if (find == 0) 
				{
					returnAnswer = false;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return returnAnswer;

	}

	/**
	 * getComplement() method find the complement set of given set from
	 * universal set contains values between 1 and 1000
	 * 
	 * @return list that contains complement values of set
	 */
	public ArrayList<Integer> getComplement() 
	{
		int find = 0;
		ArrayList<Integer> complementArray = new ArrayList<Integer>();
		try {
			for (i = 1; i <= 1000; i++) 
			{
				find = 0;
				for (j = 0; j < this.array.size(); j++) 
				{
					if (i == this.array.get(j))
					{
						find = 1;
						break;
					}
				}
				if (find == 0)
				{
					complementArray.add(i);
				}
			}
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return complementArray;
	}

	/**
	 * @param intset1
	 *            object of first set
	 * @param intset2
	 *            object of second set
	 * @return list that contains the items of union of both set passed as
	 *         arguments
	 */
	public ArrayList<Integer> union(IntSet intset1, IntSet intset2) 
	{
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		try {
			int set1Length = intset1.size();
			int set2Length = intset2.size();

			if (set1Length <= set2Length)
			{
				length = set1Length;
			} 
			else 
			{
				length = set2Length;
			}
			for (int i = 0; i < length; i++)
			{
				if (intset1.array.get(i) == intset2.array.get(i)) 
				{
					if (!findMember(intset1.array.get(i), newArray))
					{
						newArray.add(intset1.array.get(i));
					}
				}
				if (true) 
				{
					if (!findMember(intset1.array.get(i), newArray))
					{
						newArray.add(intset1.array.get(i));
					}
					if (!findMember(intset2.array.get(i), newArray))
					{
						newArray.add(intset2.array.get(i));
					}
				}
			}
			for (i = length; i < set1Length; i++) 
			{
				if (!this.findMember(intset1.array.get(i), newArray))
				{
					newArray.add(intset1.array.get(i));
				}
			}
			for (j = length; j < set2Length; j++)
			{
				if (!this.findMember(intset2.array.get(i), newArray)) 
				{
					newArray.add(intset2.array.get(i));
				}
			}
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return newArray;
	}

}
