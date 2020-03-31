package question2;

import java.util.ArrayList;
/**
 * this class holds the data item with their priority and delete them according to their priority
 * @author Abhishek
 *
 */
public class PriorityQueue implements IPriorityQueue {
	ArrayList<Item> priorityQueue=new ArrayList<Item>();
	int index=0;
	/**
	 * @return the highest priority of the queue
	 */
	public int getHighestPriority() {
		int max=priorityQueue.get(0).getPriority();
		for(int i=1;i<priorityQueue.size();i++)
		{
			if(priorityQueue.get(i).getPriority()>max)
			{
				max=priorityQueue.get(i).getPriority();
				index=i;
			}
		}
		return max;
	}
	/**
	 * @return the index of highest priority item
	 */
	public int getHighestPriorityIndex() {
		this.getHighestPriority();
		return index;
	}
	/**
	 * this method delete the highest priority item
	 */
	public void delete() {
		int index=this.getHighestPriorityIndex();
		priorityQueue.remove(index);
	}
	/**
	 * this method insert the item in the queue with their data and priority
	 */
	public void insert(int data, int priority) {
		priorityQueue.add(new Item(data,priority));
	}
	/**
	 * this method print the queue 
	 */
	public void printPriorityQueue()
	{
		if(priorityQueue.size()==0)
		{
			System.out.println("queue is empty");
		}
		else
		{
			System.out.println("\nqueue is as ");
		for(int i=0;i<priorityQueue.size();i++)
		{
		System.out.println("data = "+priorityQueue.get(i).getData()+" priority =  "+priorityQueue.get(i).getPriority());
		}
		}
	}
	public static void main(String []args)
	{
		PriorityQueue priorityQueue=new PriorityQueue();
		priorityQueue.insert(10, 12);
		priorityQueue.insert(20, 10);
		priorityQueue.insert(30, 9);
		priorityQueue.insert(40, 14);
		priorityQueue.printPriorityQueue();
		priorityQueue.delete();
		priorityQueue.printPriorityQueue();
		System.out.println("Highest priority is = "+priorityQueue.getHighestPriority());

	}
	
}
