package Tree;

/*
* https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
* */

public class DiameterOfBinaryTree {

    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(diameterBruteForce(root));
        diameter(root);
        System.out.println(diameter);
    }

    static void diameter(TreeNode root) {
        height(root);
    }

    static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    static int diameterBruteForce(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = diameterBruteForce(root.left);
        int right = diameterBruteForce(root.right);

        int diameter = height(root.left) + height(root.right) + 1;
        return Math.max(diameter, Math.max(left, right));
    }

}
