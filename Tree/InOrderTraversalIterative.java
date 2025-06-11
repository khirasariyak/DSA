package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* https://www.geeksforgeeks.org/problems/inorder-traversal-iterative/1
* */

public class InOrderTraversalIterative {

    public static void main(String[] args) {
        System.out.println(inOrderTraversalIterative(TreeNode.getTree()));
    }

    private static List<Integer> inOrderTraversalIterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (true) {

            if (current != null) {
                stack.add(current);
                current = current.left;
            } else {

                if (stack.isEmpty()) {
                    break;
                }

                current = stack.pop();
                list.add(current.value);
                current = current.right;
            }

        }

        return list;
    }

}
