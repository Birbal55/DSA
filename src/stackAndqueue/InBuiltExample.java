package stackAndqueue;

import java.util.*;
import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class InBuiltExample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(45);
		stack.push(2);
		stack.push(9);
		stack.push(18);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(3);
		queue.add(5);
		queue.add(7);
		queue.add(19);
		queue.add(1);
		
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(89);
		deque.addLast(78);
		deque.removeFirst();
		//etc etc
	}

}
