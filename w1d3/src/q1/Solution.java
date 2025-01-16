package q1;

public class Solution {

	// (1) The number of rows is equal to the number of columns
	// (2) Each row is in nondecreasing order.
	// (3) Each column is in nondecreasing order.

	private static int[][] SortedSquare1(int n, int start) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int seg = i * n + j;
				arr[i][j] = start + seg;
			}
		}
		return arr;
	}

	private static void SortedSquare2(int n, int start) {

	}

	private static int[][] SortedSquare3(int n, int start) {
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
		int[][] m1 = SortedSquare1(5, 5);
		print(5, m1);
		
		int[][] m3 = SortedSquare3(5, 5);
		print(5, m3);
	}

}
