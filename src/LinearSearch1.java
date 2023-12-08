
public class LinearSearch1 {

	public static void main(String[] args) 
	{
		int num[] = {23,45,1,2,8,19,-3,16,-11,28};
		int target = 230;
		int ans = linearSearch(num, target);
		System.out.println(ans);
	}
	
	//search in the array and return the index if item found
	//otherwise if item not found return -1
	static int linearSearch(int[] arr, int target)
	{
		if(arr.length == 0)
		{
			return -1;
		}
		//run a for loop 
		for (int i = 0;i<arr.length; i++)
		{
			//check for element at every index if it is = target
			int element = arr[i];
			if(element == target)
			{
				return i;
			}
		}
		//this line will execute if none of the return statements above have executed
		//hence the target not found
		return -1;
	}
	
	//search the target and return true and false
	static boolean linearSearch2(int[] arr, int target)
	{
		if(arr.length == 0)
		{
			return false;
		}
		//run a for loop
		for(int element : arr)
		{
			if(element == target)
			{
				return true;
			}
		}
		//this line will execute if none of the return statements above have
		//hence return the target not found
		return false;
	}
	
	//search the target and return the element
	static int linearSearch3(int[] arr, int target)
	{
		if(arr.length == 0)
		{
			return -1;
		}
		//run a for loop
		for(int element : arr)
		{
			if(element == target)
			{
				return element;
			}
		}
		//this line will 
		return -1;
	}

}
