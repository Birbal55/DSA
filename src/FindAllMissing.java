import java.util.List;
import java.util.ArrayList;

public class FindAllMissing {

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,2};
		System.out.println(findDisappearedNumber(arr));
	}
	public static List<Integer> findDisappearedNumber(int[] arr) {
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
				ans.add(idx + 1);
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
