package Tree;

import java.util.AbstractMap;

/*
* https://leetcode.com/problems/balanced-binary-tree/
* */

public class BalancedTreeCheck {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(isBalancedBruteForce(root));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalancedBruteForce(TreeNode root) {

        if(root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1 && isBalancedBruteForce(root.left) && isBalancedBruteForce(root.right);
    }

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    private static boolean isBalanced(TreeNode root) {
        AbstractMap.SimpleEntry<Integer, Boolean> simpleEntry = height2(root);
        return simpleEntry.getValue();
    }

    private static AbstractMap.SimpleEntry<Integer, Boolean> height2(TreeNode root) {

        if (root == null) {
            return new AbstractMap.SimpleEntry<>(0, true);
        }

        AbstractMap.SimpleEntry<Integer, Boolean> left = height2(root.left);
        AbstractMap.SimpleEntry<Integer, Boolean> right = height2(root.right);

        int leftKey = left.getKey();
        int rightKey = right.getKey();
        boolean leftValue = left.getValue();
        boolean rightValue = right.getValue();
        boolean condition = Math.abs(leftKey - rightKey) <= 1 && leftValue && rightValue;

        return new AbstractMap.SimpleEntry<>(1 + Math.max(leftKey, rightKey), condition);
    }

}
