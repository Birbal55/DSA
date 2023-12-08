package Oops;

import java.util.Arrays;

public class InnerClass {
	static class Test{
		String name;
		
		public Test(String name) {
			this.name = name;
		}
		//@override
		public String toString() {
			return name;
		}
	
	}

	public static void main(String[] args) {
		Test a = new Test("Birbal");
		Test b = new Test("Rahul");
		
		System.out.println(a.name);
		System.out.println(b.name);
	}

}

//static class A{
//
//}
