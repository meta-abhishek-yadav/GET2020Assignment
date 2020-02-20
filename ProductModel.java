package model;

public abstract class ProductModel {
	 public  int price[] = {45000,12000,17000,15000,25000,5000};//Array of Integer that hold the price value of corresponding item in item array 
	 public  String item[]={"Laptop","Mobile","Tv    ","Fridge","AC    ","Fan    "};// string array to hold the names of items 
	 public  String type[]={"electric","electric","electric    ","electric","electric    ","electric"};// string array to hold the names of items 
	 public int quantity,totalCost,priceOfItem,code;
	 public String itemName,typeName;
	 public abstract int getPrice(int code);
	
	 public abstract int getPrice();
	
	 public abstract int getCode();
	
	 public abstract int getQuantity();
	
	 public abstract int getTotalCost();
	
	 public abstract String getName(int code);
	
	 public abstract String getType(int code);
	
	 public abstract String getName();

	 public abstract  String getType();
	
	 public abstract void setQuantity(int quanitity);
	
	 public abstract void setCode(int code);
	
	 public abstract void setPrice(int price);

	 public abstract void setName(String name);
	
	 public abstract void setType(String type);
	 
	 public abstract void setTotalCost(int totalCost);
	 
}
