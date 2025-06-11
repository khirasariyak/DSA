package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {

    List<Integer> boundaryTraversal(TreeNode root) {
        // code here

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (!isLeaf(root)) {
            list.add(root.value);
        }

        addLeftBoundary(root, list);
        addLeafNodes(root, list);
        addRightBoundary(root, list);

        return list;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addRightBoundary(TreeNode root, List<Integer> list) {
        TreeNode current = root.right;

        List<Integer> temp = new ArrayList<>();

        while (current != null) {

            if (!isLeaf(current)) {
                temp.add(current.value);
            }

            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }

        }

        Collections.reverse(temp);
        list.addAll(temp);
    }

    private void addLeafNodes(TreeNode root, List<Integer> list) {

        if (isLeaf(root)) {
            list.add(root.value);
            return;
        }

        if (root.left != null) {
            addLeafNodes(root.left, list);
        }

        if (root.right != null) {
            addLeafNodes(root.right, list);
        }

    }

    private void addLeftBoundary(TreeNode root, List<Integer> list) {
        TreeNode current = root.left;

        while (current != null) {

            if (!isLeaf(current)) {
                list.add(current.value);
            }

            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

    }

}
