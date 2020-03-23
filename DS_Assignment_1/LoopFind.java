import java.util.ArrayList;
import java.util.Scanner;

public class LoopFind {
	/**
	 * @return the head node of linked list after creating the linked list
	 */
	public Node createList() {
		System.out.println("Enter number of elements to add in list");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Node head=null;
		Node tempNode=null;
		System.out.println("Enter "+n+" elements data to create linked list");
		for(int i=0;i<n;i++)
		{
			Node node=new Node(sc.nextInt());
			if(head==null)
			{
				head=node;
				tempNode=head;
			}
			else 
			{
				tempNode.next=node;
				tempNode=tempNode.next;
			}
		}
		return head;
	}
	public void insertLoop(Node head)
	{
		int n=3;
		Node tempNode=head.next;
		Node iterator=head;
		for(int i=1;i<=n;i++)
		{
			if(i==n)
			{
				iterator.next=tempNode;
			}
			iterator=iterator.next;
		}
	}
	/**
	 * this method check that loop exist in linked list or not
	 * @param head starting node of the linked list
	 * @return the message that loop found or not
	 */
	public String checkLoop(Node head)
	{
		String answer="no loop found";
		ArrayList<Node> list=new ArrayList<Node>();
		while(head.next!=null)
		{
			if(list.indexOf(head)!=-1)
			{
				answer="loop found in linked list";
				break;
			}
			else
			{
				list.add(head);
				head=head.next;

			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		LoopFind loopFind=new LoopFind();
		Node head=null;
		head=loopFind.createList();
		loopFind.insertLoop(head);
		System.out.println(loopFind.checkLoop(head));

	}

}

