package leetcode_80_100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * tree travel
 * Created by XXH on 2017/9/6.
 */
public class TreeTravel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeTravel t = new TreeTravel();
        t.preTraversal(root).forEach(System.out::println);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    // using recursive
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if ( root !=  null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
    }

    // using iteration
    public List<Integer> preTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        TreeNode node = root.left;

        while (!s.empty() || node != null) {
            while (node != null) {
                s.add(node);
                node = node.left;
            }
            node = s.pop();
            list.add(node.val);
            node = node.right;
        }

        return list;
    }
}
