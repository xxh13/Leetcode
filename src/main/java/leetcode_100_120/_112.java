package leetcode_100_120;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*
Given a binary tree and a sum,
determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
*/

public class _112 {

    public static void main(String[] args) {
        _112 demo = new _112();
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
        demo.pathSum(root, 27).forEach(System.out::println);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumSub(root, sum);
    }

    private boolean hasPathSumSub(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.right == null && root.left == null && root.val == sum) return true;

        return hasPathSumSub(root.left, sum - root.val)
                || hasPathSumSub(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        pathSumSub(root, sum, paths, path);

        return paths;
    }

    private void pathSumSub(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.right == null && root.left == null && root.val == sum) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        pathSumSub(root.left, sum - root.val, paths, path);

        pathSumSub(root.right, sum - root.val, paths, path);
        path.remove(path.size() - 1);
    }
}
