package question1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

	private static int findThirdLargest1(int[] a) {
		/*
		 * Idea – Use three loops one after another. First loop will find Max. Second
		 * loop will find Second Max, Third loop will find third max. Note that it is
		 * possible First max == second Max == Third Max as in 7, 20, 18, 4, 20, 19, 20,
		 * 3. and your program should return 20 in this case.
		 */
		if (a == null || a.length < 3) {
			throw new IllegalArgumentException("Array must contain at least three elements.");
		}

		int n = a.length;
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[index]) {
				index = i;
			}
		}
		int secondIndex = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[secondIndex] && i != index) {
				secondIndex = i;
			}
		}
		int thirdIndex = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[thirdIndex] && i != index && i != secondIndex) {
				thirdIndex = i;
			}
		}
//		System.out.println(index + ", " + secondIndex + ", " + thirdIndex);
		return a[thirdIndex];
	}

	public static int findThirdLargest2(int[] nums) {
		/*
		 * Idea – Use one loop. Maintain three variable max, preMax and prePreMax such
		 * that max will have the maximum value, preMax will have the second largest and
		 * prePreMax will have the third largest value.
		 */
		if (nums == null || nums.length < 3) {
			throw new IllegalArgumentException("Array must contain at least three elements.");
		}

		Integer first = null, second = null, third = null;

		for (int num : nums) {
			if (first == null || num > first) {
				third = second;
				second = first;
				first = num;
			} else if (second == null || (num > second && num <= first)) {
				third = second;
				second = num;
			} else if (third == null || (num > third && num <= second)) {
				third = num;
			}
		}

		if (third == null) {
			throw new IllegalArgumentException("Array must have at least three unique numbers.");
		}

		return third;
	}

	public static int findThirdLargest3(int[] nums) {
		// Idea – Use an ordered dictionary.
		if (nums == null || nums.length < 3) {
			throw new IllegalArgumentException("Array must contain at least three elements.");
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int num : nums) {
			pq.add(num);
		}
//		// Print the priority queue (not sorted order)
//        System.out.println("PriorityQueue (internal heap order): " + pq);
//        
//        // Print in sorted order
//        System.out.print("Sorted order: ");
//        while (!pq.isEmpty()) {
//            System.out.print(pq.poll() + " ");
//        }
		pq.poll(); // Retrieves and removes the head of this queue, or returns null if this queue
					// is empty.
		pq.poll();
		int thirdLargest = pq.peek(); // Retrieves, but does not remove, the head of this queue, or returns null if
										// this queue is empty.

		return thirdLargest;
	}

	public static int findThirdLargest4(int[] nums) {
		// Idea – Use an ordered dictionary.
		if (nums == null || nums.length < 3) {
			throw new IllegalArgumentException("Array must contain at least three elements.");
		}

		// Create a TreeMap of Strings (keys) and Integers (values)
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for (int num : nums) {
			map.put(num, num);
		}

		// Displaying the TreeMap
		System.out.println("TreeMap elements: " + map);
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 20, 18, 4, 20, 19, 20, 3 };
//		int[] arr = { 7, 20, 18, 4, 21, 19, 5, 3 };
//		int[] arr = { 5, 1, 2, 9, 7, 7, 3 };
//		int[] arr = { 5, 1, 2, 6, 7, 7, 3 };
//      int[] arr = {10, 20, 4, 45, 99, 87, 76};

		System.out.println(findThirdLargest1(arr));
		System.out.println(findThirdLargest2(arr));
		System.out.println(findThirdLargest3(arr));
//		System.out.println(findThirdLargest4(arr));
	}

}
