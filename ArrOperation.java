import java.util.ArrayList;


public class ArrOperation 
{
	int i,count=0,num=-1,length,maximum=-1,k,j;
	
	/**
	 * countClumps() method count the number of sub arrays which have two or more adjacent elements else return 0
	 * @param list is the list of numbers on which we have to perform the operation 
	 * @variable length is the size of list 
	 * @variable count counts the number of clumps
	 * @variable num is variable to hold values to match the elements
	 * @return count the no of clumps as integer
	 */
	public int countClumps(ArrayList<Integer> list)
	{
		try
		{
		length=list.size();
		if(length==0)
		{
			throw new AssertionError("Empty List");
		}
		else
		{
		num=-1;
		count=0;
		for(i=1;i<length;i++)
		{
			if((list.get(i-1)==list.get(i))&& (num!=list.get(i-1)))
			{
				count++;
				num=list.get(i);
			}
			else if((list.get(i-1)==list.get(i))&& (num==list.get(i-1)))
			{
				
			}
			else
			{
				num=-1;
			}
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return count;
	}
	
	/**
	 * maxMirror() method find the size of the longest group of elements  which have same group in reverse order in list
	 * @param list is the list of numbers on which we have to perform the operation 
	 * @variable length is the size of list 
	 * @variable count counts the length of group
	 * @variable maximum is variable to hold the maximum length of group
	 * @return maximum length
	 */
	public int maxMirror(ArrayList<Integer> list)
	{
		try
		{
		length=list.size();
		if(length==0)
		{
			throw new AssertionError("Empty List");
		}
		else
		{
		maximum=-1;
		for(i=0;i<length;i++)
		{
			k=i;
			count=0;
			for(j=length-1;j>=0;j--)
			{
				
				if(list.get(j)==list.get(k))
				{
					count++;
					k++;
					if(k>=length )
					{
						if(maximum<count)
						{
						maximum=count;
						}
						break;
					}
				}
				else if(count!=0)
				{
					if(count>maximum)
					{
						maximum=count;
					}
					count=0;
					k=i;
					j++;
				}
			}
			if(count>maximum)
			{
				maximum=count;
			}
			if((length-i)<maximum)
			{
				break;
			}
		
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return (maximum);
	}
	/**
	 * splitArray() method find the size of the index of list/array from where the list can divided in two parts that both side have same sum of elements and return -1 if not possible 
	 * @param list is the list of numbers on which we have to perform the operation 
	 * @variable length is the size of list 
	 * @variable count hold sum of the elements 
	 * @return k as index of array from where the list can be divided else return -1
	 */
	public int splitArray(ArrayList<Integer> list)
	{
		try
		{
		int sum=0;
		length=list.size();
		if(length==0)
		{
			//throw new AssertionError("Empty List");
		}
		else
		{
		k=-1;
		for(i=0;i<length;i++)
		{
			sum=sum+list.get(i);
			list.set(i,sum);
		}
		if(sum%2==0)
		{
			for(i=0;i<length;i++)
			{
				if((list.get(i))==(sum/2))
					{
					k=i;
					break;
					}
			}
		}
	}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		return k;
	}
	
	/**
	 * fixXY() method find the list after arranging as after every x element y  and other elements can be in any order
	 * @param list is the list of numbers on which we have to perform the operation 
	 * @param x value of x
	 * @param y value of y
	 * @variable length is the size of list 
	 * @variable count hold sum of the elements 
	 * @variable list1 is array list to hold the values 
	 * @return k as index of array from where the list can be divided else return -1
	 */
	public ArrayList<Integer> fixXY(ArrayList<Integer> list,int x,int y) 
	{
		try
		{
		length=list.size();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		int count=0,count1=0,alert=0;	
		for(i=0;i<length;i++)
		{
			if(list.get(i)!=x && list.get(i)!=y)
			{
				list1.add(list.get(i));
			}
			else if(list.get(i)==x)
			{
				count++;
				if(i==length-1)
				{
					alert=1;
				}
				else if(list.get(i+1)==x)
				{
					alert=1;
				}
			}
			else if(list.get(i)==y)
			{
				count1++;
			}
		}
		
		if(count!=count1 || length==0 || alert==1)
		{
			throw new AssertionError("Invalid Input list");
		}
		else
		{
		k=list1.size();
		j=0;
		for(i=0;i<length;i++)
		{
			
			if(list.get(i)==x )
			{
				list.set(i+1,y);
				i++;
			}
			else
			{
					if(j>=k)
					{
						list.set(i,y);
					}
					else
					{
						list.set(i,list1.get(j));
						j++;
					}
			}	
		}
		}
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
	
		return list;
	}
}
