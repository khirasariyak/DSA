package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
* https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
* */

public class AllNodesAtDistanceK {

    public List<Integer> nodesAtDistanceK(TreeNode root, TreeNode target, int k) {

        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

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

        queue.offer(target);
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> visited = new HashMap<>();

        while (k > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();

                visited.put(top.value, 1);

                if (top.left != null && !visited.containsKey(top.left.value)) {
                    queue.offer(top.left);
                }

                if (top.right != null && !visited.containsKey(top.right.value)) {
                    queue.offer(top.right);
                }

                if (parent.containsKey(top.value) && !visited.containsKey(parent.get(top.value).value)) {
                    queue.offer(parent.get(top.value));
                }
            }

            k--;
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll().value);
        }

        return ans;
    }

}
