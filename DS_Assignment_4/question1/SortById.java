package question1;

import java.util.Comparator;
/**
 * this class sort employees by their id using comparator interface in ascending order
 */
public class SortById implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getId()-employee2.getId();
	}

}