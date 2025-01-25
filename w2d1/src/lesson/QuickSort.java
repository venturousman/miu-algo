package lesson;

import java.util.Arrays;

public class QuickSort {

	private static void swap(int[] arr, int pos1, int pos2) {
		int tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

	private static int medianOfThree(int[] arr, int start, int stop) {
		int x = arr[start];

		int m = (start + stop) / 2;
		int y = arr[m];

		int z = arr[stop];
		if ((x - y) * (z - x) >= 0) // x >= y and x <= z OR x <= y and x >= z
			return start;
		else if ((y - x) * (z - y) >= 0) // y >= x and y <= z OR y <= x and y >= z
			return m;
		else
			return stop;
	}

	private static void quickSort(int[] arr, int start, int stop) {
		int i, j; // these are the moving pointers
		if (stop <= start)
			return;
		else {
			int pivotPos = medianOfThree(arr, start, stop);
			swap(arr, pivotPos, stop);
			int pivot = arr[stop];
			i = start;
			j = stop - 1;
			while (true) {
				while (i <= j && arr[i] < pivot)
					i++;
				while (i <= j && arr[j] > pivot)
					j--;
				if (i <= j) {
					swap(arr, i++, j--);
				} else
					break;
			}
			swap(arr, stop, i);
			quickSort(arr, start, i - 1);
			quickSort(arr, i + 1, stop);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 1, 8, 2, 6, 4, 3, 9, 8, 2 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
