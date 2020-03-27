package question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
/**
 * this class find the number of unique character in the string and store at cache and use next time to calculate
 * @author Abhishek
 *
 */
public class OccurenceCounter {
	HashMap<String,int[]> Existstrings=new HashMap<String,int[]>();
	/**
	 * this method gives the total unique character in the string 
	 * @param string to find number of unique character
	 * @return the total number of unique character
	 */
	public int getUniqueCharacters(String string)
	{
		int keyvalue[]=new int[36];
		int index=-1;
		int size=0;
	    for(Entry<String, int[]> entry:Existstrings.entrySet())
	    {   
	    	if(string.indexOf(entry.getKey())!=-1)
	    	{
	    		index=(string.indexOf(entry.getKey()));
	    		size=entry.getKey().length();
	    		keyvalue=entry.getValue();
	    	}
	    }
	    String str="";
	    if(index!=-1)
	    {
	    	str=string.substring(0,index)+string.substring(index+size);
	    }
	    else
	    {
	    	str=string;
	    }
	    keyvalue=this.countUniqueCharacter(str, keyvalue);
		int count=0;
		for(int i=0;i<36;i++)
		{
			if(keyvalue[i]!=0)
			{
				count++;
			}
		}
		Existstrings.put(string, keyvalue);

		return count;

	   }
	/**
	 * this method count the unique characters
	 * @param str in which we have to count unique character
	 * @param alphabet the list of previous counted characters
	 * @return array to counted unique characters counts
	 */
	public int[] countUniqueCharacter(String str,int[] alphabet)
	{
		for(int i=0;i<str.length();i++)
		{
			if((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57)
			{
				alphabet[((int)str.charAt(i))-48+26]=alphabet[((int)str.charAt(i))-48]+1;
			}
			else if((int)str.charAt(i)>=97 && (int)str.charAt(i)<=123)
			{
				alphabet[((int)str.charAt(i))-97]=alphabet[((int)str.charAt(i))-97]+1;
			}
			else if((int)str.charAt(i)>=65 && (int)str.charAt(i)<=91)
			{
				alphabet[((int)str.charAt(i))-65]=alphabet[((int)str.charAt(i))-65]+1;
			}
		}
		
		return alphabet;
	}
	public static void main(String[] args) {
		OccurenceCounter occurenceCounter=new OccurenceCounter();
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int i=1;
		while(i==1)
		{
			System.out.println("number of unique character in string "+str+" is "+occurenceCounter.getUniqueCharacters(str));
			System.out.println("enter 1 check more strings else any number");
			i=sc.nextInt();
			if(i==1)
			{
				System.out.println("enter string");
				str=sc.nextLine();
				str=sc.nextLine();
			}
		}
	}

}
