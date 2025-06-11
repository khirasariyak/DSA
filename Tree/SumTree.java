package Tree;

/*
* https://www.geeksforgeeks.org/problems/sum-tree/1
* */

import java.util.AbstractMap;

public class SumTree {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        isSumTree(tree);
    }

    private static void isSumTree(TreeNode root) {
        System.out.println(isSumTreeBruteForce(root));
        System.out.println(isSumTreeOptimized(root));
        System.out.println(isSumTreeOptimized2(root).getValue());
    }

    private static boolean isSumTreeBruteForce(TreeNode root) {

        /*

        For the following tree, it'll give true but actual answer is false.

                 10
                /  \
               5    2
                   /  \
                  1    1
                /
               1

         */

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return sum(root.left) + sum(root.right) == root.value;
    }

    private static int sum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return root.value + sum(root.left) + sum(root.right);
    }

    private static boolean isSumTreeOptimized(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        boolean left = isSumTreeOptimized(root.left);
        boolean right = isSumTreeOptimized(root.right);

        int sum = 0;
        if (root.left != null) {
            sum += root.left.value;
        }
        if (root.right != null) {
            sum += root.right.value;
        }

        if (sum != root.value) {
            return false;
        }

        root.value += sum;
        return left && right;
    }

    private static AbstractMap.SimpleEntry<Integer, Boolean> isSumTreeOptimized2(TreeNode root) {

        if (root == null) {
            return new AbstractMap.SimpleEntry<>(0, true);
        }

        if (root.left == null && root.right == null) {
            return new AbstractMap.SimpleEntry<>(root.value, true);
        }

        AbstractMap.SimpleEntry<Integer, Boolean> left = isSumTreeOptimized2(root.left);
        AbstractMap.SimpleEntry<Integer, Boolean> right = isSumTreeOptimized2(root.right);

        int sum = left.getKey() + right.getKey();
        boolean bool = (sum == root.value && left.getValue() && right.getValue());

        return new AbstractMap.SimpleEntry<>(sum + root.value, bool);
    }

}
