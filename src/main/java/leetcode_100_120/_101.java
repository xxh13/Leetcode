package leetcode_100_120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Created by XXH on 2017/9/18.
 */
public class _101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;

        _101 demo = new _101();
        System.out.println(demo.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            stack.add(root);
            list.add(root);
        } else {
            return true;
        }

        while (!stack.empty()) {
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                list.add(node);
            }
            for (TreeNode tn : list) {
                if (tn != null) {
                    stack.add(tn.left);
                    stack.add(tn.right);
                }
            }
            while (!list.isEmpty() && list.size() > 1) {
                TreeNode node1 = list.remove(0);
                TreeNode node2 = list.remove(list.size() - 1);
                if (node1 == null && node2 == null) {}
                else if (node1 == null || node2 == null) return false;
                else {
                    if (node1.val != node2.val) return false;
                }
            }
        }
        return true;
    }


    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
