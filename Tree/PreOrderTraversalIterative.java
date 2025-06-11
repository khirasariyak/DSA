package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/preorder-traversal-iterative/1
* */

public class PreOrderTraversalIterative {

    public static void main(String[] args) {
        System.out.println(preOrderTraversal(TreeNode.getTree()));
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode popped = stack.pop();
            list.add(popped.value);

            TreeNode left = popped.left;
            TreeNode right = popped.right;

            if (right != null) {
                stack.add(right);
            }

            if (left != null) {
                stack.add(left);
            }

        }

        return list;
    }

}
