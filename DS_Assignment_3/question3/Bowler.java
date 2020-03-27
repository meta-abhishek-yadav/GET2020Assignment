package question3;

/**
 * this class holds the information of Bowler and setter and getter methods
 * @author Abhishek
 *
 */
public class Bowler {
private String name;
private int ball;
public Bowler(String name,int ball)
{
	this.name=name;
	this.ball=ball;
}
public String getName()
{
	return name;
}
public int getBall()
{
	return ball;
}
public void setBall(int ball)
{
this.ball=ball;	
}
}
