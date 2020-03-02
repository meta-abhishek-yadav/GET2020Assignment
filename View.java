package view;

import java.util.ArrayList;
import java.util.Scanner;

import product.Product;
import controller.*;
public class View {
	public static void main(String []args)
	{
	System.out.println("Welcome to our ElectroShop\n We have these items with there prices and codes");
	Product items=new Product();
	items.showItems();
	Controller controller=new Controller();
	int loop=1,choice=0;
	Scanner sc=new Scanner(System.in);
	/**
	 * while loop to run until user is willing to operate on system and do not exit
	 * 
	 * **/
	while(loop==1)
	{
		//while loop run until user do not exit perform actions
	    System.out.println("\nyou can choose code from given options\n \tcode        option");
	    System.out.println(" \t1\tAdd item to cart \n\t2\tRemove item from code \n\t3\tUpdate cart items \n \t4\tShow the cart\n\t0\tExit ");
	    
	    try 
	    {
	    choice =sc.nextInt(); 
	    }
	    catch(Exception e)
	    {
	        System.out.println("please enter correct value type");
	    }
	    switch(choice)
	    {
		//switch is used to call the functions as user select options 
	        case 0:
	            loop=0;
	            System.out.println("Thank you for using our System");
	            break;
	        case 1:
	            items.showItems();
	            System.out.println("Enter the Code of item to Add in Cart");
	            int code=0;
	             try 
	                 {
	                code =sc.nextInt(); 
	            if(code>=0 && code<=4)
	            {
			//checking whether the entered code is correct or not
	            System.out.println("Enter the quantity of item to Add in Cart");
	            int quantity=0;
	             try 
	                 {
	                quantity =sc.nextInt();    
	            System.out.println(controller.action(choice,code,quantity));
	                     
	                 }
	             catch(Exception e)
	                {
	             System.out.println("please enter correct value type");
	              loop=0;
	                }
	            }
	            else
	            {
	                System.out.println("Please enter Correct code");
	            }
	                 }
	              catch(Exception e)
	                {
	             System.out.println("please enter correct value type");
	                loop=0;
	                break;
	                }
	                break;
	           
         	       case 2:
	            items.showItems();
	            System.out.println("Enter the Code of item to remove from Cart");
	             int code2=0;
	             try 
	                 {
	                code2 =sc.nextInt(); 
	               
	            if(code2>=0 && code2<=4)
	            {
	                System.out.println(controller.action(code2));
	            }
	            else
	            {
	                System.out.println("Please enter Correct code");
	            }
	                 }
	              catch(Exception e)
	                {
	             System.out.println("please enter correct value type");
	             loop=0;
	             break;
	                }
	            break;	
	    case 3: 
	            items.showItems();
	            System.out.println("Enter the Code of item to update in Cart");
	             int code3=0;
	             try 
	                 {
	                code3 =sc.nextInt(); 
	                
	            if(code3>=0 && code3<=4)
	            {
	            System.out.println("Enter the quantity of item to update in Cart");
	             int quantity=0;
	             try 
	                 {
	                quantity =sc.nextInt(); 
	                 
	                System.out.println(controller.action(choice,code3,quantity));
	                 }
	              catch(Exception e)
	                {
	             System.out.println("please enter correct value type");
	                loop=0;
	                break;
	                }
	            }
	            else
	            {
	                System.out.println("Please enter Correct code");
	            }
	                 }
	              catch(Exception e)
	                {
	             System.out.println("please enter correct value type");
	             loop=0;
	             break;
	                }
	             break;
	             case 4:
	    	ArrayList<Product> product=controller.action();
	    	System.out.println("code\tItem Name\tItem Type\tPrice\tQuantity\tTotalCost");
	    	for(int i=0;i<product.size();i++)
	    	{
	            System.out.println(product.get(i).getCode()+"\t  "+product.get(i).getName()+"\t  "+product.get(i).getType()+"\t "+product.get(i).getPrice()+"\t  "+product.get(i).getQuantity()+"\t    "+product.get(i).getTotalCost());

	    	}
       	            break;
	    default:
	            System.out.println("Select the correct option ");
	            break;
	            
	    } 
	}
}
}

