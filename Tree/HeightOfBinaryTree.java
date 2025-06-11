package Tree;

/*
* https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
* */

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(height(root));
    }

    static int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh, rh);
    }

}
