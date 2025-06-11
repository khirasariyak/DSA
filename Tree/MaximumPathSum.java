package Tree;

/*
* https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
* */

public class MaximumPathSum {

    int findMaxSum(TreeNode node) {

        int[] max = {Integer.MIN_VALUE};
        findMaxSum(node, max);

        return max[0];
    }

    int findMaxSum(TreeNode node, int[] max) {

        if (node == null) {
            return 0;
        }

        int left = findMaxSum(node.left, max);
        int right = findMaxSum(node.right, max);

        if (left < 0) {
            left = 0;
        }

        if(right < 0) {
            right = 0;
        }

        max[0] = Math.max(max[0], left + right + node.value);

        return Math.max(left, right) + node.value;
    }

}
