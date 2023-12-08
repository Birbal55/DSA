
public class SinglyLinkedList {
	
	private ListNode head;
	
	//create a node
	private static class ListNode
	{
		private int data; //can be a generic type
		private ListNode next; //Reference to next ListNode in list
		
		public ListNode(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	//to display
	public void display()
	{
		ListNode current = head;
		while(current != null)
		{
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	//check length
	public int length()
	{
		if(head==null)
		{
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while(current != null)
		{
			count++;
			current = current.next;
		}
		return count;
			
	}
	//insert at beginning
	public void insertAtBeg(int value)
	{
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	//insert at specific position
	public void insert(int position,int value)
	{
		// 1 --> 4 --> 5
		// 1--> 6 --> 4 --> 5 
		ListNode node = new ListNode(value);
		
		if(position == 1)
		{
			node.next = head;
			head = node;
		}
		else
		{
			ListNode previous = head;
			int count = 1;//position = 1
			
			while(count < position - 1)
			{
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}
	}
	//insert at ending
	public void insertAtEnd(int value)
	{
		ListNode newNode = new ListNode(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		ListNode current = head;
		while(null != current.next)
		{
			current = current.next;
		}
		current.next = newNode;
	}
	//method for deleting node at first position
	public ListNode deleteFirst()
	{
		if(head == null)
		{
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	//method for deleting node at last position
	public ListNode deleteLast()
	{
		if(head == null || head.next == null)
		{
			return null;
		}
		ListNode current = head;
		ListNode previous = null;
		
		while(current.next != null)
		{
			previous = current;
			current = current.next;
		}
		previous.next = null; // break the chain
		return current;
	}
	//method for deleting node at specific position
	public void delete(int position)
	{
		//position is valid and starting from 1
		// 3 -> 4 -> 7 -> 8 -> 9 -> null
		if(position == 1)
		{
			head = head.next;
		}
		else
		{
			ListNode previous = head;
			int count = 1;
			while(count < position-1)
			{
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
	}
	//method for search
	public static boolean find(ListNode head,int searchKey)
	{
		if(head == null)
		{
			return false;
		}
		ListNode current = head;
		while(current != null)
		{
			if(current.data == searchKey)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		
		sll.head.next = second; //10 --> 1
		second.next = third; //10 --> 1 --> 8
		third.next = fourth; //10 --> 1 --> 8 --> 11 --> null
		
		//SinglyLinkedList sll = new SinglyLinkedList();
		//sll.display(head);
		//if(sll.find(head, 1))
		{
			System.out.println("Search key found ");
		}
		//else
		{
			System.out.println("Search key not found ");
		}
		
		//Now we will connect them together to form a chain
		//sll.head.next = second; //10 --> 1
		//second.next = third; //10 --> 1 --> 8
		//third.next = fourth; //10 --> 1 --> 8 --> 11 --> null
		
		//sll.insertAtBeg(11);
		//sll.insertAtBeg(8);
		//sll.insertAtBeg(1);
		
		/*sll.insertAtEnd(11);
		sll.insertAtEnd(8);
		sll.insertAtEnd(1);
		sll.insertAtEnd(10);
        sll.display();*/
        //System.out.println("Length is = "+sll.length());
		//sll.insert( 1, 3); // 3 -> null
		//sll.insert( 2, 5); // 3 -> 5 -> null
		//sll.insert( 1, 2); // 2 -> 3 -> 5 -> null
		//sll.insert( 2, 4); // 2 -> 4 -> 3 -> 5 -> null
		//sll.insert( 5, 7); // 2 -> 4 -> 3 -> 5 -> 7 -> null
		//sll.display();
       // System.out.println(sll.deleteFirst().data);
       // System.out.println(sll.deleteFirst().data);
        //System.out.println(sll.deleteLast().data);
        //System.out.println(sll.deleteLast().data);
        //sll.display();

        //sll.delete(1);//8 --> 1 --> 10 --> null
        //sll.delete(2);//8 --> 10 -->null
      //  sll.delete(2);//8 --> null
       // sll.display();
	}

}
