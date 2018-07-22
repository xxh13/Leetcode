package leetcode_170_200;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _199 {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add(null);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            if (node != null) {
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);

                if (nodes.get(0) == null) {
                    result.add(node.val);
                    nodes.add(null);
                }
            }

        }


        return result;
    }


}
