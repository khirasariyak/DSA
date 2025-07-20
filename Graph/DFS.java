package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
* */

class DFS {
    
    List<Integer> ans = new ArrayList<>();
    
    // Function to return a list containing the DFS traversal of the graph.
    public List<Integer> dfsOfGraph(List<List<Integer>> adj) {
        
        int V = adj.size();
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
               dfsRecursive(i, V, vis, adj); 
            }
        }
        
        return ans;
    }
    
    public void dfsRecursive(int i, int V, boolean[] vis, List<List<Integer>> adj) {
        
        vis[i] = true;
        ans.add(i);
        
        for(int n : adj.get(i)) {
            
            if(!vis[n]) {
                dfsRecursive(n, V, vis, adj);
            }
            
        }
        
    }

    public List<Integer> dfsIterative(List<List<Integer>> adj) {
          
          boolean[] vis = new boolean[adj.size()];
          Stack<Integer> s = new Stack<>();
          List<Integer> list = new ArrayList<>();
          
          s.push(0);
          vis[0] = true;
          
          while(!s.isEmpty()) {
              
              int n = s.pop();
              list.add(n);
              
              for (int num : adj.get(n)) {
                  if (!vis[num]) {
                      vis[num] = true;
                      s.push(num);
                  }
              }
              
          }
          
          return list;
          
      }
    
}
