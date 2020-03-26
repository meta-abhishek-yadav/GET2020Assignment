package question3;
/**
 * pogram class that hold the data of program 
 * @author Abhishek
 *
 */
public class Program {
private String name;
private int capacity;
public int occupied=0;
public Program(String name,int capacity)
{
	this.name=name;
	this.capacity=capacity;
}
public String getName()
{
	return name;
}
public int getCapacity()
{
	return capacity;
}
}
