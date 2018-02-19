package leetcode_100_120;

import util.TreeNode;


public class _113 {

    public static void main(String[] args) {
        _113 demo = new _113();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(14);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node5.left = node9;
        demo.postOrder(root);
    }

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    public TreeNode flatten(TreeNode root, TreeNode next) {
        if (root == null) return next;
        next = flatten(root.right, next);
        next = flatten(root.left, next);
        root.right = next;
        root.left = null;
        next = root;
        return next;
    }


    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
