import java.util.Arrays;

public class LinearSearchStrings {

	public static void main(String[] args) 
	{
			String name = "Birbal";
			char target = 'e';
			System.out.println(linearSearch2(name, target));
			System.out.println(Arrays.toString(name.toCharArray()));
	}
		
		static boolean linearSearch(String str, char target)
		{
			if(str.length() == 0)
			{
				return false;
			}
			
			for(int i = 0; i < str.length(); i++)
			{
				if(target == str.charAt(i))
				{
					return true;
				}
			}
			return false;
		}
		//
		static boolean linearSearch2(String str, char target)
		{
			if(str.length() == 0)
			{
				return false;
			}
			for(char ch : str.toCharArray())
			{
				if(ch == target)
				{
					return true;
				}
			}
			return false;
		}
		

	

}
