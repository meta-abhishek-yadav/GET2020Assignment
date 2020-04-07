package question2;

public interface IPriorityQueue {
	int getHighestPriority();
	void delete();
	void insert(int data, int priority);
}
