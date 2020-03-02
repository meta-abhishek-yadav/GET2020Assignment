package assignment5;

import java.util.Arrays;

public class NQueen 
{
	int found=0;
	/**
	 * solution() method find the positions of queen in n*n array where two queens do not attack on each other
	 * the method find in recursive approach
	 * @param arr 2-dimensional array to store the positions of queen as if value then queen is on that position
	 * @param n the size of 2-dimensional array 
	 * @param i the current row position
	 * @variable result to store boolean value of condition
	 * @return the result as true is condition can be satisfied else false
	 */
	public boolean solution(int[][] arr,int n,int i )
	{
		boolean result=false;
		int j=-1;
		int count=0,k,l=j,h=j;
		while(j<n-1 && i<n)
		{
			if(i==0)
			{
				j++;
				arr[i][j]=1;
				result=this.solution(arr,n,i+1);
			}
			else
			{
				count=0;
				j++;
				l=j;
				h=j;
				for(k=i-1;k>=0;k--)
				{
					l--;
					h++;
					if(arr[k][j]==1)
					{
						count++;
						break;
					}
					if(l>=0)
					{
						if(arr[k][l]==1)
						{
						count++;
						break;
						}
					}
					if(h<=n-1)
					{
						if(arr[k][h]==1)
						{
						count++;
						break;
						}
					}
				}
				if(count==0)
				{
					arr[i][j]=1;								
					if(i<n-1)
					{
						result=this.solution(arr,n,i+1);
					}
					else
					{
						result=true;
					}
				}
				else
				{
					continue;
				}
				
			}
			if(result==true)
			{
				break;
			}
			else
			{
				arr[i][j]=0;
			}
			
		}
		
		
		return result;
	}
	
	
	
}
