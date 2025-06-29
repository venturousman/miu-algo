package graph;

import java.util.Arrays;

public class Dijkstra {

	// Greedy
	private static void greedyDijkstra(int[][] w, int s, int[] dist, int[] visited, int[] trace) {
		int n = w.length;
		int min = Integer.MAX_VALUE;
		int u = s;
		dist[u] = 0; // coz all dist is Integer.MAX_VALUE
		while (u >= 0) {
			visited[u] = 1;
			for (int v = 0; v < n; v++) {
				if (w[u][v] == 0)
					continue;
				if (visited[v] == 0 && dist[v] > dist[u] + w[u][v]) {
					dist[v] = dist[u] + w[u][v];
					trace[v] = u;
				}
			}

			u = -1;
			min = Integer.MAX_VALUE;
			for (int v = 0; v < n; v++) {
				if (visited[v] == 0 && dist[v] < min) {
					min = dist[v];
					u = v;
				}
			}
		}
	}

	// DP

	public static void main(String[] args) {
		int[][] w = { { 0, 22, 9, 12, 0, 0, 0, 0, 0 }, { 22, 0, 35, 0, 0, 36, 0, 34, 0 },
				{ 9, 35, 0, 4, 65, 42, 0, 0, 0 }, { 12, 0, 4, 0, 33, 0, 0, 0, 30 }, { 0, 0, 65, 33, 0, 18, 23, 0, 0 },
				{ 0, 36, 42, 0, 18, 0, 39, 24, 0 }, { 0, 0, 0, 0, 23, 39, 0, 25, 21 },
				{ 0, 34, 0, 0, 0, 24, 25, 0, 19 }, { 0, 0, 0, 30, 0, 0, 21, 19, 0 }, };

		int n = w.length;
		int[] dist = new int[n]; // all max
		int[] visited = new int[n]; // all 0
		int[] trace = new int[n]; // all -1

		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(trace, -1); // Fill all elements with -1

		int s = 0; // A
		greedyDijkstra(w, s, dist, visited, trace);

		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(visited));
		System.out.println(Arrays.toString(trace));

	}

}
