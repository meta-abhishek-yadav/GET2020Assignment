package question1;

import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map.Entry;

public class Dictionary {
	Element head;
	/**
	 * Constructor that makes initial entries to dictionary
	 */
	public Dictionary()
	{
		head=new Element(15,13);
	}
	/**
	 * 
	 * @param baseElement the base pointer of element
	 * @param newElement the object of new element
	 * @return the baseElement address after adding the element
	 */
	public Element addElement(Element baseElement,Element newElement)
	{
		if(baseElement==null)
		{
			return newElement;
		}
		else
		{
			if(baseElement.getKey()<=newElement.getKey())
			{
				baseElement.rightElement=this.addElement(baseElement.rightElement,newElement);
			}
			else
			{
				baseElement.leftElement=this.addElement(baseElement.leftElement, newElement);
			}
		}
		return baseElement;
	}
	/**
	 * 
	 * @param head the head of the binary search tree
	 * @param sortedlist the initial sorted list of elements
	 * @param rangeStart the starting index of range of keys
	 * @param rangeEnd the ending index of range of keys
	 * @return  the dictionary in sorted manner
	 */
	public TreeMap<Integer,Integer> getSortedKeyValuePairsBetweenRange(Element head,TreeMap<Integer,Integer> sortedlist,int rangeStart,int rangeEnd)
	{

		if(head==null)
		{
			return sortedlist;
		}
		else
		{
			if(head.getKey()>=rangeStart)
			{
				this.getSortedKeyValuePairsBetweenRange(head.leftElement, sortedlist,rangeStart,rangeEnd);
			}
			if(head.getKey()>=rangeStart && head.getKey()<= rangeEnd)
			{
				sortedlist.put(head.getKey(), head.getValue());
			}
			 if(head.getKey()<=rangeEnd)
			{
				this.getSortedKeyValuePairsBetweenRange(head.rightElement, sortedlist,rangeStart,rangeEnd);
			}
			
		}
		return sortedlist;
	}
	/**
	 * 
	 * @param head the base pointer of the binary search tree
	 * @param sortedlist the initial sorted dictionary 
	 * @return the sorted dictionary of elements
	 */
	public TreeMap<Integer,Integer> getSortedKeyValuePairs(Element head,TreeMap<Integer,Integer> sortedlist)
	{

		if(head==null)
		{
		 return sortedlist;
		}
		else
		{
			sortedlist=this.getSortedKeyValuePairs(head.leftElement,sortedlist);
			sortedlist.put(head.getKey(), head.getValue());
			sortedlist=this.getSortedKeyValuePairs(head.rightElement, sortedlist);
		}
		
		return sortedlist;
	}
	public int getValueOfKey(int key,Element head)
	{
		if(head==null)
		{
			return -1;
		}
		else if(head.getKey()==key)
		{
			return head.getValue();
		}
		else
		{
			if(head.getKey()>key)
			{
				return this.getValueOfKey(key, head.leftElement);
			}
			else
			{
				return this.getValueOfKey(key, head.rightElement);
			}
		}
	}
	/**
	 * this method method the right most element of given head element 
	 * @param head the base element of the binary search tree
	 * @return the element of right most
	 */
	public Element findRightMostChild(Element head)
	{
		if(head.rightElement.rightElement==null)
		{
			head.rightElement.leftElement=null;
			Element element=head.rightElement;
			head.rightElement=null;
			return element;
		}
		else
		{
			return this.findRightMostChild(head.rightElement);
		}
	}
	/**
	 * this method method the left most element of given head element 
	 * @param head the base element of the binary search tree
	 * @return the element of left most
	 */
	public Element findLeftMostChild(Element head)
	{
		if(head.leftElement.leftElement==null)
		{
			head.leftElement.rightElement=null;
			Element element=head.leftElement;
			head.leftElement=null;
			return element;
		}
		else
		{
			return this.findLeftMostChild(head.rightElement);
		}
	}
	/**
	 * this method delete the element according given key
	 * @param key the key to delete the element
	 * @param head the base element of binary search tree
	 * @return the new node in place of deleted node element
	 */
	public Element delete(int key,Element head)
	{
		Element returnElement=head;
		if(head==null)
		{
			System.out.println("key not found");
			returnElement= null;
		}
		else if(head.getKey()==key)
		{
			if(head.leftElement==null && head.rightElement==null)
			{
				returnElement= null;
			}
			else if(head.leftElement==null && head.rightElement!=null)
			{
				if(head.rightElement.leftElement==null)
				{
					returnElement=head.rightElement;
				}
				else
				{
					returnElement= this.findLeftMostChild(head.rightElement);
					returnElement.rightElement=head.rightElement;
				}
				
			}
			else if(head.leftElement!=null && head.rightElement==null)
			{
				if(head.leftElement.rightElement==null)
				{
					returnElement=head.leftElement;
				}
				else
				{
					returnElement= this.findRightMostChild(head.leftElement);
					returnElement.leftElement=head.leftElement;
				}
			}
			else if(head.leftElement!=null && head.rightElement!=null)
			{
				if(head.leftElement.rightElement==null)
				{
					returnElement=head.leftElement;
					System.out.println("hiiiii "+returnElement.getKey()+"  "+returnElement.leftElement.getKey());
				}
				else
				{	
					returnElement= this.findRightMostChild(head.leftElement);
					returnElement.leftElement=head.leftElement;		
					returnElement.rightElement=head.rightElement;
				}
				if(head==this.head)
				{
					this.head=returnElement;
				}
			}
		}
		else
		{
			if(head.getKey()>key)
			{
				 head.leftElement=this.delete(key, head.leftElement);
			}
			else
			{
				head.rightElement=this.delete(key, head.rightElement);
			}
		}
		return returnElement;
	}
	/**
	 * this method add list of elements of key pair to binary search tree
	 * @param listOfElement the key pair binary search tree
	 */
	public void add(HashMap<Integer,Integer> listOfElement)
	{
		
		for(Entry<Integer,Integer> entry:listOfElement.entrySet())
		{
			this.addElement(head, new Element(entry.getKey(),entry.getValue()));	
		}
	}
	/**
	 * the method print the binary search tree in in order 
	 * @param head the base element of the binary serach tree
	 */
	public void printDictionary(Element head)
	{
		if(head==null)
		{
		 return ;
		}
		else
		{
			this.printDictionary(head.leftElement);
			System.out.println(head.getKey()+ "  "+head.getValue());
			this.printDictionary(head.rightElement);
			return ;
		}
		
	}
	public static void main(String[] args) {
		Dictionary dictionary=new Dictionary();
		HashMap<Integer,Integer> listOfElements=new HashMap<Integer,Integer>();
		listOfElements.put(20,122);
		listOfElements.put(25,122);
		listOfElements.put(39,2);
		listOfElements.put(11,32);
		listOfElements.put(18,9);
		listOfElements.put(1,221);
		listOfElements.put(22,22);
		dictionary.add(listOfElements);
		dictionary.printDictionary(dictionary.head);
		System.out.println(dictionary.head.getKey()+" "+dictionary.head.leftElement.getKey());
		int value=dictionary.getValueOfKey(11,dictionary.head);
		if(value==-1)
		{
			System.out.println("key not found ");
		}
		else
		{
			System.out.println("value  of key 11 is = "+  value);
		}
		System.out.println(dictionary.head.getKey()+" "+dictionary.head.leftElement.getKey()+" "+dictionary.head.rightElement.getKey());

		dictionary.delete(15,dictionary.head);
		dictionary.printDictionary(dictionary.head);
		TreeMap<Integer,Integer> sortedlist=new TreeMap<Integer,Integer>();
		sortedlist=dictionary.getSortedKeyValuePairs(dictionary.head,sortedlist);
		System.out.println("Dictionary after sorting ");
		System.out.println("key    value");
		for(Entry<Integer,Integer> entry:sortedlist.entrySet())
		{
			System.out.println(entry.getKey()+"      "+entry.getValue());
		}
		sortedlist=new TreeMap<Integer,Integer>();
		sortedlist=dictionary.getSortedKeyValuePairsBetweenRange(dictionary.head,sortedlist,1,20);
		System.out.println("Dictionary after sorting between range 1 to 20 ");
		System.out.println("key    value");
		for(Entry<Integer,Integer> entry1:sortedlist.entrySet())
		{
			System.out.println(entry1.getKey()+"      "+entry1.getValue());
		}
	}

}
