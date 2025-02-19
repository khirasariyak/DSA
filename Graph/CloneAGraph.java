
// https://leetcode.com/problems/clone-graph/

class CloneAGraph {

  public Node cloneGraph(Node node) {

        if(node == null) {
            return null;
        }

        if(node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        q.add(node);

        while(!q.isEmpty()) {

            Node curr = q.poll();

            for(Node n : curr.neighbors) {
                
                if(!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }

        }

        return newNode;
    }
  
}
