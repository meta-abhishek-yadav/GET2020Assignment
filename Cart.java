import java.util.*;
import java.io.*;

class Cart
{
    //list to store quantity of every selected item 
    private  ArrayList<Integer> selectedQuantity=new ArrayList<Integer>();
    //list to store the total ammount of selected a particular item 
    private  ArrayList<Double> ammount= new ArrayList<Double>();
    //list to store the code of selected item
    private  ArrayList<Integer> selectedCode=new ArrayList<Integer>();
    //variables to different purpose as length to hold size of list and other variables to hold flags 
    private  int length=0,start,flag=0;
    double price=0;
	
    /**
    * this findItem method find existence of the item in list
    * @param code is the selected code by user in main method
    * @return flag as -1 if item is not found and index of item if item is finded
    * **/
    private int findItem(int code)
	{
	 	flag=-1;
	 	length=selectedCode.size();
	    for(start=0;start<length;start++)
	        {
	        if(selectedCode.get(start)==code)
	    	    {
	    	        flag=start;
	    	        break;
	    	    }
	    	 }
		return flag;
    }
    
    
    /**
    * this method add the item in cart as selected quantity
    * @param code is the code of item as selecteditem
    * @param quantity is no of items selected to add in cart
    * @return is void type as it does not return anything
    **/
    private void addItem(int code,int quantity)
	{
	    try
	    {
            Items items=new Items();
	        length=selectedCode.size(); 
	        if(length==0)
		        {
		        selectedCode.add(code);
		        selectedQuantity.add(quantity);
		        price=items.getPrice(code)*selectedQuantity.get(0);
		        ammount.add(price);
		        }
	        else
	            {
	                
	            flag=this.findItem(code);
	           if(flag!=-1)
	                {
	                selectedQuantity.set(flag,selectedQuantity.get(flag)+quantity);
	                price=items.getPrice(code)*selectedQuantity.get(flag);
	                ammount.set(start,price);
	                }
	           else if(flag==-1)
	                {
	                selectedCode.add(code);
	                selectedQuantity.add(quantity);
	                price=items.getPrice(code)*quantity;
	                ammount.add(price);
	                }
            	}
	    }
	    catch(Exception e)
	        {
		    System.out.println(e.getMessage());
	        }	
    }

    /**
    * this method remove the item in cart as selected  and if item is not in cart than handle as well
    * @param code is the code of item as selecteditem to remove
    * @return is void type as is does not return 
    **/

    private void removeItem(int code)
	    {
	    try
	        {
            length=selectedCode.size();
	    	 if(length==0)
	    	    {
	    	    System.out.println("Nothing to remove from Cart");
	        	}
	    	 else
	    	    {
	    	    flag=this.findItem(code);	  
		        if(flag!=-1)
	    	        {
	    	        selectedCode.remove(flag);
	    	        selectedQuantity.remove(flag);
	    	        ammount.remove(flag);
	    	        System.out.println("Item removed Successfully");
	    	        }
	    	    else if(flag==-1)
	    	        {
	    	        System.out.println("item is not in cart");
	    	        }
	    	    }
	        }
	    catch(Exception e)
	        {
		    System.out.println(e.getMessage());
	        }
    }



	
    /**
    * this method update the item in cart as selected quantity and handle 0 quantity problem
    * @param code is the code of item as selecteditem
    * @param quantity is no of items selected to add in cart
    * @return its return type is void
    **/
    private void updateCart(int code,int quantity)
	    {
	    try
	        {       
	         Items items=new Items();
	         flag=this.findItem(code);
	    	    if(flag!=-1)
	    	    {
	    	        if(quantity==0)
	    	        {
	    	        selectedCode.remove(flag);
	    	        selectedQuantity.remove(flag);
	    	        ammount.remove(flag);
	    	        }
	    	        else
	    	        {
	    	        selectedQuantity.set(flag,quantity);
	    	        price=items.getPrice(code)*quantity;
	    	        ammount.set(flag,price);
	    	        }
                 System.out.println("Item updated Successfully");
	    	    }
	    	    else if(flag==-1)
	    	    {
                    System.out.println("Item is not in cart to update please add it ");
	            }
	        }
	    catch(Exception e)
	        {
	    	System.out.println(e.getMessage());
        	}
	}

    /**
     * showCart method display all the  selected items and  quantity
    * @param it is no parameter
    * @return it has void return type
    **/
    private void showCart()
	    {
	    try
	    {
	    Items items=new Items();
    	length=selectedCode.size();
	    if(length==0)
	        {
        	System.out.println("cart is empty");
     	    }
    	else
	        {
        	System.out.println("Your Current Cart is as\n \tSelected Item\t\tQuantity");
 	length=selectedCode.size();
 	for(start=0;start<length;start++)
 	{
 	    System.out.print("\t"+items.getName(selectedCode.get(start)));
 	    System.out.println("\t\t"+"               "+selectedQuantity.get(start));

 	}
	}
	System.out.println("\n");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
}
	
/**
 * generateBill method display all the  selected items and  quantity and ammount 
 * @param it is no parameter
 * @return it has void return type
 **/
private void generateBill()
	{
	    try
	    {
	   Items items=new Items();
	//Generating the bill to the user
	  length=selectedCode.size();
	if(length==0)
	{
	System.out.println("cart is empty");
	}
	else
	{
	  double totalAmmount=0;
	System.out.println("Your Cart Bill is as\n \tSelected Item\tQuantity\tammount");
 	length=selectedCode.size();
 	for(start=0;start<length;start++)
 	{
 	    System.out.print("\t"+items.getName(selectedCode.get(start)));
 	    System.out.print("\t\t"+selectedQuantity.get(start));
 	    System.out.println("\t\t"+ammount.get(start));
 	    totalAmmount=totalAmmount+ammount.get(start);
 	}
 	System.out.println("\t"+"total Bill Ammount         "+totalAmmount+"\n");
	}
	    }
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
}

	
/**
 * main method is used here to user intraction and showing user all the options and taking choices from user
 * it contains while loop untill user want to use the system and untill does not exit
 * @param it is no parameter
 * @return it has void return type
 **/	
public static void main(String []args)
	{
		try
		{
		Cart cart =new Cart();//creating the object of cart class
		System.out.println("Welcome to our ElectroShop\n We have these items with there prices and codes");
		Items items=new Items();
		items.showItems();
		int loop=1,choice=0;
		Scanner sc=new Scanner(System.in);
		/**
		 * while loop to run until user is willing to oparte on system and do not exit
		 * 
		 * **/
		while(loop==1)
		{
			//while loop run until user do not exit perform actions
		    System.out.println("\nyou can choose code from given options\n \tcode        option");
		    System.out.println(" \t1\tAdd item to cart \n\t2\tRemove item from code \n\t3\tUpdate cart items \n \t4\tShow the cart \n \t5\tGet Bill \n \t0\tExit ");
		    
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
		                 
		            
		            if(code>=0 && code<=5)
		            {
				//checking whether the eneterd code is correct or not
		            System.out.println("Enter the quantity of item to Add in Cart");
		            int quantity=0;
		             try 
		                 {
		                quantity =sc.nextInt(); 
		            cart.addItem(code,quantity);
		            System.out.println("Item Added Successfully");
		                     
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
		               
		            if(code2>=0 && code2<=5)
		            {
		            cart.removeItem(code2);
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
		                
		            if(code3>=0 && code3<=5)
		            {
		            System.out.println("Enter the quantity of item to update in Cart");
		             int quantity=0;
		             try 
		                 {
		                quantity =sc.nextInt(); 
		                 
		            cart.updateCart(code3,quantity);
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
		            cart.showCart();
		            break;
		    case 5: 
		            cart.generateBill();
		            break;
		    default:
		            System.out.println("Select the correct option ");
		            break;
		            
		    }
		    
		      
		    
		}
		

	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}

}

class Items
{
    private  double price[] = {45000,12000,17000,15000,25000,5000};//Array of Double that hold the price value of corresponding item in item array 
    private  String item[]={"Laptop","Mobile","Tv    ","Fridge","AC    ","Fan    "};// string array to hold the names of items 
    /**
    *getPrice method is to return the price of item selected as code
    * @param code is the index of item selected by user in cart class
    * @return this method return the price of selected item from array
    **/
    public  double getPrice(int code)
    {
    return price[code];
    }
/**
 *getName method is to return the price of item selected as code
 * @param code1 is the index of item selected by user in cart class
 * @return this method return the name of selected item from array
 **/
    public  String getName(int code1)
    {
     return item[code1];
    }
/**
 *showItems method is to show the items and price with their code
 * @param there is no parameter
 * @return this method return nothing
 **/
    public  void showItems()
    {
         System.out.println("\n\n We have these items with there prices and codes");
        int length=item.length;
        System.out.println("\t"+"item          price      code");

        for(int start=0;start<length;start++)
        {
          System.out.println("\t"+item[start]+"      "+price[start]+"      "+start);
        }

    }
}
