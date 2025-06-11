package Tree;

/*
* https://www.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
* */

public class IdenticalTrees {

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.getTree();
        TreeNode tree2 = TreeNode.getTree();
        System.out.println(identicalTrees(tree1, tree2));
    }

    private static boolean identicalTrees(TreeNode tree1, TreeNode tree2) {

        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        boolean root = tree1.value == tree2.value;
        boolean left = identicalTrees(tree1.left, tree2.left);
        boolean right = identicalTrees(tree1.right, tree2.right);

        return left && right && root;
    }

}
