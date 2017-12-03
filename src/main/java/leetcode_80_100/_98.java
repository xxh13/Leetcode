package leetcode_80_100;

import java.util.Stack;

public class _98{

    public static void main(String[] args) {
        _98 demo = new _98();
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        TreeNode node = root.left;

        long min = Long.MIN_VALUE;

        while (!s.empty() || node != null) {
            while (node != null) {
                s.add(node);
                node = node.left;
            }
            node = s.pop();
            if (node.val > min) {
                min = node.val;
            } else {
                return false;
            }
            node = node.right;
        }
        return true;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}