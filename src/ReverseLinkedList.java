

public class ReverseLinkedList 
{
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

	//method for reverse the LinkedList
	public ListNode reverse(ListNode head)
	{
		if(head == null)
		{
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current != null)
		{
			next = current.next;
			current.next = previous;
			current = next;
		}
		return previous;
	}
	
	//method for display
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
	
	public static void main(String[] args) 
	{
		ReverseLinkedList sll = new ReverseLinkedList();
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
		//Attach them together to form s list
		head.next = second; //10 --> 1
		second.next = third; //10 --> 1 --> 8
		third.next = fourth; //10 --> 1 --> 8 --> 11 --> null
		
		
		
		ListNode reverseListHead = sll.reverse(head);
		sll.reverse(reverseListHead);
		sll.display();


		

	}

}
