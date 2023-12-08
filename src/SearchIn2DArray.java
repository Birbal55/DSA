import java.util.Arrays;

public class SearchIn2DArray 
{
	public static void main(String[] args) 
	{
		int[][] arr = {
				{23,4,1},
				{18,12,3,9},
				{78,99,34,56},
				{18,12},
		};
		int target = 12;
		int[] ans = search(arr,target);//format of return value {row,col}
		System.out.println(Arrays.toString(ans));
		System.out.println(max(arr));
		System.out.println(Integer.MIN_VALUE);

	}
	static int[] search(int[][] arr,int target)
	{
		for(int r = 0; r < arr.length; r++)
		{
			for(int c = 0; c < arr[r].length; c++)
			{
				if(arr[r][c] == target)
				{
					return new int[] {r,c};
				}
			}
		}
		return new int[] {-1,-1};
	}
	
	static int max(int[][] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int[] ints : arr)
		{
			for(int element : ints)
			{
				if(element > max)
				{
					max = element;
				}
			}
		}
		return max;
	}

}
