package Tree;

/*
* https://www.naukri.com/code360/problems/childrensumproperty_790723
* */

public class ChildrenSumProperty {

    void changeTree(TreeNode root) {

        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child += root.left.value;
        }

        if (root.right != null) {
            child += root.right.value;
        }

        if (child >= root.value) {
            root.value = child;
        } else {
            // here we only want to update only one child
            if (root.left != null) {
                root.left.value = root.value;
            } else if (root.right != null) {
                root.right.value = root.value;
            }

        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if (root.left != null) {
            total += root.left.value;
        }

        if (root.right != null) {
            total += root.right.value;
        }

        if (root.left != null || root.right != null) {
            root.value = total;
        }

    }

}
