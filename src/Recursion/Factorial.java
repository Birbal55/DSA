package Recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		//int ans = fact(5);
		//System.out.println(ans);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number for factorial:");
		int n = sc.nextInt();
		int ans = fact(n);
		System.out.println(ans);
	}
	
	//similar algorith for sum --> n+fact(n-1)
	static int fact(int n) {
		if(n <= 1) {
			return 1;
		}
		return n*fact(n-1);
	}

}
