package StringStringBuilder;

public class FindUnique {

	public static void main(String[] args) {
		int[] arr = {2,1,4,5,2,6,1,5,4};
		System.out.println(ans(arr));
	}
	static int ans(int[] arr) {
		int unique = 0;
		for(int n : arr) {
			unique ^= n;
		}
		return unique;
	}

}
