package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/maximum-width-of-binary-tree/
* */

public class MaximumWidthOfBinaryTree {

    static class Pair {

        TreeNode node;
        int idx;

        public Pair(TreeNode _node, int _idx) {
            node = _node;
            idx = _idx;
        }

    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();
            int first = 0;
            int last = 0;
            int mmin = q.peek().idx;

            for(int i = 0; i < size; i++) {

                Pair pair = q.poll();
                int idx = pair.idx - mmin;
                TreeNode node = pair.node;

                if (i == 0) {
                    first = idx;
                }

                if (i == size - 1) {
                    last = idx;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * idx + 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * idx + 2));
                }

            }

            maxWidth = Math.max(maxWidth, last - first + 1);

        }

        return maxWidth;
    }

}
