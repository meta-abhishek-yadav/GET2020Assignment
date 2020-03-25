package question2;
/**
 *  item class hold the priority and data of the item of priority queue with their getter methods
 * @author Abhishek
 *
 */
public class Item {
	int data;
	int priority;
	Item(int data,int priority)
	{
		this.data=data;
		this.priority=priority;
	}
	public int getData()
	{
		return data;
	}
	public int getPriority()
	{
		return priority;
	}
}
