package assignment5;

import java.util.ArrayList;

public class Search
{
	/**	
	 * linearSearch() method find the item in the list using recursion in linear search approach 
	 * @param list the ArrayList of items
	 * @param item the item to find in the list
	 * @param index of list till where item is searched
 	 * @variable k to hold index of item temporary
	 * @return the index of item if found else return -1
	 */
	public int linearSearch(ArrayList<Integer> list,int item,int index)
	{
		int k=-1;
		try
		{
		int length=list.size();
		if(index<length)
		{
			if(list.get(index)==item)
			{
				k= index;
			}
			else
			{
				index=index+1;
				k=this.linearSearch(list,item,index);
			}
		}
		else
		{
			k=-1;
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		return k;
		
	}
	/**
	 * binarySearch() method find the item in given list using recursion in binary search approach  
	 * @param list the ArrayList of items
	 * @param item the item to find in the list
	 * @param start index of list from where the binary search has to has
	 * @param end index of list till where binary search has to perform
	 * @variable mid to hold the mid of start and end index
	 * @variable k to hold index of item temporary
	 * @return index of item if found else return -1
	 */
	public int binarySearch(ArrayList<Integer> list,int item,int start,int end)
	{
		int k=-1;
		try
		{
		int mid=(end-start);
		if(mid!=0)
		{
			if(list.get(start+(mid/2))==item)
			{
				k=start+(mid/2);
			}
			else
			{
				int a=binarySearch(list,item,start,(start+(mid/2)-1));
				if(a!=-1)
				{
					k=a;
				}
				else
				{
					int b=binarySearch(list,item,(start+(mid/2)+1),end);
					if(b!=-1)
					{
						k=b;
					}
				}

			}
		}
		else
		{
			if(list.get(start)==item)
			{
				k=start;
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return k;
		
	}

}
