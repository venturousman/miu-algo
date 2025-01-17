package dp;

// True OR False
// (Subset Sum Problem) Given a set S of positive integers and a nonnegative integer k
// is there a subset T of S so that the sum of the integers in T equals k?
public class Subset1 {

	private static void print(int n, int k, boolean[][] arr) {
		System.out.println("\nMaxtrix:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
//				if (arr[i][j])
				System.out.print(arr[i][j] + "\t");
//				else
//					System.out.print(" " + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean dp1(int[] s, int k) {
		int n = s.length;
		boolean[][] b = new boolean[n][k + 1];

		// initial values
		for (int i = 0; i < n; i++) {
			b[i][0] = true;
		}
//		b[0][0] = true;
		int firstElement = s[0];
		b[0][firstElement] = true;

		// fill table
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				int p = s[i];
				int col = j - p;
				if (col < 0)
					b[i][j] = b[i - 1][j];
				else
					b[i][j] = b[i - 1][j - p];
			}
		}

//		print(n, k, b);
		return b[n - 1][k];
	}

	// TODO: optimize to use 1d array
	// private static boolean dp2

	public static void main(String[] args) {
		// s = { 3, 2, 7, 1}, k = 6 Output: True, subset is {3, 2, 1}
		int[] s = { 3, 2, 7, 1 };
		int k = 6;
		System.out.println(dp1(s, k));

		s = new int[] { 2, 3, 5 };
		k = 8;
		System.out.println(dp1(s, k));

		s = new int[] { 3, 4, 7, 8 };
		k = 15;
		System.out.println(dp1(s, k));
	}

}
