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

//	private static int[][] SortedSquare2(int n, int start) {
//		// diagonal
//		int[][] arr = new int[n][n];
//		boolean flip = false;
//		
//		// i + j == k
//		// Print diagonals starting from the first row
//		for (int col = 0; col < n; col++) {
//	        int i = 0, j = col;
//	        while (i < n && j >= 0) {
//	            System.out.print(i + "," + j + "\t");
//	            if (!flip) arr[i][j] = start++;
//				else arr[j][i] = start++;
//	            i++;
//	            j--;
//	        }
//	        flip = !flip;
//	        System.out.println();
//	    }
//		System.out.println();
//		
//		// Print diagonals starting from the last column of each row (except the first row)
//	    for (int row = 1; row < n; row++) {
//	        int i = row, j = n - 1;
//	        while (i < n && j >= 0) {
//	            System.out.print(i + "," + j + "\t");
//				if (!flip) arr[i][j] = start++;
//				else arr[j][i] = start++;
//	            i++;
//	            j--;
//	        }
//	        flip = !flip;
//	        System.out.println();
//	    }
//
//		return arr;
//	}

	private static int[][] SortedSquare2(int n, int start) {
		// diagonal
		int[][] arr = new int[n][n];
		boolean flip = false;

		// i + j == k
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int j = k - i;
				if (j < 0 || j >= n)
					continue;
//				System.out.print(i + "," + j + "\t");
				if (!flip)
					arr[i][j] = start++;
				else
					arr[j][i] = start++;
			}
			flip = !flip;
//			System.out.println();
		}
//		System.out.println();

		// i + j = n - 1 + k
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n; i++) {
				int j = n - 1 + k - i;
				if (j < 0 || j >= n)
					continue;
//				System.out.print(i + "," + j + "\t");
				if (!flip)
					arr[i][j] = start++;
				else
					arr[j][i] = start++;
			}
			flip = !flip;
//			System.out.println();
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
		System.out.println();
	}

	// a search algorithm without DAC
	// if key is present in the sorted square M, print a pair of row & column,
	// otherwise print "Not Found"
	// e.g. M2, key 23, print (1,4); key 34, print "Not Found"
	private static String searchSS(int[][] M, int key) {
		int rows = M.length;
		int cols = M[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (M[i][j] == key) {
					String message = "(" + i + "," + j + ")";
					return message;
				}
			}
		}

		return "Not Found";
	}

	// Each row, each column is sorted in ascending order.
	// **approach:
	// - flatten the array: treat the 2D array as a 1D sorted array.
	// + for an element at position index in a flattened array:
	// + row = index / cols; col = index % cols
	// - apply binary search
	// use a staircase search or a recursive divide-and-conquer strategy
	private static String DACsearchSS(int[][] M, int key) {
		if (M == null || M.length == 0 || M[0].length == 0) {
//            return false; // Handle edge cases
			return "Not Found";
		}

		int rows = M.length;
		int cols = M[0].length;

		// Start at the top-right corner
		int row = 0;
		int col = cols - 1;

		while (row < rows && col >= 0) {
			if (M[row][col] == key) {
//				return true; // found
				String message = "(" + row + "," + col + ")";
				return message;
			} else if (M[row][col] > key) {
				col--; // Move left
			} else {
				row++; // Move down
			}
		}

		return "Not Found";
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] m1 = SortedSquare1(n, 5);
//		print(n, m1);

		int[][] m2 = SortedSquare2(n, 5);
		print(n, m2);

		int key = 23;
		long startTime = System.nanoTime(); // empirical tool
		String result = searchSS(m2, key);
		long endTime = System.nanoTime();
		long duration = endTime - startTime; // Time in nanoseconds
		System.out.println("Search 23: " + result);
		System.out.println("Execution time: " + duration + " nanoseconds");

		startTime = System.nanoTime();
		result = DACsearchSS(m2, key);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("DAC Search 23: " + result);
		System.out.println("Execution time: " + duration + " nanoseconds");

		System.out.println("----------");
		key = 34;
		startTime = System.nanoTime();
		result = searchSS(m2, key);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("Search 34: " + result);
		System.out.println("Execution time: " + duration + " nanoseconds");

		startTime = System.nanoTime();
		result = DACsearchSS(m2, key);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("DAC Search 34: " + result);
		System.out.println("Execution time: " + duration + " nanoseconds");

		int[][] m3 = SortedSquare3(n, 5);
//		print(n, m3);
	}

}
