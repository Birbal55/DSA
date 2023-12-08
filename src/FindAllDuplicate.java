import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1,1};
		System.out.println(findAllDuplicate(arr));
	}
	
	public static List<Integer> findAllDuplicate(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			int correct = arr[i] - 1;
			if(arr[i] != arr[correct]) {
				swap(arr, i ,correct);
			}else {
				i++;
			}
		}
		//just find missing numbers
		List<Integer> ans = new ArrayList<>();
		for(int idx = 0; idx < arr.length; idx++) {
			if(arr[idx] != idx+1) {
				ans.add(arr[idx]);
			}
		}
		return ans;
	}
	static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}


}
