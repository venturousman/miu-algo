package dp;

// All solution/subsets
public class Subset3 {

	private static void print(int n, int k, String[][] arr) {
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

	private static String dp1(int[] s, int k) {
		int n = s.length;
		String[][] b = new String[n][k + 1];

		// initial values
		for (int i = 0; i < n; i++) {
			b[i][0] = "{}";
		}
//		b[0][0] = true;
		int firstElement = s[0];
		if (firstElement <= k)
			b[0][firstElement] = "{" + s[0] + "}";

		// fill table
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				int p = s[i];
				int col = j - p;
				if (col < 0 || b[i - 1][col] == null) {
					b[i][j] = b[i - 1][j]; // Don't include current element
				} else {
					String si = "{" + s[i] + "}";
					String curr = b[i - 1][col].equals("{}") ? "" : b[i - 1][col].toString();
					String include = curr + si;
					b[i][j] = b[i - 1][j] == null ? include : b[i - 1][j] + "," + include; // all subsets
					b[i][j] = b[i][j].replace("}{", ","); // for decoration
				}
			}
		}

		print(n, k, b);
		return b[n - 1][k];
	}

	// TODO: optimize to use 1d array
	// private static String dp2

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
