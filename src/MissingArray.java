import java.util.Arrays;

public class MissingArray {

	public static void main(String[] args) {
		int[] arr = {4,0,2,1};
		//missingNumber(arr);
		System.out.println(missingNumber(arr));
	}
	public static int missingNumber(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			int correct = arr[i];
			if(arr[i] < arr.length && arr[i] != arr[correct]) {
				swap(arr, i ,correct);
			}else {
				i++;
			}
		}
		//search for first missing number
		for(int idx = 0; idx < arr.length; idx++) {
			if(arr[idx] != idx) {
				return idx;
			}
		}
		//case 2
		return arr.length;
	}
	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

}
