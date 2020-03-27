package question2;

public class EmployeeLinkedList {
	Employee head;
	public EmployeeLinkedList()
	{
		head=new Employee("A",32000,17);
		Employee employee=new Employee("B",22003,23);
		head.next=employee;
		employee.next=new Employee("C",2000,67);
		employee=employee.next;
		employee.next=new Employee("D",32000,15);
		employee=employee.next;
		employee.next=new Employee("E",20900,25);
		employee=employee.next;
	}
	public int compareEmployees(Employee employee1,Employee employee2)
	{
		if(employee1.getSalary()>employee2.getSalary())
		{
			return 1;
		}
		else if(employee1.getSalary()<employee2.getSalary())
		{
			return -1;
		}
		else
		{
			if(employee1.getAge()>employee2.getAge())
			{
				return -1;
			}
			else if(employee1.getAge()<employee2.getAge())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	public void swapData(Employee employee1,Employee employee2)
	{
		String name=employee1.getName();
		int salary=employee1.getSalary();
		int age=employee1.getAge();
		employee1.setName(employee2.getName());
		employee1.setSalary(employee2.getSalary());
		employee1.setAge(employee2.getAge());
		employee2.setName(name);
		employee2.setSalary(salary);
		employee2.setAge(age);

	}
	public void sortEmployeesLinkedList()
	{
		Employee employee=head;
		Employee temporary;
		Employee maximumSalaryEmployee;
		while(employee.next!=null)
		{
			maximumSalaryEmployee=employee;
			temporary=employee.next;
			while(temporary!=null)
			{
				if(this.compareEmployees(temporary,maximumSalaryEmployee)>0)
				{
					maximumSalaryEmployee=temporary;
				}
				temporary=temporary.next;
			}
			this.swapData(maximumSalaryEmployee,employee);
			employee=employee.next;
		}
			
		
	}
	public void printEmployeesLinkedList()
	{
		Employee employee=head;
		System.out.println("List of employees is as");
		System.out.println("name   salary   Age");

		while(employee!=null)
		{
			System.out.println(employee.getName()+"      "+employee.getSalary()+"    "+employee.getAge());
			employee=employee.next;
		}
	}
	public static void main(String []args)
	{
		EmployeeLinkedList employeeLinkedList=new EmployeeLinkedList();
		employeeLinkedList.printEmployeesLinkedList();
		employeeLinkedList.sortEmployeesLinkedList();
		employeeLinkedList.printEmployeesLinkedList();
		
	}
}
