package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
* https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
* */

public class BurnATree {

    TreeNode target;

    public int amountOfTime(TreeNode root, int start) {

        if (root == null) {
            return 0;
        }

        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                if (top.value == start) {
                    target = top;
                }

                if (top.left != null) {
                    parent.put(top.left.value, top);
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    parent.put(top.right.value, top);
                    queue.offer(top.right);
                }
            }
        }

        if (target == null) {
            return -1;
        }

        queue.add(target);
        int count = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(target.value, 1);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                if (top.left != null && !visited.containsKey(top.left.value)) {
                    visited.put(top.left.value, 1);
                    queue.offer(top.left);
                    flag = 1;
                }

                if (top.right != null && !visited.containsKey(top.right.value)) {
                    visited.put(top.right.value, 1);
                    queue.offer(top.right);
                    flag = 1;
                }

                if (parent.containsKey(top.value) && !visited.containsKey(parent.get(top.value).value)) {
                    visited.put(parent.get(top.value).value, 1);
                    queue.offer(parent.get(top.value));
                    flag = 1;
                }
            }

            if (flag == 1) {
                count++;
            }   

        }

        return count;

    }

}
