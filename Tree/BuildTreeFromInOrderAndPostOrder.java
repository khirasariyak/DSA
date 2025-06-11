package Tree;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
* */

public class BuildTreeFromInOrderAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.value);
        int numsLeft = rootIndex - inStart;

        root.left = buildTree(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + numsLeft - 1, map);

        root.right = buildTree(inorder, rootIndex + 1, inEnd,
                postorder, postStart + numsLeft, postEnd - 1, map);

        return root;
    }

}
