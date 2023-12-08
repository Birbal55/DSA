
public class FirstAndLastPosition {
	public static void main(String[] args) {
     int[] nums = {5,7,7,8,8,10};
     int target = 8;
     //int ans = searchRange(nums, target);
    // System.out.println(searchRange(nums, target));

	}
	public  int[] searchRange(int[] nums, int target) {
		int[] ans = {-1,-1};
		//check for first occurence of first target
		/*
		ans[0] = search(nums, target, true);
		if(ans[0] != -1) {
			return ans;
		}
		*/
		
		int start = search(nums, target, true);
		int end = search(nums, target, false);
		ans[0] = start;
		ans[1] = end;
		
		return ans;
		
	}
	//this function just returns the index of target
	int search(int[] nums, int target, boolean findStartIndex) {
		int ans = -1;
		int start = 0;
		int end = nums.length - 1;
		while(start <= end) {
			//find the middle element 
			//int mid = (start + end) / 2; //might be possible that (start + end)exceed the range of int
			int mid = start + (end - start) / 2;
			if(target < nums[mid]) {
				end = mid - 1;
			}else if(target > nums[mid]) {
				start = mid + 1;
			}else {
				//ans found
				ans = mid;
				if(findStartIndex) {
					end = mid - 1;
				}
			}
		}
		return ans;
	}

}
