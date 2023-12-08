package StringStringBuilder;

public class PatternPrinting {

	public static void main(String[] args) {
		pattern9(4);
	}
	static void pattern1(int n) {
		for(int r = 1; r<= n; r++) {
			//for every row , run the col
			for(int c = 1; c <= n; c++) {
				System.out.print("*");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern2(int n) {
		for(int r = 1; r<= n; r++) {
			//for every row , run the col
			for(int c = 1; c <= r; c++) {
				System.out.print("*");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	//reverse the star
	static void pattern3(int n) {
		for(int r = 1; r<= n; r++) {
			//for every row , run the col
			for(int c = 1; c <= n - r + 1; c++) {
				System.out.print("*");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern4(int n) {
		for(int r = 1; r<= n; r++) {
			//for every row , run the col
			for(int c = 1; c <= r; c++) {
				System.out.print(c+" ");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern5(int n) {
		for(int r = 0; r < 2 * n; r++) {
			//for every row , run the col
			int totalColsInRow = r > n ? 2 * n - r: r;
			for(int c = 0; c < totalColsInRow; c++) {
				System.out.print("*");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern6(int n) {
		for(int r = 0; r < 2 * n; r++) {
			//for every row , run the col
			int totalColsInRow = r > n ? 2 * n - r: r;
			int noOfSpaces = n - totalColsInRow;
			for(int s = 0; s < noOfSpaces; s++) {
				System.out.print(" ");
			}
			for(int c = 0; c < totalColsInRow; c++) {
				System.out.print("* ");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern7(int n) {
		for(int r = 1; r <= n; r++) {
			for(int space = 0; space < n - r; space++) {
				System.out.print("  ");
			}
			for(int c = r; c >= 1; c--) {
				System.out.print(c + " ");
			}
			
			for(int c = 2; c <= r ; c++) {
				System.out.print(c + " ");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern8(int n) {
		for(int r = 1; r <= 2*n; r++) {
			int col = r > n ? 2*n-r:r;
			for(int space = 0; space < n - col; space++) {
				System.out.print("  ");
			}
			for(int c = col; c >= 1; c--) {
				System.out.print(c + " ");
			}
			
			for(int c = 2; c <= col ; c++) {
				System.out.print(c + " ");
			}
			//when one row is printed, we need to add a new line
			System.out.println();
		}
	}
	
	static void pattern9(int n) {
		int originalN = n;
		n = 2*n;
		for(int r = 1; r <= n; r++) {
			for(int c = 0; c<= n; c++) {
				int atEveryIndex =originalN - Math.min(Math.min(r,  c),Math.min(n-r, n-c));
				System.out.print(atEveryIndex + " ");
			}
			System.out.println();
		}
	}
}
