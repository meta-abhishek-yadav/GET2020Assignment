import java.io.*;
import java.util.*;
/**
 * HexCalc is class that contain many method as decimal(),toBase() and add(),subtract() and etc that perform many tasks according to their functionality 
 * main purpose of class is to perform operations on hexadecimal or any other base that is selected 
 **/
class HexCalc
{
    int length,i,ascii,hold,num1,num2, total=0,base;
    String number1,number2,str="";
    /**
     * decimal() method convert the any base number to decimal number
     * @param number is parameter of string type that is a basically a number in another base
     * @param base of integer type that is base of number that is passed as parameter
     * @return this method return integer value that is decimal number converted from that given base number
     */
    private int decimal(String number,int base)
    {
        total=0;
        length=number.length();
        char arr[]=number.toCharArray();
        for(i=0;i<length;i++)
        {
            ascii=(int)arr[i];
            if(ascii>=48 && ascii<=(57-(10-base)))
            {
                total=total+(ascii-48)*((int)Math.pow(base,length-i-1));
            }
            else if(ascii>=65 && ascii<=(65+base-11))
            {
                total=total+(ascii-65+10)*((int)Math.pow(base,length-i-1));
            }
            else
            {
                total=-1;
                break;
            }
        }
        return total;
    }
    /**
     * toBase() method convert the decimal number to any base number
     * @param number is parameter of string type that is a basically a number in decimal base
     * @param base of integer type that is base of number that has to converted
     * @return this method return String  value of the decimal number converted to given base number
     */
    private String toBase(int number,int base)
    {
        String str="";
	if(number==0)
	{
	str="0";
	}
        while(number!=0)
        {
            hold=number%base;
            number=number/base;
            if(hold>=10)
            {
                str=Character.toString(((char)(hold-10+65)))+str;
            }
            else
            {
                str=Integer.toString(hold)+str;
            }
        }
        return str;
    }
     /**
     * add() method add the number passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @param base of integer type that is base of number passed as parameters
     * @return this method return String  value of the addition of both number in given base
     */
    private String add(String number1,String number2,int base)
    {
        num1=this.decimal(number1,base);
        num2=this.decimal(number2,base);
        str="Addition is ="+this.toBase((num1+num2),base);
        return str;
    }
    /**
     * subtract() method subtract the number passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @param base of integer type that is base of number passed as parameters
     * @return this method return String  value of the subtraction of both number in given base
     */
    private String subtract(String number1,String number2,int base)
    {
        num1=this.decimal(number1,base);
        num2=this.decimal(number2,base);
        num1=num1-num2;
        if(num1<0)
        {
            num1=-num1;
		    str="Subtraction is = -"+this.toBase(num1,base);
        }
        else
        {
            str="Subtraction is ="+this.toBase(num1,base);
	    }
        return str;
        
    }
     /**
     * multiply() method multiply the number passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @param base of integer type that is base of number passed as parameters
     * @return this method return String  value of the multiplication of both number in given base
     */
    private String multiply(String number1,String number2,int base)
    {
       
        num1=this.decimal(number1,base);
        num2=this.decimal(number2,base);
        str="Multiplication is ="+this.toBase((num1*num2),base);
        return str;
        
    }
    /**
     * divide() method divide the number passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @param base of integer type that is base of number passed as paramters
     * @return this method return String  value of the qutoient and remainder after division of both number in given base
     */
    private String divide(String number1,String number2,int base)
    {
        String str="";
        num1=this.decimal(number1,base);
        num2=this.decimal(number2,base);
        str="After Division quotient is ="+this.toBase((int)(num1/num2),base)+"\nAfter Division Remainder is ="+this.toBase((num1%num2),base);
        return str;
    }
    /**
     * compareEqual() method compare equal to the numbers passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @return this method return boolean   value of the compare equal of both numbers
     */
    private boolean compareEqual(String number1,String number2)
    {
        int length1=number1.length();
        int length2=number2.length();
	    boolean a=true;
        char arr1[]=number1.toCharArray();
        char arr2[]=number2.toCharArray();
        int i,max,j,k,m;
        j=this.findFirstNonZero(arr1,length1);
        k=this.findFirstNonZero(arr2,length2);
        if((length1-j)!=(length2-k))
        {
            a=false;
        }
        else
        {
            for(i=j,m=k;i<length1 && m<length2;i++,m++)
            {
                if((int)(arr1[i])!=(int)(arr2[m]))
                {
                    a=false;
                    break;
                }
            }
        }
        return a;
	
    }
    /**
     * compareGreaterEqual() method compare greater than equal to the numbers passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @return this method return boolean value of the compare greater than equal of both numbers 
     */
    private boolean compareGreaterEqual(String number1,String number2)
    {
        int length1=number1.length();
        int length2=number2.length();
        char arr1[]=number1.toCharArray();
        char arr2[]=number2.toCharArray();
        int i,max,j,k,m;
        boolean a=true;
        j=this.findFirstNonZero(arr1,length1);
        k=this.findFirstNonZero(arr2,length2);
        if((length1-j)<(length2-k))
        {
            a=false;
        }
        else if((length1-j)==(length2-k))
        {
            for(i=j,m=k;i<length1 && m<length2;i++,m++)
            {
                if((int)(arr1[i])<(int)(arr2[m]))
                {
                    a=false;
                    break;
                }
            }
        }
        return a;
    }
    /**
     * compareLesserEqual() method compare less than equal to the numbers passed as string in any base 
     * @param number1 is parameter of string type that is a basically a number in another base
     * @param number2 is parameter of string type that is a basically a number in another base
     * @return this method return boolean value of the compare less than equal of both numbers
     */
    private boolean compareLesserEqual(String number1,String number2)
    {
        int length1=number1.length();
        int length2=number2.length();
        char arr1[]=number1.toCharArray();
        char arr2[]=number2.toCharArray();
        int i,max,j,k,l=0,m;
        boolean a=true;
        j=this.findFirstNonZero(arr1,length1);
        k=this.findFirstNonZero(arr2,length2);

        if((length1-j)>(length2-k))
        {
            a=false;
        }
        else if((length1-j)==(length2-k))
        {
            for(i=j,m=k;i<length1 && m<length2;i++,m++)
            {
                if((int)(arr1[i])>(int)(arr2[m]))
                {
                    a=false;
                    break;
                }
            }
        }
        return a;
    }
    /**
     * input() method takes the input from user and validate according to base that number is correct or not
     * @param hc is object of HexCalc class that is passed from main method 
     * the values are assigned to string and base using class object
     **/
    private void input(HexCalc hc)
    {
        int x,y;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the base on which you want to work");
        hc.base=sc.nextInt();
        System.out.println("Enter the first number in base you entered");
	    sc.nextLine();
        hc.number1=sc.nextLine();
        System.out.println("Enter the second number in base you entered");
        hc.number2=sc.nextLine();
		x=this.decimal(hc.number1,hc.base);
	    y=this.decimal(hc.number2,hc.base);
	    if(x==-1 || y==-1)
	    {
	        System.out.println("Please enter values according to base");
	        this.input(hc);
	    }
    }
    /**
     *findFirstNonZero() method find first non zero number/character entered in another base as string 
     * @param arr[] is array of character that contains the number in any base that is provided
     * @param length is the total length of string of number in given base 
     * @return it return the index of first non zero character/number
     **/
    private int findFirstNonZero(char arr[],int length)
    {
        int j=0;
        for(j=0;j<length;j++)
        {
            if(((int)arr[j])!=48)
            {
                break;
            }
        }
        return j;
    }
    /**
     * main() method contain user choice and call the functions needed
     * the while loop goes until user do not exit and keep operating operations
     **/
    public static void main(String []args)
    {
        try
        {
	        HexCalc hc=new HexCalc();
            int loop=1,x,y;
            Scanner sc=new Scanner(System.in);
            hc.input(hc);
            while(loop==1)
            {
                System.out.println("You can Perform given operations as given code and you can choose code to perform the action");
                System.out.println("\n\t1\tAdd both numbers\n\t2\tSubtract 2nd from 1st\n\t3\tMultiply both the Numbers\n\t4\tDivide 2nd from 1st\n\t5\tcompare  1st == 2nd\n\t6\tcompare 1st >= 2nd \n\t7\tcompare 1st <= 2nd\n\t8\tEnter new Values\n\t0\tExit");
                try
                {
                   int choice=0;
                   choice=sc.nextInt();
                   if(choice<=8 && choice>=0)
                   {
                        switch(choice)
                        {
                            case 0:
                                loop=0;
                                System.out.println("Thank you");
                                break;
                            case 1:
                                System.out.println(hc.add(hc.number1,hc.number2,hc.base));
                                break;
                            case 2:
                                System.out.println(hc.subtract(hc.number1,hc.number2,hc.base));
                                break;
                            case 3:
                                System.out.println(hc.multiply(hc.number1,hc.number2,hc.base));
                                break;
                            case 4:
                                System.out.println(hc.divide(hc.number1,hc.number2,hc.base));
                                break;
                            case 5:
                                System.out.println(hc.compareEqual(hc.number1,hc.number2));
                                break;
                            case 6:
                                System.out.println(hc.compareGreaterEqual(hc.number1,hc.number2));
                                break;
                            case 7:
                                System.out.println(hc.compareLesserEqual(hc.number1,hc.number2));
                                break;
			                case 8:
			                    hc.input(hc);
				                break;
				
                        }
                    }
                   else
                   {
                       System.out.println("Enter Correct Choice");
                   }
                  
                }
                catch(Exception e)
                {
                    System.out.println("Enter Correct Choice data");
		            loop=0;
                }
            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}