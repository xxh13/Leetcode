package leetcode_100_120;

/**
 *
 * Created by XXH on 2017/9/18.
 */
public class _105 {

    public static void main(String[] args) {
        _105 demo = new _105();
        int[] preorder = {1,4,2,3,5};
        int[] inorder = {1,2,3,4,5};
        TreeNode root = demo.buildTree(preorder, inorder);
        System.out.println(root.val);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        TreeNode node = new TreeNode(preorder[0]);
        int index = findIndex(inorder, preorder[0]);
        int[] left_inorder = new int[index];
        int[] right_inorder = new int[inorder.length - index - 1];
        int[] left_preorder = new int[index];
        int[] right_preorder = new int[preorder.length - index - 1];
        System.arraycopy(inorder, 0, left_inorder, 0, left_inorder.length);
        System.arraycopy(inorder, index + 1, right_inorder, 0, right_inorder.length);
        System.arraycopy(preorder, 1, left_preorder, 0, left_preorder.length);
        System.arraycopy(preorder, left_preorder.length + 1, right_preorder, 0, right_preorder.length);

        node.left = buildTree(left_preorder, left_inorder);
        node.right = buildTree(right_preorder, right_inorder);
        return node;
    }

    private int findIndex(int[] list, int element) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == element) return i;
        }
        return -1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
