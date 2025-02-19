
// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class DFS {
    
    ArrayList<Integer> ans = new ArrayList<>();
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int V = adj.size();
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
               dfsRecursive(i, V, vis, adj); 
            }
        }
        
        return ans;
    }
    
    public void dfsRecursive(int i, int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        
        vis[i] = true;
        ans.add(i);
        
        for(int n : adj.get(i)) {
            
            if(!vis[n]) {
                dfsRecursive(n, V, vis, adj);
            }
            
        }
        
    }

    public ArrayList<Integer> dfsIterative(ArrayList<ArrayList<Integer>> adj) {
          
          boolean[] vis = new boolean[adj.size()];
          Stack<Integer> s = new Stack<>();
          ArrayList<Integer> list = new ArrayList<>();
          
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
