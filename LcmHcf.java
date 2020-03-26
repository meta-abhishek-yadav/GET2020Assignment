package assignment5;

public class LcmHcf {
	/**
	 * lcm() method find the lcm of two numbers passed as parameter using recursion
	 * @param firstNumber first number to find lcm
	 * @param secondNumber second number to find lcm
	 * @param counter to hold the number to multiply with bigger number to find lcm   
	 * @return lcm of firstNumber and secondNumber
	 * @variable k to store temporary value of lcm
	 */
	/*public int lcm(int firstNumber,int secondNumber,int counter)
	{
		int k=0;
		try
		{
		if(firstNumber>=secondNumber)
		{
			if(((firstNumber*counter)%secondNumber)==0)
			{
				k=firstNumber*counter;
			}
			else
			{
				counter++;
				k=this.lcm(firstNumber,secondNumber,counter);
			}
		}
		else
		{
			if(((secondNumber*counter)%firstNumber)==0)
			{
				k=secondNumber*counter;
			}
			else
			{
				counter++;
				k=this.lcm(firstNumber,secondNumber,counter);
			}
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		return k;
	}*/
	/**
	 * hcf() method find the hcf of two numbers passed as parameter using recursion
	 * @param firstNumber first number to find hcf
	 * @param secondNumber second number to find hcf
	 * @return hcf of firstNumber and secondNumber
	 * @variable k to store temporary value of hcf
	 */
	public int hcf(int firstNumber,int secondNumber)
	{
		int k=0;

		try
		{			
		if(firstNumber%secondNumber==0)
		{
			k=secondNumber;
		}
		else
		{
			int j=firstNumber%secondNumber;
			firstNumber=secondNumber;
			secondNumber=j;
			k=this.hcf(firstNumber, secondNumber);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return k;
	}
	/**
	 * lcm() method find the lcm of two numbers passed as parameter using recursion
	 * @param firstNumber first number to find lcm
	 * @param secondNumber second number to find lcm
	 * @return lcm of firstNumber and secondNumber
	 * @variable k to store temporary value of lcm
	 */
	public int lcm(int firstNumber,int secondNumber)
	{
		int k=0;

		try
		{			
		k=hcf(firstNumber,secondNumber);
		k=(firstNumber*secondNumber)/k;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return k;
	}
}
