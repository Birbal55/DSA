package StringStringBuilder;

import java.util.Arrays;

public class GCD_LCM {

	public static void main(String[] args) {
		int[] arr = {20,6,8,12,4};
		System.out.println(gcd(4,8));
		System.out.println(lcm(9,18));
		System.out.println(goodPair3(arr));
	}
	static int gcd(int a, int b) {
		if(a == 0) {
			return b;
		}
		return gcd(a%b,a);
	}
	static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	//for array
	static int goodPair(int[] nums) {
		int count = 0;
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length;j++) {
				if(nums[i] == nums[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	//another way 
	static int goodPair2(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		int i = 0;
		for(int j=1;j<nums.length;j++) {
			if(nums[j]==nums[i]) {
				count++;
			}else {
				i=j;
			}
		}
		return count;
	}
	//another way
	static int goodPair3(int[] nums) {
		int count=0;
		int[] freq=new int[101];
		for(int num:nums) {
			count+=freq[num]++;
		}
		return count;
	}

}
