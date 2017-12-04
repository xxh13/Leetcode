package leetcode_100_120;

import static util.TreeUtil.printTreeHierarchy;
import util.TreeNode;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
the two subtrees of every node never differ by more than 1.
*/

public class _108 {

    public static void main(String[] args) {
        _108 demo = new _108();
        int[] nums = {-10};
        TreeNode node = demo.sortedArrayToBST(nums);
        printTreeHierarchy(node);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * @param nums : array
     * @param l : left index (include)
     * @param r : right index (include)
     * @return : TreeNode
     */
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);

        return node;
    }
}
