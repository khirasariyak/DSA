package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
* */

public class BFS {

    public List<Integer> bfs(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            list.add(node);

            for (int k : adj.get(node)) {
                if (!visited[k]) {
                    visited[k] = true;
                    queue.add(k);
                }
            }

        }

        return list;
    }

}
