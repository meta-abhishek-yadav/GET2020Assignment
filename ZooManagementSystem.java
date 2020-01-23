package Assignment8;

import java.util.*;
/**
 * this class give options to user to perform operation
 * it uses switch to selected operation according to user choice
 * takes required input from user when needed and show output 
 *
 */
public class ZooManagementSystem
{

	public static void main(String[] args) 
	{
		try
		{
		int choice=0;
		NorthZone northzone=new NorthZone();
		EastZone eastzone=new EastZone();
		WestZone westzone=new WestZone();

		while(true)
		{		System.out.println("Zoo has 3 zones as \n 1. North Zone is for Mammals and  zone has number of total cages = "+northzone.numberOfTotalCages()+" number of filled cages = "+northzone.numberOfFilledCages()+"   cage capacity =1 \n 2. East Zone is for Reptiles and zone has number of total cages = "+eastzone.numberOfTotalCages()+" number of filled cages = "+eastzone.numberOfFilledCages()+"   cage capacity =1\n 3. West Zone is for Birds and zone has number of total cages = "+westzone.numberOfTotalCages()+" number of filled cages = "+westzone.numberOfFilledCages()+"   cage capacity =1");

			System.out.println("You can Perform following Operations\n 1. Add Animal\n 2. Remove/Death of Animal\n 3. Add Cage to Zone\n 4. get Details of Zone \n 0. Exit");
			Scanner scanner=new Scanner(System.in);
			choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter class of Animal");
				String animalClass=scanner.nextLine();
				System.out.println("Enter type of Animal");
				String animalType=scanner.nextLine();
				System.out.println("Enter Name of Animal");
				String name=scanner.nextLine();
				System.out.println("Enter Sound of Animal");
				String sound=scanner.nextLine();
				System.out.println("Enter Age of Animal");
				int age=scanner.nextInt();
				System.out.println("Enter Weight of Animal");
				int weight=scanner.nextInt();
				boolean result=false;
				if(animalClass.equalsIgnoreCase("mammal"))
				{
					if(animalType.equalsIgnoreCase("lion"))
					{
						Animal lion=new Lion(age,weight,name,sound);
						result=northzone.addAnimal(lion);
					}
				}
				else if(animalClass.equalsIgnoreCase("reptile"))
				{
					if(animalType.equalsIgnoreCase("cocrodile"))
					{
						Animal cocrodile=new Cocrodile(age,weight,name,sound);
						result=eastzone.addAnimal(cocrodile);
					}				
				}
				else if(animalClass.equalsIgnoreCase("bird"))
				{
					if(animalType.equalsIgnoreCase("peigon"))
					{
						Animal peigon=new Peigon(age,weight,name,sound);
						result=westzone.addAnimal(peigon);
					}				
				}
				if(result==true)
				{
					System.out.println("Animal Addition Successful");
				}
				else
				{
					System.out.println("Animal Addition failed");
				}
				break;
			case 2:
				System.out.println("Enter name of Animal");
				String animalName=scanner.nextLine();
				System.out.println("Enter name of Zone");
				String zone=scanner.nextLine();
				System.out.println("Enter no of cage starting from 0");
				int cageno=scanner.nextInt();
				boolean output=false;
				if(zone.equalsIgnoreCase("northZone"))
				{
					output=northzone.deathOfAnimal(cageno, animalName);
				}
				else if(zone.equalsIgnoreCase("eastZone"))
				{
					output=eastzone.deathOfAnimal(cageno, animalName);
				}
				else if(zone.equalsIgnoreCase("westZone"))
				{
					output=westzone.deathOfAnimal(cageno, animalName);
				}
				else
				{
					System.out.println("Enter Correct Zone");
				}
				if(output==true)
				{
					System.out.println("Animal Removal Successful");
				}
				else
				{
					System.out.println("Animal Removal failed");
				}
				break;
			case 3:
				System.out.println("Enter Zone name");
				String zoneName=scanner.nextLine();
				if(zoneName.equalsIgnoreCase("northZone"))
				{
					northzone.addCage();
				}
				else if(zoneName.equalsIgnoreCase("eastZone"))
				{
					eastzone.addCage();
				}
				else if(zoneName.equalsIgnoreCase("westZone"))
				{
					westzone.addCage();
				}
				break;
			case 4:
				System.out.println("Enter Zone name");
				String zonename=scanner.nextLine();
				if(zonename.equalsIgnoreCase("northZone"))
				{
					System.out.println("Zone has Park = "+northzone.hasPark());
					System.out.println("Zone has Canteen = "+northzone.hasCanteen());
					northzone.showDetails();
				}
				else if(zonename.equalsIgnoreCase("eastZone"))
				{
					System.out.println("Zone has Park = "+northzone.hasPark());
					System.out.println("Zone has Canteen = "+northzone.hasCanteen());
					eastzone.showDetails();

				}
				else if(zonename.equalsIgnoreCase("westZone"))
				{
					System.out.println("Zone has Park = "+northzone.hasPark());
					System.out.println("Zone has Canteen = "+northzone.hasCanteen());	
					westzone.showDetails();
				}
				break;
			}
			if(choice==0)
			{
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
/**
 * Animal class is base class that hold property and variables which define the animal quality and other classes inherit this class to use
 * @author Abhishek
 */

class  Animal
{
	private int age,weight;
	private String name,sound;
	public Animal(int age,int weight,String name,String sound)
	{
		this.age=age;
		this.weight=weight;
		this.name=name;
		this.sound=sound;
	}
	/**
	 * @return age of animal
	 */
	public  int getAge()
	{
		return age;
	}
	/**
	 * @return weight of animal
	 */
	public  int getWeight()
	{
		return weight;
	}
	/**
	 * @return name of animal
	 */
	public  String getName()
	{
		return name;
	}
	/**
	 * @return sound of animal
	 */
	public  String getSound()
	{
		return sound;
	}
	
}
 class Mammal extends Animal
{
	public Mammal(int age, int weight, String name, String sound) 
	{
		super(age, weight, name, sound);
	}
}
 class Reptile extends Animal
{

	public Reptile(int age, int weight, String name, String sound) 
	{
		super(age, weight, name, sound);
	}
	
}
 class Bird extends Animal
{

	public Bird(int age, int weight, String name, String sound) 
	{
		super(age, weight, name, sound);
	}

}
class Lion extends Mammal
{

	public Lion(int age, int weight, String name, String sound)
	{
		super(age, weight, name, sound);
	}
	
}
class Tiger extends Mammal
{

	public Tiger(int age, int weight, String name, String sound) {
		super(age, weight, name, sound);
	}
	
}
class Cocrodile extends Reptile
{

	public Cocrodile(int age, int weight, String name, String sound)
	{
		super(age, weight, name, sound);
	}
	
}
class Peigon extends Bird
{

	public Peigon(int age, int weight, String name, String sound)
	{
		super(age, weight, name, sound);
		System.out.println(this.getSound());
	}
	
	
}
abstract class Zone
{
	abstract int numberOfTotalCages();
	abstract int numberOfFilledCages();
	abstract boolean hasPark();
	abstract boolean hasCanteen();
	abstract boolean addAnimal(Animal animal);
	abstract boolean deathOfAnimal(int cageNumber,String animalName);
	abstract void addCage();
	/**
	 * this method add animal to cage if space is available
	 * @param animal object of animal class to access details of animal
	 * @param totalCages number of cages in zone
	 * @param filledCages number of filled cages in zone
	 * @return object of cage class if animal is added successful 
	 */
	Cage addAnimal(Animal animal,int totalCages,int filledCages)
	{
		Cage cage=null;
		System.out.println(totalCages);
		if(filledCages>=totalCages)
		{
			System.out.println("All cages are filled please add new cage");
			return cage;
		}
		else
		{
			cage=new Cage();
			boolean result=cage.addAnimal(animal);
			if(result==false)
			{
				cage=null;
			}
			return cage;
		}	
	}
	/**
	 * 
	 * @param cageNumber number of cage where animal is dead
	 * @param animalName name of animal
	 * @param filledCages number of 
	 * @param cageAnimal list of objects of cage which have stored the animal details
	 * @return true is animal is dead and removed successfully
	 */
	boolean deathOfAnimal(int cageNumber,String animalName,int filledCages,ArrayList<Cage> cageAnimal )
	{
		if(filledCages<=0 || cageNumber>=filledCages )
		{
			return false;
		}
		else
		{
			if((cageAnimal.get(cageNumber).deathOfAnimal(animalName))!=-1)
			{
				cageAnimal.remove(cageNumber);
				return true;
			}
			else
			{
			return false;
			}
		}
	}
	/**
	 * showdetails to zone to user
	 * @param cageAnimal arrayList that holds the cage object where animals are added and their deatils are stored
	 */
	void showDetail(ArrayList<Cage> cageAnimal)
	{
		for(int i=0;i<cageAnimal.size();i++)
		{
			for(int j=0;j<cageAnimal.get(i).animalDetails.size();j++)
			{
				System.out.println("Name of Animal="+cageAnimal.get(i).animalDetails.get(j).getName());
				System.out.println("sound of Animal="+cageAnimal.get(i).animalDetails.get(j).getSound());
				System.out.println("age of Animal="+cageAnimal.get(i).animalDetails.get(j).getAge());
				System.out.println("weight of Animal="+cageAnimal.get(i).animalDetails.get(j).getWeight());
				System.out.println("\n");
			}
		}
	}
	
}
class NorthZone extends Zone
{
	ArrayList<Cage> cageAnimal=new ArrayList<Cage>();
	private int totalCages=7;
	private int filledCages=0;
	/**
	 * @return number of Total cages
	 */
	int numberOfTotalCages()
	{
		return totalCages;
	}
	/**
	 * @return number of  filled cages
	 */
	int numberOfFilledCages()
	{
		return filledCages;
	}
	/**
	 * @return true if zone has park else return false
	 */
	boolean hasPark()
	{
		return true;
	}
	/**
	 * @return true if zone has canteen else return false
	 */
	boolean hasCanteen()
	{
		return true;
	}
	/**
	 * this method add animal to cage is space is empty
	 * @param animal is object of animal class which hold the information of animal
	 * @return true is addition is successful else return false
	 */
	boolean addAnimal(Animal animal)
	{
		Cage cage =super.addAnimal(animal,totalCages,filledCages);
		if(cage==null)
		{
			return false;
		}
		else
		{
			cageAnimal.add(cage);
			filledCages++;
			return true;
		}
	}
	/**
	 * this method remove the animal after checking the details of animal 
	 * @param cageNumber number of cage where the animal is dead 
	 * @animalName name of animal who is dead
	 */
	boolean deathOfAnimal(int cageNumber,String animalName)
	{
		boolean result = super.deathOfAnimal(cageNumber,animalName,filledCages,cageAnimal);	
		if(result==true)
		{
			filledCages--;
		}
		return result;
	}
	/**
	 * increase the number of cage by 1
	 */
	void addCage()
	{
		totalCages++;
	}
	/**
	 * show all details of animal by calling parent class method
	 */
	void showDetails()
	{
		super.showDetail(cageAnimal);
	}
}
class EastZone extends Zone
{
	ArrayList<Cage> cageAnimal=new ArrayList<Cage>();
	private int totalCages=3;
	private int filledCages=0;
	/**
	 * @return number of Total cages
	 */
	int numberOfTotalCages()
	{
		return totalCages;
	}
	/**
	 * @return number of  filled cages
	 */
	int numberOfFilledCages()
	{
		return filledCages;
	}
	/**
	 * @return true if zone has park else return false
	 */
	boolean hasPark()
	{
		return true;
	}
	/**
	 * @return true if zone has canteen else return false
	 */
	boolean hasCanteen()
	{
		return false;
	}
	/**
	 * this method add animal to cage is space is empty
	 * @param animal is object of animal class which hold the information of animal
	 * @return true is addition is successful else return false
	 */
	boolean addAnimal(Animal animal)
	{
		Cage cage =super.addAnimal(animal,totalCages,filledCages);
		if(cage==null)
		{
			return false;
		}
		else
		{
			cageAnimal.add(cage);
			filledCages++;
			return true;
		}
	}
	/**
	 * this method remove the animal after checking the details of animal 
	 * @param cageNumber number of cage where the animal is dead 
	 * @animalName name of animal who is dead
	 */
	boolean deathOfAnimal(int cageNumber,String animalName)
	{
		boolean result=super.deathOfAnimal(cageNumber,animalName,filledCages,cageAnimal);	
		if(result==true)
		{
			filledCages--;
		}
		return result;
	}
	/**
	 * increase the number of cage by 1
	 */
	void addCage()
	{
		totalCages++;
	}
	/**
	 * show all details of animal by calling parent class method
	 */
	void showDetails()
	{
		super.showDetail(cageAnimal);
	}
}
class WestZone extends Zone
{
	ArrayList<Cage> cageAnimal=new ArrayList<Cage>();
	private int totalCages=3;
	private int filledCages=0;
	/**
	 * @return number of Total cages
	 */
	int numberOfTotalCages()
	{
		return totalCages;
	}
	/**
	 * @return number of  filled cages
	 */
	int numberOfFilledCages()
	{
		return filledCages;
	}
	/**
	 * @return true if zone has park else return false
	 */
	boolean hasPark()
	{
		return false;
	}
	/**
	 * @return true if zone has canteen else return false
	 */
	boolean hasCanteen()
	{
		return true;
	}
	/**
	 * this method add animal to cage is space is empty
	 * @param animal is object of animal class which hold the information of animal
	 * @return true is addition is successful else return false
	 */
	boolean addAnimal(Animal animal)
	{
		Cage cage =super.addAnimal(animal,totalCages,filledCages);
		if(cage==null)
		{
			return false;
		}
		else
		{
			cageAnimal.add(cage);
			filledCages++;
			return true;
		}
	}
	/**
	 * this method remove the animal after checking the details of animal 
	 * @param cageNumber number of cage where the animal is dead 
	 * @animalName name of animal who is dead
	 */
	boolean deathOfAnimal(int cageNumber,String animalName)
	{
		boolean result=super.deathOfAnimal(cageNumber,animalName,filledCages,cageAnimal);	
		if(result==true)
		{
			filledCages--;
		}
		return result;
	}
	/**
	 * increase the number of cage by 1
	 */
	void addCage()
	{
		totalCages++;
	}
	/**
	 * show all details of animal by calling parent class method
	 */
	void showDetails()
	{
		super.showDetail(cageAnimal);
	}
}
class Cage
{
	int capacity=1;
	ArrayList<Animal> animalDetails=new ArrayList<Animal>();
	/**
	 * @return the filled sheets by animals of cages
	 */
	public int filledCapacity()
	{
		return animalDetails.size();
	}
	/**
	 * @param animal accept the object of animal class as parameter to store and access the values of animals
	 * @return true is operation of adding animal in cage is successful else returns false
	 */
	public boolean addAnimal(Animal animal)
	{
		if(animalDetails.size()>=capacity)
		{
			return false;
		}
		else
		{	
			animalDetails.add(animal);
			return true;
		}
	}
	/**
	 * @param animalName is name of animal in cage to search and remove
	 * @return true is operation of removing animal in cage is successful else returns false
	 */
	public int deathOfAnimal(String animalName)
	{
		if(animalDetails.size()<=0)
		{
			return -1;
		}
		else
		{	
			if(animalDetails.size()==1)
			{
			animalDetails.remove(0);
			return 1;
			}
			else
			{
				int find=-1;
				for(int i=0;i<animalDetails.size();i++)
				{
					if(animalDetails.get(0).getName().equalsIgnoreCase(animalName))
					{
						find=2;
						animalDetails.remove(i);
						break;
					}
				}
				return find;
			}
		}
	}
}
