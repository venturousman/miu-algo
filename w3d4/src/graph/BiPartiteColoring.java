package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BiPartiteColoring {

	private static int[] DFSBiPartiteColoring(int[][] a, int s) {
		int n = a.length;

		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		// -1 not colored. 0, 1 two different colors
		color[s] = 0;

		Stack<Integer> st = new Stack<>();
		st.push(s);
		while (!st.isEmpty()) {
			int v = st.peek();
			int w = -1;
			for (int u = 0; u < n; u++) {
				if (a[v][u] > 0 && color[u] < 0) {
					w = u;
					break;
				}
			}
			if (w == -1) {
				// cant find w, backtrack
				st.pop();
			} else {
				int nextColor = (color[v] + 1) % 2;
				for (int u = 0; u < n; u++) {
					if (a[w][u] > 0 && color[u] == nextColor) {
						return color;
					}
				}
				color[w] = nextColor;
				st.push(w);
			}
		}

		return color;
	}

	private static int[] BFSBiPartiteColoring(int[][] a, int s) {
		int n = a.length;

		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		// -1 not colored. 0, 1 two different colors
		color[s] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w = 0; w < n; w++) {
				if (a[v][w] > 0 && color[w] < 0) {
					int nextColor = (color[v] + 1) % 2;
					for (int u = 0; u < n; u++) {
						if (a[w][u] > 0 && color[u] == nextColor) {
							return color;
						}
					}
					color[w] = nextColor;
					q.add(w);
				}
			}
		}
		return color;
	}

	public static void main(String[] args) {
		// the following graph has cycle -> cannot be bipartite graph
		int[][] a = { { 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 1, 1, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 1, 1 }, { 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 1, 1, 0 }, };

		int[][] b = { { 0, 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 }, };

		System.out.println(Arrays.toString(DFSBiPartiteColoring(b, 6)));
		System.out.println(Arrays.toString(BFSBiPartiteColoring(b, 6)));
	}

}
