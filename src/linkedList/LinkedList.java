package linkedList;

import org.w3c.dom.Node;

import linkedList.LinkedListCycle.ListNode;

public class LinkedList {
	
	private Node head;
	private Node tail;//benefit of this extra variable we can do it in constant time
	private int size;
	
	public LinkedList() {
		this.size = 0;
	}
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		
		if(tail == null) {
			tail = head;
		}
		
		size += 1;
	}
	
	public void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	
	//insert at given index
	public void insert(int val,int index) {
		if(index == 0) {
			insertFirst(val);
			return;
		}
		if(index == size) {
			insertLast(val);
			return;
		}
		
		Node temp = head;
		for(int i = 1; i < index; i++) {
			temp = temp.next;
		}
		
		Node node = new Node(val,temp.next);
		temp.next = node;
		size++;
	}
	
	
	//insert using recursion
	public void insertRec(int val,int index) {
		head = insertRec(val,index,head);
	}
	private Node insertRec(int val, int index,Node node) {
		if(index == 0) {
			Node temp = new Node(val,node);
			size++;
			return temp;
		}
		node.next = insertRec(val,index--,node.next);
		return node;
	}
	
	
	public int deleteFirst() {
		int val = head.value;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		size--;
		return val;
	}
	
	public int deleteLast() {
		if(size <= 1) {
			return deleteFirst();
		}
		Node secondLast = get(size - 2);
		int val = tail.value;
		tail = secondLast;
		tail.next = null;
		return val;
	}
	
	//it will return reference point of the given index
	public Node get(int index) {
		Node node = head;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	//it will return node of given value
		public Node find(int value) {
			Node node = head;
			while(node != null) {
				if(node.value == value) {
					return node;
				}
				node = node.next;
			}
			return null;
		}
	
	public int delete(int index) {
		if(index == 0) {
			return deleteFirst();
		}
		if(index == size - 1) {
			return deleteLast();
		}
		
		Node prev = get(index - 1);
		int val = prev.next.value;
		prev.next = prev.next.next;
		return val;
	}
	
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}
	
	private class Node{
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node(int value,Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	//questions remove duplicates from linkedlist
	public void duplicates() {
		Node node = head;
		while(node.next != null) {
			if(node.value == node.next.value) {
				node.next = node.next.next;
				size--;
			}else {
				node = node.next;
			}
		}
		tail = node;
		tail.next = null;
	}
	
	//merge two sorted linkedlist
	public static LinkedList merge(LinkedList first,LinkedList second) {
		Node f = first.head;
		Node s = second.head;
		
		LinkedList ans = new LinkedList();
		while(f != null && s != null) {
			if(f.value < s.value) {
				ans.insertLast(f.value);
				f =f.next;
			}else {
				ans.insertLast(s.value);
				s = s.next;
			}
		}
		while(f != null) {
			ans.insertLast(f.value);
			f = f.next;
		}
		while(s != null) {
			ans.insertLast(s.value);
			s = s.next;
		}
		return ans;
	}
	
	//bubble sort on linkedlist
	public void bubbleSort() {
		bubbleSort(size - 1,0);
	}
	
	private void bubbleSort(int row,int col) {
		if(row == 0) {
			return;
		}
		
		if(col < row) {
			Node first = get(col);
			Node second = get(col + 1);
			
			if(first.value > second.value) {
				//swap
				if(first == head) {
					head = second;
					first.next = second.next;
					second.next = first;
				}else if(second == tail) {
					Node prev = get(col - 1);
					prev.next = second;
					tail = first;
					first.next = null;
					second.next = tail;
				}else {
					Node prev = get(col-1);
					prev.next = second;
					first.next = second.next;
					second.next = first;
				}
			}
			bubbleSort(row,col + 1);
		}else {
			bubbleSort(row - 1,0);
		}
	}
	
	//recursion reverse
	private void reverse(Node node) {
		if(node == tail) {
			head = tail;
			return;
		}
		reverse(node.next);
		tail.next = node;
		tail = node;
		tail.next = null;
	}
	
	//in place reversal of Linked List
	//google,microsoft,apple,amazon
	public void reverse() {
		if(size < 2) {
			return;
		}
		Node prev = null;
		Node present = head;
		Node next = present.next;
		
		while(present != null) {
			present.next = prev;
			prev = present;
			present = next;
			if(next != null) {
				next = next.next;
			}
		}
		head = prev;
	}
	
	//reverselist
	public ListNode reverseList(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode prev = null;
		ListNode present = head;
		ListNode next = present.next;
		
		while(present != null) {
			present.next = prev;
			prev = present;
			present = next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}
	//Google,Microsoft,Facebook
	public ListNode reverseBetween(ListNode head,int left,int right) {
		if(left == right) {
			return head;
		}
		//skip the first left-1 nodes
		ListNode current = head;
		ListNode prev = null;
		for(int i = 0; current != null && i < left - 1;i++) {
			prev = current;
			current = current.next;
		}
		
		ListNode last = prev;
		ListNode newEnd = current;
		
		//reverse between left and right
		ListNode next = current.next;
		for(int i = 0;current != null && i < right - left + 1; i++) {
			current.next = prev;
			prev = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
		}
		if(last != null) {
			last.next = prev;
		}else {
			head = prev;
		}
		newEnd.next = current;
		return head;
	}
	
	 //find the middle node
    public ListNode middleNode(ListNode head) {
    	ListNode s = head;
    	ListNode f = head;
    	
    	while(f != null && f.next != null) {
    		s = s.next;
    		f = f.next.next;
    	}
    	return s;
    }
	
	//palinrome of linkedlist
	//LinkedIn,Google,Facebook,Microsoft,Amazon,Apple
	public boolean isPalindrome(ListNode head) {
		ListNode mid = middleNode(head);
		ListNode headSecond = reverseList(mid);
		ListNode rereverseHead = headSecond;
		
		//compare both the halves
		while(head != null && headSecond != null) {
			if(head.val != headSecond.val) {
				break;
			}
			head = head.next;
			headSecond = headSecond.next;
		}
		reverseList(rereverseHead);
		return head == null || headSecond == null;
	}
	
	//Reorder LinkedList
	//Google,Facebook
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		ListNode mid = middleNode(head);
		ListNode hs = reverseList(mid);
		ListNode hf = head;
		
		//rearrange
		while(hf != null && hs != null) {
			ListNode temp = hf.next;
			hf.next = hs;
			hf = temp;
			
			temp = hs.next;
			hs.next = hf;
			hs = temp;
		}
		//next of tail to null
		if(hf != null) {
			hf.next = null;
		}
	}
	
	//google,amazon,facebook,microsoft
	//it also reversing the < k end items -> modify it accordingly
	//0(n)
	public ListNode reverseKGroup(ListNode head,int k) {
		if(k <= 1 || head == null) {
			return head;
		}
		//skip the first left-1 nodes
		ListNode current = head;
		ListNode prev = null;
		while(true) {
			ListNode last = prev;
			ListNode newEnd = current;
			
			//reverse between left and right
			ListNode next = current.next;
			for(int i = 0;current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if(next != null) {
					next = next.next;
				}
			}
			if(last != null) {
				last.next = prev;
			}else {
				head = prev;
			}
			newEnd.next = current;
			if(current == null) {
				break;
			}
			prev = newEnd;
		}
		return head;
	}
	
	public ListNode reverseAlternateKGroup(ListNode head,int k) {
		if(k <= 1 || head == null) {
			return head;
		}
		//skip the first left-1 nodes
		ListNode current = head;
		ListNode prev = null;
		while(current != null) {
			ListNode last = prev;
			ListNode newEnd = current;
			
			//reverse between left and right
			ListNode next = current.next;
			for(int i = 0;current != null && i < k; i++) {
				current.next = prev;
				prev = current;
				current = next;
				if(next != null) {
					next = next.next;
				}
			}
			if(last != null) {
				last.next = prev;
			}else {
				head = prev;
			}
			newEnd.next = current;
			//skip the k nodes
			for(int i = 0; current != null && i < k; i++) {
				prev = current;
				current = current.next;
			}
		}
		return head;
	}
	
	//Facebook,Twitter,Google
	public ListNode rotateRight(ListNode head,int k) {
		if(k <= 0 || head == null || head.next == null) {
			return head;
		}
		ListNode last = head;
		int length = 1;
		while(last.next != null) {
			last = last.next;
			length++;
		}
		last.next = head;
		int rotations = k % length;
		int skip = length - rotations;
		ListNode newLast = head;
		for(int i = 0; i < skip - 1; i++) {
			newLast = newLast.next;
		}
		head = newLast.next;
		newLast.next = null;
		
		return head;
	}

	public static void main(String[] args) {
		//LinkedList ll = new LinkedList();
		//ll.insertFirst(3);
		//ll.insertFirst(3);
		//ll.insertFirst(3);
		//ll.insertFirst(2);
		//ll.insertFirst(8);
		//ll.insertFirst(17);
		//ll.insertLast(99);
		//ll.insert(100, 3);
		//System.out.println(ll.deleteFirst());
		//ll.display();
		//System.out.println(ll.deleteLast());
		//ll.display();
		//System.out.println(ll.delete(2));
		//ll.display();
		//ll.insertRec(88,2);
		//ll.display();
		//ll.duplicates();
		//ll.display();
		
		//for merge sort 
		LinkedList first = new LinkedList();
		LinkedList second = new LinkedList();
		first.insertLast(1);
		first.insertLast(3);
		first.insertLast(5);
		
		second.insertLast(1);
		second.insertLast(2);
		second.insertLast(9);
		second.insertLast(14);
		
		LinkedList ans = LinkedList.merge(first, second);
		ans.display();
		
		LinkedList list = new LinkedList();
		for(int i = 7; i > 0; i--) {
			list.insertLast(i);
		}
		list.display();
		list.bubbleSort();
		list.display();
		
	}

}
