
public class LinearSearchInRange 
{

	public static void main(String[] args) 
	{
		int arr[]  = {18,12,-7,3,14,28};
		int target = 10;
		System.out.println(linearSearch(arr,target,1,4));
		

	}
	
	static int linearSearch(int[] arr, int target, int start, int end)
	{
		if(arr.length == 0)
		{
			return -1;
		}
		//run a for loop
		for(int i = start; i <= end; i++)
		{
			//check for element at every index if it is = target
			int element = arr[i];
			if(element == target)
			{
				return i;
			}
		}
		return -1;
		
	}

}
