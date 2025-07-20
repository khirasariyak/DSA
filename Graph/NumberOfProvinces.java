package Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/number-of-provinces/
 * */

public class NumberOfProvinces {

    public int numberOfProvincesWithDisjointSet(int[][] isConnected) {

        int V = isConnected.length;

        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    ds.union(i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < V; i++) {
            if (ds.find(i) == i) {
                count++;
            }
        }

        return count;

    }

    public int numberOfProvincesWithDFS(int[][] isConnected) {

        int count = 0;
        int m = isConnected.length;
        boolean[] visited = new boolean[m];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj) {

        visited[node] = true;

        for (int k : adj.get(node)) {
            if (!visited[k]) {
                dfs(k, visited, adj);
            }
        }

    }

}
