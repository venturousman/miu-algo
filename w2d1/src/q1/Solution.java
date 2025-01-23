package q1;

import java.util.Arrays;

public class Solution {

	/*
	 * Consider an array of “Wooden blocks toys”. One of the features of these toys
	 * is that they are painted either Blue or Red. Devise an algorithm to keep all
	 * the Blue toys together at one end of the array and all Red toys together at
	 * the other end of the array.
	 */
	private static void woodenBlocksToys1(String[] toys) {
		int left = 0, right = toys.length - 1;
		while (left < right) {
			if (toys[left] == "Blue")
				left++;
			else if (toys[right] == "Red")
				right--;
			else {
				String tmp = toys[left];
				toys[left] = toys[right];
				toys[right] = tmp;
				left++;
				right--;
			}
		}
	}

	// Solve it for three different colors: Blue, Red and Green
	private static void woodenBlocksToys2(String[] toys) {
		int blue = 0, red = 0, green = 0;
		for (int i = 0; i < toys.length; i++) {
			if (toys[i] == "Blue")
				blue++;
			else if (toys[i] == "Red")
				red++;
			else if (toys[i] == "Green")
				green++;
		}
		int index = 0;
		for (int i = 0; i < blue; i++) {
			toys[index++] = "Blue";
		}
		for (int i = 0; i < green; i++) {
			toys[index++] = "Green";
		}
		for (int i = 0; i < red; i++) {
			toys[index++] = "Red";
		}
	}

	private static void woodenBlocksToys2b(String[] toys) {
		int low = 0, mid = 0, high = toys.length - 1;
		// 3 pointers
		String tmp;
		while (mid <= high) {
			if (toys[mid] == "Blue") {
				tmp = toys[low];
				toys[low] = toys[mid];
				toys[mid] = tmp;
				low++;
				mid++;
			} else if (toys[mid] == "Green") {
				mid++;
			} else {
				// toys[mid] == "Red"
				tmp = toys[high];
				toys[high] = toys[mid];
				toys[mid] = tmp;
				high--;
			}
		}
	}

	private static void woodenBlocksToys3(String[] toys) {
		int blue = 0, red = 0, green = 0, yellow = 0;
		for (int i = 0; i < toys.length; i++) {
			if (toys[i] == "Blue")
				blue++;
			else if (toys[i] == "Red")
				red++;
			else if (toys[i] == "Green")
				green++;
			else if (toys[i] == "Yellow")
				yellow++;
		}
		int index = 0;
		for (int i = 0; i < blue; i++) {
			toys[index++] = "Blue";
		}
		for (int i = 0; i < green; i++) {
			toys[index++] = "Green";
		}
		for (int i = 0; i < yellow; i++) {
			toys[index++] = "Yellow";
		}
		for (int i = 0; i < red; i++) {
			toys[index++] = "Red";
		}
	}

	public static void main(String[] args) {
		String[] toys = { "Blue", "Red", "Red", "Blue", "Blue", "Red" };
		System.out.println(Arrays.toString(toys));
		woodenBlocksToys1(toys);
		System.out.println(Arrays.toString(toys));

		System.out.println();

		String[] toys2 = { "Green", "Blue", "Red", "Blue", "Green", "Red", "Blue" };
		System.out.println(Arrays.toString(toys2));
//		woodenBlocksToys2(toys2);
		woodenBlocksToys2b(toys2);
		System.out.println(Arrays.toString(toys2));

		System.out.println();

		String[] toys3 = { "Green", "Blue", "Red", "Yellow", "Blue", "Green", "Red", "Blue", "Yellow" };
		System.out.println(Arrays.toString(toys3));
		woodenBlocksToys3(toys3);
		System.out.println(Arrays.toString(toys3));
	}
}
