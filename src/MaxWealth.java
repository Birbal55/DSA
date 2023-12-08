
public class MaxWealth {

	public static void main(String[] args) {
		
		

	}
	public int maxWealth(int[][] accounts)
	{
		int ans = Integer.MIN_VALUE;
		//for(int r = 0; r < accounts.length; r++)
		for(int[] ints : accounts)
		{
			//when you start a new col, take a new sum for that row
			int sum = 0;
			//for(int c = 0; c<accounts[r].length; c++)
			for(int anInt : ints)
			{
				//sum += accounts[r][c];
				sum += anInt;
			}
			//now we have sum of accounts of person
			//check with overall sum
			if(sum > ans)
			{
				ans = sum;
			}
		}
		return ans;
	}

}
