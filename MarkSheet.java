import java.io.*;
import java.util.*;

/**
 * class MarkSheet create mark sheet as it calculate average of all students grade 
 * it also finds maximum and minimum grade
 * the total number of passed students is also calculated
 * 
 */
class MarkSheet
{
    private double noOfStudent,total=0,maximum,minimum;
    private int start;
    /**
     * average() method calculate the average of grades of all students
     * @param it accept arraylist of marks as parameter
     * @return it returns the average of all grades as double
     * */
    private double average(ArrayList<Double> marks)
    {
        noOfStudent=marks.size();
        for(start=0;start<noOfStudent;start++)
        {
            total=total+marks.get(start);
            if(start==0)
            {
             maximum=marks.get(start);
             minimum=marks.get(start);
            }
            else 
            {
                if(marks.get(start)>maximum)
                {
                    maximum=marks.get(start);
                }
                if(marks.get(start)<minimum)
                {
                    minimum=marks.get(start);
                }
            }
        }
        total=total/noOfStudent;
        return total;
    }
    /**
     * maximum() method returns the maximum of all grades
     * @return return the maximum grade
     */
    private double maximum()
    {
        return maximum;
    }
    /**
     * minimum() method returns the maximum of all grades
     * @return return the minimum grade
     */
    private double minimum()
    {
        return minimum;
    }
    /**
     * passPercentage() method calculate the percentage of students who got grades >=40
     * @param it accept arraylist of marks as parameter
     * @return it returns the percentage of  pass students
     * 
     * */
    private double passPercentage(ArrayList<Double> marks)
    {
        double passed=0;
        noOfStudent=marks.size();
        for(start=0;start<noOfStudent;start++)
        {
            if(marks.get(start)>=40)
            {
                passed++;
            }
        }
        passed=(passed/noOfStudent)*100;
        return passed;
    }
    /**
     * main() method take inputs from user and shows output to user and handle the Exceptions
     */
    public static void main(String args[])
    {
        try
        {
            MarkSheet marksheet=new MarkSheet();
            double mark;
            int number;
            ArrayList<Double> marks=new ArrayList<Double>();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Number of students");
            number=sc.nextInt();
            System.out.println("Enter grades for "+number+" students");
            for(int i=1;i<=number;i++)
            {
                try
                {
                    mark=sc.nextDouble();
                    if(mark>100 || mark<0)
                    {
                        System.out.println("Enter marks between 0 and 100 inclusive");
                        i--;
                    }
                    else
                    {
                    marks.add(mark);
                    }
                }
                catch(ArithmeticException ex1 )
                {
                    System.out.println(ex1.getMessage());
                }
                catch(Exception ex)
                {
                    System.out.println("Please enter correct value type");
                }
            }
            System.out.printf("average of grades is = %.2f\n",marksheet.average(marks));
            System.out.printf("maximum of grades is = %.2f\n",marksheet.maximum());
            System.out.printf("minimum of grades is = %.2f\n",marksheet.minimum());
            System.out.printf("Percentage of passed students= %.2f\n",marksheet.passPercentage(marks));
            
            
        }
        catch(ArithmeticException ex1 )
        {
            System.out.println(ex1.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Please enter corret value type 1"+e.getMessage());
        }
    }
}