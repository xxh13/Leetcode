package leetcode_170_200;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(15);
//        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
//        TreeNode node5 = new TreeNode(12);
//        TreeNode node6 = new TreeNode(17);
//        TreeNode node7 = new TreeNode(16);
        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        node6.left = node7;

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    private List<TreeNode> path = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            path.add(0, p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = path.remove(0);

        //如果是右节点，将右节点的所有做节点加入路径
        TreeNode rightNode = current.right;
        while (rightNode != null) {
            path.add(0, rightNode);
            rightNode = rightNode.left;
        }

        return current.val;
    }

}
