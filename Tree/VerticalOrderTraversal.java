package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/*
* https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
*
* Solution is giving wrong answer, need to rectify them
* */

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

    // Simpler approach
    // not considering the following scenario
    // "If two nodes are at the same column and same row, which one comes first in the output?"
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int column = p.column;

            if (!columnTable.containsKey(column)) {
                columnTable.put(column, new ArrayList<>());
            }
            columnTable.get(column).add(node.value);

            min = Math.min(min, column);
            max = Math.max(max, column);

            if (node.left != null) queue.offer(new Pair(node.left, column - 1));
            if (node.right != null) queue.offer(new Pair(node.right, column + 1));
        }

        // Iterate from min to max column index
        for (int i = min; i <= max; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

    private static class Pair {
        TreeNode node;
        int column;
        Pair(TreeNode n, int col) {
            node = n;
            column = col;
        }
    }
    
}
