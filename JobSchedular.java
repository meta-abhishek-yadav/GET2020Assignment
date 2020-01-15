import java.util.*;
import java.io.*;
/**
 * JobSchedular class is class to schedule the class according the first come first serve scheduling
 * the class contain many method according to there functionality as completionTime,waitingTime and etc.
 **/
class JobSchedular
{
    private ArrayList<Integer> arrivalTime=new ArrayList<Integer>();
    private ArrayList<Integer> burstTime=new ArrayList<Integer>();
    private ArrayList<Integer> processName=new ArrayList<Integer>();
    private int noOfProcess,start,start2,minimum,total=0;
    private double averageWaitingTime=0,maximumWaitingTime=-1,temp;
    
    /**
     * getFirstProcessTime() method return the completion time calculated for given first process
     * @param start is index of process to calculate completion time
     * @return it returns the completion time calculated as integer
     * */
    private int getFirstProcessTime(int start)
    {
        return (burstTime.get(start)+arrivalTime.get(start));
    }
    /**
     * getOtherProcessTime() method return the completion time calculated for given index
     * @param start is index of process to calculate time
     * @param total is calculated time till that process
     * @return it returns the completion time calculated as integer
     * */
    private int getOtherProcessTime(int total,int start)
    {
        return (total+burstTime.get(start));
    }
    /**
     * completionTime is method to calculate the completion time of every process using the arrivalTime and burstTime of every process
     * it prints the completion time for every process
     **/
    private void completionTime()
    {
        System.out.println("Completion time of processes is as");
        System.out.println("Process           Completion time");
        total=0;
        
        for(start=0;start<noOfProcess;start++)
        {
            if(arrivalTime.get(start)>total)
            {
            total=this.getFirstProcessTime(start);
            }
            else
            {
            total=this.getOtherProcessTime(total,start);;
            }
            System.out.println("process "+processName.get(start)+"         "+total);
        }
	    System.out.println();
    }
    
    /**
     * waitingTime() is method to calculate the waiting time of every process using the arrivalTime and burstTime of every process
     * it prints the waiting time for every process
     **/
    private void waitingTime()
    {
        System.out.println("Waiting time of processes is as");
        System.out.println("Process           Waiting time");
        total=0;
        for(start=0;start<noOfProcess;start++)
        {
            if(arrivalTime.get(start)>total)
            {
                total=this.getFirstProcessTime(start);
                temp=0;
            }
            else
            {
	            temp=total-arrivalTime.get(start);
                total=this.getOtherProcessTime(total,start);;
            }
	        if(temp>maximumWaitingTime)
	        {
	            maximumWaitingTime=temp;
	        }
            System.out.println("process "+processName.get(start)+"         "+temp);
            averageWaitingTime=averageWaitingTime+temp;
        }
             System.out.println();

        }
    
    
    /**
     * turnAroundTime is method to calculate the turn Around time of every process using the arrivalTime and burstTime of every process
     * it prints the turn Around time for every process
     **/
    private void turnAroundTime()
    {
        System.out.println("Turn Around time of processes is as");
        System.out.println("Process           Turn Around time");
        total=0;
        for(start=0;start<noOfProcess;start++)
        {
            if(arrivalTime.get(start)>total)
            {
                total=this.getFirstProcessTime(start);
            }
            else
            {
                total=this.getOtherProcessTime(total,start);;
            }
            System.out.println("process "+processName.get(start)+"         "+(total-arrivalTime.get(start)));
	    }  
	    System.out.println();
    }
    
    /**
     * averagewaitingTime is method to calculate the averageWaitingtime of all process using the total waiting time
     **/
    private void averageWaitingTime()
    {
        averageWaitingTime=averageWaitingTime/noOfProcess;
	    System.out.println("Average Waiting Time is "+averageWaitingTime+"\n");
    }
    
     /**
     * maximumwaitingTime is method to calculate the maximumWaitingtime among all process using the waiting time of every process
     **/
    private void maximumWaitingPeriod()
    {
        System.out.println("Longest Waiting Time is "+maximumWaitingTime+"\n");
    }
    
    
    /**
     * swap() method swap the values
     * 
     */
    private void swap()
    {
    	int temp1;
        temp1=arrivalTime.get(minimum);
        arrivalTime.set(minimum,arrivalTime.get(start));
        arrivalTime.set(start,temp1);
        temp1=burstTime.get(minimum);
        burstTime.set(minimum,burstTime.get(start));
        burstTime.set(start,temp1);
        temp1=processName.get(minimum);
        processName.set(minimum,processName.get(start));
        processName.set(start,temp1);
    }
    /**
     * makeQueue is method to arrange queue of process according to their arrival time and sort the process according their arrival time
     **/
    private void makeQueue()
    {
        for(start=0;start<noOfProcess-1;start++)
        {
            minimum=start;
            for(start2=start+1;start2<noOfProcess;start2++)
            {
                if(arrivalTime.get(start2)<arrivalTime.get(minimum))
                {
                    minimum=start2;
                }
            }
            this.swap();
	        
	        
        }
      
    }
    /**
     * PrintMessage() method print the message if condition is unsatisfied and number is less than 0 
     * it also deceases the value of start by one
     * @param the object of JobSchedular class to decrease the value of start
     **/
    private void printMessage(JobSchedular js )
    {
        System.out.println("Enter Correct Valid Value");
		js.start--; 
    }
    
    /**
     * PrintMsg() method print the message if condition is unsatisfied and number is less than 0 
    **/
    private void printMsg( )
    {
        System.out.println("Enter Correct Valid Value");
    }
    
    public static void main(String []args)
    {
        JobSchedular js=new JobSchedular();
        try
        {
            Scanner sc=new Scanner(System.in);
	        int x,y;
            System.out.println("Enter the Number of Processes");
            js.noOfProcess=sc.nextInt();
            System.out.println("For Every process Enter Arrival Time and Burst Time");
            for(js.start=1;js.start<=js.noOfProcess;js.start++)
            {
                try
                {   
                    System.out.println("Process "+js.start);
		            x=sc.nextInt();
		            if(x<0)
		            {
		                js.printMessage(js);
		            }
		            else
		            {   
		                y=sc.nextInt();
		                if(y<=0)
		                {
		                    js.printMessage(js);
 
		                }
		                else
		                {
                            js.arrivalTime.add(x);
                            js.burstTime.add(y);
                            js.processName.add(js.start);
		                }
        	        }  
		        }
                catch(Exception e)
                {
                    js.printMessage(js);
                }
            }
	        js.makeQueue();
            js.completionTime();
            js.waitingTime();
            js.turnAroundTime();
            js.averageWaitingTime();
            js.maximumWaitingPeriod();   
        }
        catch(Exception e)
        {
            js.printMsg();
        }
       
    }
}
