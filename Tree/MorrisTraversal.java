package Tree;

public class MorrisTraversal {

    public void morrisInorder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // No left child, visit this node and move right
                System.out.print(current.value + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Make a temporary thread to the current node
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Thread already exists, remove it and visit current
                    predecessor.right = null;
                    System.out.print(current.value + " ");
                    current = current.right;
                }
            }
        }
    }
}
