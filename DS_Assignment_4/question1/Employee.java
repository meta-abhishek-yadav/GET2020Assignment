package question1;

public class Employee implements Comparable {
private String name;
private int id;
private String address;
public Employee(String name,int id,String address)
{
	this.name=name;
	this.id=id;
	this.address=address;
}
public String getName()
{
	return name;
}
public String getAddress()
{
	return address;
}
public int getId()
{
	return id;
}

public int compareTo(Employee employee) {
	return this.getName().compareTo(employee.getName());
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
}
