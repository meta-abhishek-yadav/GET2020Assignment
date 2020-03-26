package question3;

import java.util.ArrayList;
/**
 * this class find strategy that batsman can score lowest
 * @author Abhishek
 *
 */
public class LowestScore {
	ArrayList<Bowler> bowlers=new ArrayList<Bowler>();
	/**
	 * this method create list of all bowlers
	 */
	public void creatList()
	{
		bowlers.add(new Bowler("A",44));
		bowlers.add(new Bowler("B",25));
		bowlers.add(new Bowler("C",2));
		bowlers.add(new Bowler("D",10));
		bowlers.add(new Bowler("E",6));
	}
	/**
	 * this method sort all the bowlers according their ball left
	 */
	public void sort()
	{
		for(int i=0;i<bowlers.size()-1;i++)
		{
			for(int j=i+1;j<bowlers.size();j++)
			{
				if(bowlers.get(i).getBall()<bowlers.get(j).getBall())
				{
					Bowler bowler=bowlers.get(i);
					bowlers.set(i,bowlers.get(j));
					bowlers.set(j,bowler);
				}
			}
		}
		for(int i=0;i<bowlers.size();i++)
		{
		System.out.println(bowlers.get(i).getBall());
		}
	}
	public void shortSort()
	{
		int workdone=0;
		for(int i=0;i<bowlers.size()-1;i++)
		{
			for(int j=i+1;j<bowlers.size();j++)
			{
				if(bowlers.get(i).getBall()>bowlers.get(j).getBall())
				{
					workdone=1;
					break;
				}
				else
				{
					Bowler bowler=bowlers.get(i);
					bowlers.set(i,bowlers.get(j));
					bowlers.set(j,bowler);
				}
			}
			if(workdone==1) 
			{
				break;
			}
		}
	}
	/**
	 * this method show the bowling order of bowlers to score low
	 */
	public void showBowlingOrder()
	{
		while(bowlers.size()!=0)
		{
			bowlers.get(0).setBall(bowlers.get(0).getBall()-1);
			System.out.println(bowlers.get(0).getName()+" throw this ball and left with "+bowlers.get(0).getBall());
			if(bowlers.get(0).getBall()==0)
			{
				bowlers.remove(0);
			}
			this.shortSort();
		}
	}
	public static void main(String []args)
	{
		LowestScore lowestScore=new LowestScore();
		lowestScore.creatList();
		lowestScore.sort();
		lowestScore.showBowlingOrder();
		
	}

}
