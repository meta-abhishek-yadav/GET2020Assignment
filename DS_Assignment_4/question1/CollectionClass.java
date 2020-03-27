package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * this class create collection of employees and sort them
 * @author Abhishek
 *
 */
public class CollectionClass {

	ArrayList<Employee> employees=new ArrayList<Employee>();
	ArrayList<Employee> emp=new ArrayList<Employee>();

	/**
	 * this method create list of employees
	 */
	public void createList() 
	{
		Employee emp1=new Employee("A",12,"kdjkejfkr3");
		Employee emp2=new Employee("B",22,"kdjkejfkr3");
		Employee emp3=new Employee("C",2,"d e");
		Employee emp4=new Employee("D",5,"mdmel");
		Employee emp5=new Employee("E",52,"ldkeo");
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
	}
	
	/**
	 * this method add new employee to list but without duplicate employee id
	 */
	public void avoidDuplicateAdd()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("enter employee Name");
		String name=sc.nextLine();
		System.out.println("enter employee Address");
		String address=sc.nextLine();
		int find=0;
		for(int i=0;i<employees.size();i++)
		{
			if(employees.get(i).getId()==id)
			{
				find=1;
				break;
			}
		}
		if(find==0)
		{
			employees.add(new Employee(name,id,address));
			System.out.println("employee added successfully");
			System.out.println("Employees list is as");
			this.printEmployee();
		}
		else
		{
			System.out.println("employee already exist");
			this.avoidDuplicateAdd();

		}
		
	}
	/**
	 * this method print the list of employees list with their details
	 */
	public void printEmployee()
	{
		System.out.println("name          id          address");
		for(int i=0;i<employees.size();i++)
		{
			System.out.println(employees.get(i).getName()+"        "+employees.get(i).getId()+"              "+employees.get(i).getAddress());	
		}
	}
	public static void main(String args[])
	{
		CollectionClass collectionClass=new CollectionClass();
		collectionClass.createList();
		Collections.sort(collectionClass.employees,new SortById());
		collectionClass.printEmployee();
		Collections.sort(collectionClass.employees,new SortByName());
		collectionClass.printEmployee();
		collectionClass.avoidDuplicateAdd();
	}
}
