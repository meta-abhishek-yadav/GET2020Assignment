package question1;

import java.util.Comparator;
/**
 * this class sort employees by their name using comparator interface in ascending order
 */
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareTo(employee2.getName());
	}

}
