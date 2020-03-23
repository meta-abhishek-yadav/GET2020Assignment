import java.util.Scanner;
/**
 * 
 * @author Abhishek
 * this class rotate the linked list according the provided left index and right index according provided number 
 */
public class LinkedListRotation {
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
	/**
	 * 
	 * @param head the starting node of linked list
	 * @param L left index to find the node at that index
	 * @return the node find at index L
	 */
	public Node leftNode(Node head,int L)
	{
		Node tempNode=head;
		int index=1;
		while(index<L-1)
		{
			tempNode=tempNode.next;
			index++;
		}
		return tempNode;
	}
	/**
	 * @param head the starting node of the linked list
	 * @param R the right index of the linked list to find the node
	 * @return the node at the index R in the linked list
	 */
	public Node rightNode(Node head,int R)
	{
		Node tempNode=head;
		int index=1;
		while(index<R)
		{
			tempNode=tempNode.next;
			index++;
		}
		return tempNode;
	}
	/**
	 * 
	 * @param leftnode the address of left node of the linked list
	 * @param rightNode the address right node of linked list 
	 * @param index from where the linked list will be rearranged after rotation
	 * @return the starting node of linked after roatation
	 */
	public Node Rotate(Node leftnode,Node rightNode,int index)
	{ 
		System.out.println();
		if(index==0)
		{
			rightNode.next=null;
			return leftnode;
		}
		else {
		Node tempNode=leftnode;
		Node anotherTempNode=leftnode;
		for(int i=1;i<=index;i++)
		{
			anotherTempNode=tempNode;
			tempNode=tempNode.next;
		}
		anotherTempNode.next=null;	
		rightNode.next=leftnode;
		return tempNode;
		}
	}
	/**
	 * the method rotate the list according to their left index and right index with number of Rotations 
	 * @param head the starting node of the linked list
	 * @param L the left index to extract the new linked list
	 * @param R the right side index to extract the new linked list
	 * @param N number of rotations 
	 * @return the starting node of linked list after the roatation
	 */
	public Node RotateList(Node head,int L,int R,int N)
	{
		if(N>0)
		{
		Node leftNode=null;
		if(L==1)
		{
			leftNode=head;
		}
		else if(L>1) {
			leftNode=this.leftNode(head,L);
		}
		Node rightNode=this.rightNode(head,R);
		Node rightnode=rightNode.next;
		int index=(R-L+1-N);
		if((R-L+1)<N)
		{
			index=N%(R-L+1);
			if(index!=0)
			{
				index=(R-L+1-index);
			}
		}
		if(L==1)
		{
			head=this.Rotate(leftNode,rightNode,index);
			leftNode=head;
		}
		else
		{
			leftNode.next=this.Rotate(leftNode.next, rightNode,index);
		}
		Node tempNode=leftNode;
		while(tempNode.next!=null)
		{
			tempNode=tempNode.next;
		}
		tempNode.next=rightnode;
		}
		return head;
	}
	/**
	 * this method print the linked list
	 * @param head the starting node of the linked list
	 */
	public void printList(Node head)
	{
		Node tempNode=head;
		while(tempNode!=null)
		{
			System.out.print(tempNode.data);
			if(tempNode.next!=null)
			{
				System.out.print("->");
			}
			tempNode=tempNode.next;
		}
		System.out.println();
			}
	public static void main(String[] args) {
		LinkedListRotation linkedListRotation=new LinkedListRotation();
		Node head=null;
		head=linkedListRotation.createList();
		int L,R,N;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Left index to rotate");
		L=sc.nextInt();
		System.out.println("Enter the right index to rotate");
		R=sc.nextInt();
		System.out.println("Enter the number of rotations");
		N=sc.nextInt();
		System.out.println("list Before Rotation");
		linkedListRotation.printList(head);
		head=linkedListRotation.RotateList(head, L, R, N);
		System.out.println("list after Rotation");
		linkedListRotation.printList(head);

	}


}
/**
 *this class define the property of a node and set data value using the constructor
 *
 */
class Node
{
	int data;
	public Node next;
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}