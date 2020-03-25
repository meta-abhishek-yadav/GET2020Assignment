package question3;

public interface IQueue {
	int Max_Size=10;
	Boolean isFull();
	Boolean isEmpty();
	Student dequeue();
	void add(Student item);
}
