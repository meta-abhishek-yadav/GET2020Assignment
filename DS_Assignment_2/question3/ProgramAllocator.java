package question3;

import java.util.ArrayList;
/**
 * this class allotcate programs to students according to their preference and their rank
 * @author Abhishek
 *
 */
public class ProgramAllocator implements IQueue {
	
	Student queue[]=new Student[Max_Size];
	/**
	 * 
	 * @return the list to programs to allocate
	 */
	public Program[] getPrograms()
	{
		Program programs[]=new Program[5];
		Program program1=new Program("btech",0);
		Program program2=new Program("bsc",1);
		Program program3=new Program("bba",1);
		Program program4=new Program("bca",1);
		Program program5=new Program("ba",1);
		programs[0]=program1;
		programs[1]=program2;
		programs[2]=program3;
		programs[3]=program4;
		programs[4]=program5;
		return programs;

	}
	int front=0,rear=0;
	/**
	 * this method check whether queue is full or not return true if queue is full else return false
	 */
	public Boolean isFull()
	{
		int end=0;
		if((rear+1==front) ||(front==0 && rear==Max_Size) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * this method check whether queue is empty or not return true if queue is empty else return false
	 */
	public Boolean isEmpty()
	{
		if((front==rear))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * this method delete the value from front of the queue if queue is not empty
	 */
	public Student dequeue()
	{
		Student student=null;
		if(this.isEmpty())
		{
			System.out.println("Queue is already Empty");
		}
		else
		{
			if(front==Max_Size)
			{
				front=0;
			}
			student=queue[front];
			front++;
		}
		return student;
	}
	/**
	 * this method add the item to the queue
	 * @param item is the item to add in the queue
	 */
	public void add(Student item)
	{
		if(this.isFull())
		{
			System.out.println("Queue is already full");
		}
		else 
		{
		if(rear==Max_Size)
		{
			rear=0;
		}
		queue[rear]=item;
		rear++;

		}
	}
	/**
	 * 
	 * @param programs the list of programs that have to allocated
	 */
	public void allocateProgram(Program[] programs)
	{
		while(!this.isEmpty())
		{
			Student student=this.dequeue();
			String programPrefernces[]=student.getPrograms();
			int alloted=0;
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<programs.length;j++)
				{
					if(programPrefernces[i].equals(programs[j].getName()))
					{
						if(programs[j].occupied < programs[j].getCapacity())
						{
							alloted=1;
							programs[j].occupied++;
							student.programAlloted=programs[j].getName();
							System.out.println(programs[j].getName()+"  program alloted to "+student.getName());
							break;
						}
					}

				}
				if(alloted==1)
				{
					break;
				}
			}
			if(alloted==0)
			{
				System.out.println("No program available to allotcate to "+student.getName());
			}
		}
	}
	public static void main(String []args)
	{
		ProgramAllocator programAllocator=new ProgramAllocator();
		String student1prefernces[]=new String[5];
		student1prefernces[0]="btech";
		student1prefernces[1]="bsc";
		student1prefernces[2]="bba";
		student1prefernces[3]="bca";
		student1prefernces[4]="ba";
		Student student1=new Student("A",student1prefernces);
		String student2prefernces[]=new String[5];
		student2prefernces[0]="btech";
		student2prefernces[1]="bsc";
		student2prefernces[2]="bba";
		student2prefernces[3]="bca";
		student2prefernces[4]="ba";
		Student student2=new Student("B",student1prefernces);
		String student3prefernces[]=new String[5];
		student3prefernces[0]="btech";
		student3prefernces[1]="bsc";
		student3prefernces[2]="bba";
		student3prefernces[3]="bca";
		student3prefernces[4]="ba";
		Student student3=new Student("C",student1prefernces);
		String student4prefernces[]=new String[5];
		student4prefernces[0]="btech";
		student4prefernces[1]="bsc";
		student4prefernces[2]="bba";
		student4prefernces[3]="bca";
		student4prefernces[4]="ba";
		Student student4=new Student("D",student1prefernces);
		String student5prefernces[]=new String[5];
		student5prefernces[0]="btech";
		student5prefernces[1]="bsc";
		student5prefernces[2]="bba";
		student5prefernces[3]="bca";
		student5prefernces[4]="ba";
		Student student5=new Student("E",student1prefernces);
		String student6prefernces[]=new String[5];
		student6prefernces[0]="btech";
		student6prefernces[1]="bsc";
		student6prefernces[2]="bba";
		student6prefernces[3]="bca";
		student6prefernces[4]="ba";
		Student student6=new Student("F",student1prefernces);
		programAllocator.add(student1);
		programAllocator.add(student2);
		programAllocator.add(student3);
		programAllocator.add(student4);
		programAllocator.add(student5);
		programAllocator.add(student6);
		Program programs[]=programAllocator.getPrograms();
		programAllocator.allocateProgram(programs);

	}
	
}
