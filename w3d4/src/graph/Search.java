package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Search {

	private static void DFS(int[][] a, int s) {
		int n = a.length;
		int[] visited = new int[n];
		Stack<Integer> st = new Stack<>();
		visited[s] = 1;
		st.push(s);
		while (!st.isEmpty()) {
			int v = st.peek();
			int w = -1;
			for (int u = 0; u < n; u++) {
				if (a[v][u] > 0 && visited[u] == 0) {
					w = u;
					break;
				}
			}
			if (w == -1) {
				st.pop(); // cant find w, backtrack
			} else {
				visited[w] = 1;
				st.push(w);
			}
		}
	}

	private static void BFS(int[][] a, int s) {
		int n = a.length;
		int[] visited = new int[n];
		Queue<Integer> q = new LinkedList<>();
		visited[s] = 1;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w = 0; w < n; w++) {
				if (a[v][w] > 0 && visited[w] == 0) {
					visited[w] = 1;
					q.add(w);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
	}

}
