package linkedList;

//import linkedList.LinkedListCycle.ListNode;

public class LinkedListCycle {
	//time complexity  o(n)
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	//Amazon and Microsoft
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	//find length of the cycle
	public int lengthCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				//calculate the length
				ListNode temp = slow;
				int length = 0;
				do {
					temp = temp.next;
					length++;
				}while(temp != slow);
				return length;
			}
		}
		return 0;
	}
	
	public ListNode detectCycle(ListNode head) {
		int length = 0;
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				length = lengthCycle(slow);
				break;
			}
		}
		
		if(length == 0) {
			return null;
		}
		
		//find the start node
		ListNode f = head;
		ListNode s = head;
		
		while(length > 0) {
			s = s.next;
			length--;
		}
		
		//keep moving both forward and they will meet at cycle start
		while(f != s) {
			f= f.next;
			s= s.next;
		}
		return s;
	}
	
	//Google question
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		
		do {
			slow = findSquare(slow);
			fast = findSquare(findSquare(fast));
		}while(slow != fast);
		
		if(slow == 1) {
			return true;
		}
		return false;
	}
    private int findSquare(int number) {
    	int ans = 0;
    	while(number > 0) {
    		int rem = number %10;
    		ans += rem * rem;
    		number /= 10;
    	}
    	return ans;
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

	public static void main(String[] args) {
		
	}

}
