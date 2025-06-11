package Tree;

import java.util.ArrayList;
import java.util.List;

/*
* https://www.naukri.com/code360/problems/path-in-a-tree_3843990
* */

public class PathToNode {

    public static List<Integer> pathToNode(TreeNode root, int x) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        getPath(root, x, list);
        return list;

    }



    public static boolean getPath(TreeNode root, int target, List<Integer> list) {

        if (root == null) {
            return false;
        }

        list.add(root.value);

        if (root.value == target) {
            return true;
        }

        boolean left = getPath(root.left, target, list);
        boolean right = getPath(root.right, target, list);

        if (left || right) {
            return true;
        }

        list.removeLast();
        return false;
    }

}
