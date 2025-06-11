package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/postorder-traversal-iterative/1
* */

public class PostOrderTraversalIterative {

    public static void main(String[] args) {
        System.out.println(postOrderTraversalIterative(TreeNode.getTree()));
        System.out.println(postOrderTraversalIterativeOptimized(TreeNode.getTree()));
    }

    public static List<Integer> postOrderTraversalIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        while(!stack1.isEmpty()) {
            TreeNode popped = stack1.pop();
            stack2.add(popped);

            TreeNode left = popped.left;
            TreeNode right = popped.right;

            if (left != null) {
                stack1.add(left);
            }

            if (right != null) {
                stack1.add(right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().value);
        }

        return list;
    }

    public static List<Integer> postOrderTraversalIterativeOptimized(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {

                TreeNode temp = stack.peek().right;

                if (temp == null) {
                    temp = stack.pop();
                    list.add(temp.value);

                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        list.add(temp.value);
                    }
                } else {
                    current = temp;
                }

            }
        }

        return list;
    }

}
