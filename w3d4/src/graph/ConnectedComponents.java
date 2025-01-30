package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConnectedComponents {

	private static void DFS(int[][] a, int s, int noComponent, int[] c) {
		int n = a.length;
		Stack<Integer> st = new Stack<>();
		c[s] = noComponent;
		st.push(s);
		while (!st.isEmpty()) {
			int v = st.peek();
			int w = -1;
			for (int u = 0; u < n; u++) {
				if (a[v][u] > 0 && c[u] == 0) {
					w = u;
					break;
				}
			}
			if (w == -1) {
				// cant find w, backtrack
				st.pop();
			} else {
				c[w] = noComponent;
				st.push(w);
			}
		}
	}

	private static void BFS(int[][] a, int s, int noComponent, int[] c) {
		int n = a.length;
		Queue<Integer> q = new LinkedList<>();
		c[s] = noComponent;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w = 0; w < n; w++) {
				if (a[v][w] > 0 && c[w] == 0) {
					c[w] = noComponent;
					q.add(w);
				}
			}
		}
	}

	private static int[] findDFSComponents(int[][] a) {
		int n = a.length;
		int[] c = new int[n];
		int noComponent = 0;
		for (int s = 0; s < n; s++) {
			if (c[s] == 0) {
				noComponent++;
				DFS(a, s, noComponent, c);
			}
		}
		return c;
	}

	private static int[] findBFSComponents(int[][] a) {
		int n = a.length;
		int[] c = new int[n];
		int noComponent = 0;
		for (int s = 0; s < n; s++) {
			if (c[s] == 0) {
				noComponent++;
				BFS(a, s, noComponent, c);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, };

		System.out.println(Arrays.toString(findDFSComponents(a)));
		System.out.println(Arrays.toString(findBFSComponents(a)));
	}

}
