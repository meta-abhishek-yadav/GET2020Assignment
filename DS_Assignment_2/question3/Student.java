package question3;
/**
 *  student class that hold data of student 
 * @author Abhishek
 *
 */
public class Student {

	private String name;
	private String programs[]=new String[5];
	String programAlloted="";
	public Student(String name,String []programs)
	{
		this.name=name;
		this.programs=programs;
	}
	public String getName()
	{
		return name;
	}
	public String[] getPrograms()
	{
		return programs;
	}
	
}
