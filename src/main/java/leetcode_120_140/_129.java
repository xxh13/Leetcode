package leetcode_120_140;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _129 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        _129 demo = new _129();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
//        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(demo.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path(root, paths, path);
        paths.forEach(System.out::println);
        int sum = 0;
        for (String s : paths) {
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    private int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }

    private void path(TreeNode root, List<String> paths, StringBuilder path) {
        if (root == null) return;
        //when comes the leaf
        path.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }

        path(root.left, paths, path);
        path(root.right, paths, path);
        path.deleteCharAt(path.length() - 1);
    }
}
