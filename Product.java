package product;
import model.ProductModel;
public class Product extends ProductModel{

	 public int getPrice(int code)
	 {
		 return price[code];
	 }
	 public int getPrice()
	 {
		 return priceOfItem;
	 }
	 public int getCode()
	 {
		 return code;
	 }
	 public int getQuantity()
	 {
		 return quantity;
	 }
	 public int getTotalCost()
	 {
		 return totalCost;
	 }
	 public String getName(int code)
	 {
		 return item[code];
	 }
	 public String getType(int code)
	 {
		 return type[code];
	 }
	
	 public String getName()
	 {
		 return itemName;

	 }
	 public String getType()
	 {
		 return typeName;

	 }
	 public void setQuantity(int quanitity)
	 {
		 this.quantity=quanitity;
	 }
	 public void setCode(int code)
	 {
		 this.code=code;
	 }
	 public void setPrice(int price)
	 {
		 priceOfItem=price;
	 }
	 public void setName(String name)
	 {
		 itemName=name;
	 }
	 public void setType(String type)
	 {
		 typeName=type;
	 }
	 public void setTotalCost(int totalCost)
	 {
		 this.totalCost=totalCost;
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
        System.out.println("\t"+"item          price      code   type");

        for(int start=0;start<length;start++)
        {
          System.out.println("\t"+item[start]+"      "+price[start]+"      "+start+"  "+type[start]);
        } 

    }
}
