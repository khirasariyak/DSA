package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal/
* */

public class LevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            int numberOfNodes = q.size();

            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < numberOfNodes; i++) {

                TreeNode left = q.peek().left;
                TreeNode right = q.peek().right;

                if (left != null) {
                    q.add(left);
                }

                if (right != null) {
                    q.add(right);
                }

                subList.add(q.poll().value);
            }

            list.add(subList);
        }

        return list;
    }

}
