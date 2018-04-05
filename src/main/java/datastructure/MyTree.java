package datastructure;

import util.TreeNode;

public class MyTree {

    public static void main(String[] args) {
        MyTree demo = new MyTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = demo.reConstructBinaryTree(pre, in);
        System.out.println();
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int x1, int y1, int[] in, int x2, int y2) {
        if (x1 > y1) return null;
        if (x1 == y1) return new TreeNode(pre[x1]);
        int pivot = getPivot(pre[x1], in);
        TreeNode root = new TreeNode(pre[x1]);
        root.left = reConstructBinaryTree(pre, x1 + 1, x1 + pivot - x2, in, x2, pivot - 1);
        root.right = reConstructBinaryTree(pre, x1 + pivot - x2 + 1, y1, in, pivot + 1, y2);

        return root;
    }

    public int getPivot(int ele, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == ele) {
                return i;
            }
        }

        return -1;
    }
}
