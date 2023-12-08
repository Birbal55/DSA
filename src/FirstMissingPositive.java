
public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] arr = {1,2,0};
		System.out.println(firstMissingPositive(arr));
	}
	
	public static int firstMissingPositive(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			int correct = arr[i] - 1;
			if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
				swap(arr, i ,correct);
			}else {
				i++;
			}
		}
		//search for first missing number
		for(int idx = 0; idx < arr.length; idx++) {
			if(arr[idx] != idx + 1) {
				return idx + 1;
			}
		}
		return arr.length+1;
	}


	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	

}
