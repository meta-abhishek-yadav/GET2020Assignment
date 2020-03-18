import java.util.*;
import java.io.*;

class StringOperation
{
    int i,length,length2;
    String str;
    /**
     * compare() method compare two strings and check the strings are equal or not
     * @param string1 first string to compare the strings
     * @param string2 is second string to compare the strings
     * @return it returns 1 if strings are equal and return 0 if  strings are unequal
     * the method compare strings on char base not using API
     */
    private int compare(String string1,String string2)
    {
        length=string1.length();
        length2=string2.length();
        int m=1;
        if(length!=length2)
        {
           m=0; 
        }
        else
        {
            for(i=0;i<length;i++)
            {
                if(((int)string1.charAt(i))!=((int)string2.charAt(i)))
                {
                    m=0;
                    break;
                }
            }
            
        }
        return m;
    }
    /**
     * reverse() method reverse the string 
     * @param parameter string is passed as String to reverse 
     * @return its returns the reverse string
     */
    private String reverse(String string)
    {
        length=string.length();
        str="";
        for(i=0;i<length;i++)
        {
            str=Character.toString(string.charAt(i))+str;
        }
        return str;
        
    }
    /**
     * lowerUpper() method change the character from uppercase to lowercase and vice-versa
     * @param parameter string is passed as String to change the string from lowercase to uppercase and vice-versa 
     * @return its returns the changed string
     */
    private String lowerUpper(String string)
    {
        int length=string.length();
        String str="";
        for(i=0;i<length;i++)
        {
           int x=(int)string.charAt(i);
           if(x>=65 && x<=91)
           {
               x=x-65+97;
           }
           else if(x>=97 && x<=123)
           {
               x=x-97+65;
           }
           str=str+Character.toString((char)x);
        }
        return str;
    }
    /**
     * largestWord() method find the largest word in the string 
     * @param parameter string is passed as String to find the largest word 
     * @variable maximum to hold maximum length value of the word
     * @variable count counts the length of word
     * @return its returns the largest word as string
     */
    private String largestWord(String string)
    {
        length=string.length();
        str="";
        int maximum=-1,j=length-1,count=0;
        for(i=0;i<length;i++)
        {
            if((string.charAt(i)==32) ||(i==(length-1)))
            {
                if(i==(length-1))
                {
                    count=count+1;
                }
                if(maximum<=count)
                {
                    maximum=count;
		            count=0;
                    j=i;
                }
                else
                {
                    count=0;
                }
            }
	        else
	        {
		        count++;
	        }
        }
        for(i=j;i>(j-maximum);i--)
        {
            str=Character.toString(string.charAt(i))+str;
        }
        return str;
    }
    /**
     * input() method takes the input from user and check validity of string
     * @param it accept class object as parameter
     * @param message is String parameter that print message to user to print
     * @return it returns the input string from user
     */
    private String input(StringOperation so,String message)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(message);
        String string=sc.nextLine();
        if(string.length()==0)
        {
            System.out.println("Please enter valid input");
            string=this.input(so,message);
        }
        return string;

    }
    public static void main(String []args)
    {
        try
        {
	        StringOperation so=new StringOperation();
	        String string1="",string2="";
	        string1=so.input(so,"enter first string");
	        string2=so.input(so,"enter second string");
            int l=so.compare(string1,string2);
	        if(l==0)
            {
                System.out.println("Both strings are unequal"+"\n");
    	    }
	        else if(l==1)
	        {
		        System.out.println("Both strings are equal"+"\n");
	        }
            System.out.println("Reverse of String 1 is = "+so.reverse(string1)+"\n");
            System.out.println("Reverse of String 2 is = "+so.reverse(string2)+"\n");
            System.out.println("uppercase to lwercase and vice-versa of String 1 is = "+so.lowerUpper(string1)+"\n");
            System.out.println("uppercase to lwercase and vice-versa of String 2 is = "+so.lowerUpper(string2)+"\n");
            System.out.println("largest word of String 1 is ="+so.largestWord(string1)+"\n");
            System.out.println("largest word of String 2 is ="+so.largestWord(string2));
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}