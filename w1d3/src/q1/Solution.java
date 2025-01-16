package q1;

public class Solution {

	// (1) The number of rows is equal to the number of columns
	// (2) Each row is in nondecreasing order.
	// (3) Each column is in nondecreasing order.

	private static int[][] SortedSquare1(int n, int start) {
		// rows
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
//				int seg = i * n + j;
//				arr[i][j] = start + seg;
				arr[i][j] = start++;
			}
		}
		return arr;
	}

	private static int[][] SortedSquare2(int n, int start) {
		// diagonal
		int[][] arr = new int[n][n];
		boolean flip = false;
		
		// i + j == k
		// Print diagonals starting from the first row
		for (int col = 0; col < n; col++) {
	        int i = 0, j = col;
	        while (i < n && j >= 0) {
	            System.out.print(i + "," + j + "\t");
	            if (!flip) arr[i][j] = start++;
				else arr[j][i] = start++;
	            i++;
	            j--;
	        }
	        flip = !flip;
	        System.out.println();
	    }
		System.out.println();
		
		// Print diagonals starting from the last column of each row (except the first row)
	    for (int row = 1; row < n; row++) {
	        int i = row, j = n - 1;
	        while (i < n && j >= 0) {
	            System.out.print(i + "," + j + "\t");
				if (!flip) arr[i][j] = start++;
				else arr[j][i] = start++;
	            i++;
	            j--;
	        }
	        flip = !flip;
	        System.out.println();
	    }

		return arr;
	}

	private static int[][] SortedSquare3(int n, int start) {
		// cols
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int seg = i * n + j;
				arr[j][i] = start + seg;
			}
		}
		return arr;
	}

	private static void print(int n, int[][] arr) {
		System.out.println("\nMaxtrix:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] m1 = SortedSquare1(n, 5);
//		print(n, m1);

		int[][] m2 = SortedSquare2(n, 5);
		print(n, m2);

		int[][] m3 = SortedSquare3(n, 5);
//		print(n, m3);
	}

}
