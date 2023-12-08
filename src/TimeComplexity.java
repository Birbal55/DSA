
public class TimeComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double now = System.currentTimeMillis();
		
		TimeComplexity tm = new TimeComplexity();
		System.out.println(tm.findSum(6));
		
		System.out.println("Time taken - "+(System.currentTimeMillis() - now)+"milisecs.");
		
	}
   /* public int findSum(int num)
	{
		return num*(num+1)/2;
	}
	*/
	public int findSum(int num)
	{
		int sum=0;
		for(int i=1;i<=num;i++)
		{
			sum=sum+i;
		}
		return sum;
	}
	

}
