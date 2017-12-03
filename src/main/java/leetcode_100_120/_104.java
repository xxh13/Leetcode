package leetcode_100_120;

/**
 * Given a binary tree, find its maximum depth.
 * Created by XXH on 2017/9/18.
 */
public class _104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
