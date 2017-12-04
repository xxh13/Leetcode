package util;


import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    // print the tree node in hierarchy order
    public static void printTreeHierarchy(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode tn = queue.remove();
            if (tn == null) {
                System.out.println("null");
            }
            else {
                System.out.println(tn.val);
                queue.add(tn.left);
                queue.add(tn.right);
            }
        }
    }
}
