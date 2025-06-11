package Tree;

/*
* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    List<List<Integer>> zigZagTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            count++;

            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode popped = queue.poll();

                TreeNode left = popped.left;
                TreeNode right = popped.right;

                if (left != null) {
                    queue.add(left);
                }

                if (right != null) {
                    queue.add(right);
                }

                subList.add(popped.value);
            }

            // logic for reversing the list based on level
            if (count % 2 == 0) {
                subList = subList.reversed();
            }

            list.add(subList);
        }

        return list;
    }

}
