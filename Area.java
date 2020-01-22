import java.io.*;
import java.util.*;
/**
 * Area class has many method to calculate the area of different shapes and return the area  
 * 
 **/
class Area
{
    /**
     * triangle() method calculate the area for triangle using width and height
     * @param width is width of triangle
     * @param height is height of triangle
     * @return it return the area of triangle 
     */
    private double triangle(double width,double height)
    {
        return (0.5*width*height);
    }
     /**
     * rectangle() method calculate the area for rectangle using width and height
     * @param width is width of rectangle
     * @param height is height of rectangle
     * @return it return the area of rectangle 
     */
    private double rectangle(double width,double height)
    {
        return (width*height);
    }
     /**
     * square() method calculate the area for triangle using width 
     * @param width is width/side of square
     * @return it return the area of square 
     */
    private double square(double width)
    {
        return (width*width);
    }
     /**
     * circle() method calculate the area for triangle using radius
     * @param radius is radius of circle
     * @return it return the area of circle 
     */
    private double circle(double radius)
    {
        double pi=3.14;
        return (pi*radius*radius);
    }
    /**
     * input() takes method input from user 
     * @param parameter message is message the that is shown to user
     * @return it return the double value inserted by user
     */
    private double input(String message)
    {
        System.out.println(message);
        Scanner sc=new Scanner(System.in);
       	double value =sc.nextDouble();
       	if(value<0)
       	{
       		System.out.println("Please enter correct value");
       		value=this.input(message);
       	}
       	return value;
    }
    public static void main(String []args)
    {
        double width,height,radius,areaCalculated;
        System.out.println("Welcome to Area Calculator");
        System.out.println("You can choose shape as According to given code");
        int choice=0,loop=1;
        Scanner sc=new Scanner(System.in);
        Area area=new Area();
        while(loop==1)
        {
            try
            {
                
                System.out.println("\t1\tTriangle\n\t2\tReactangle\n\t3\tSquare\n\t4\tCircle\n\t0\tExit");
                choice=sc.nextInt();
                if(choice>=0 && choice<=4)
                {
                    switch(choice)
                    {
                        case 0:
                            System.out.println("Thank You");
                            loop=0;
                            break;
                        case 1:
                            width=area.input("Enter width of Triangle");
                            height=area.input("Enter height of Triangle");
                            areaCalculated=area.triangle(width,height);
                            System.out.printf("Area of Triangle is = %.2f\n",areaCalculated);
                            break;
                        case 2:
                            width=area.input("Enter width of Rectangle");
                            height=area.input("Enter height of Rectangle");
                            areaCalculated=area.rectangle(width,height);
                            System.out.printf("Area of Rectangle is = %.2f\n ",areaCalculated);
                            break;
                        case 3:
                            width=area.input("Enter width of Square");
                            areaCalculated=area.square(width);
                            System.out.printf("Area of Square is = %.2f\n",areaCalculated);
                            break;
                        case 4:
                            radius=area.input("Enter radius of Circle");
                            areaCalculated=area.circle(radius);
                            System.out.printf("Area of Circle is = %.2f\n ",areaCalculated);
                            break;
                            
                    }
                }
                else
                {
                    System.out.println("Please enter Correct choice");
                }
            }
            catch(ArithmeticException ex1 )
            {
                System.out.println(ex1.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Please enter Correct value type");
                break;
            }
        }
    }
}