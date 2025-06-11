package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    class Tuple {

        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty()) {

            Tuple t = queue.poll();
            TreeNode n = t.node;
            int val = n.value;
            int x = t.row;
            int y = t.col;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).add(val);

            if (n.left != null) {
                queue.add(new Tuple(n.left, x - 1, y + 1));
            }

            if (n.right != null) {
                queue.add(new Tuple(n.right, x + 1, y + 1));
            }

        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer, Map<Integer, Queue<Integer>>> entry : map.entrySet()) {

            List<Integer> col = new ArrayList<>();
            for (Queue<Integer> e : entry.getValue().values()) {
                col.addAll(e);
            }
            ans.add(col);

        }

        return ans;
    }

}
