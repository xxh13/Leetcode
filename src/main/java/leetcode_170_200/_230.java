package leetcode_170_200;

import util.TreeNode;

public class _230 {

	public int kthSmallest(TreeNode root, int k) {
		int count = getCount(root.left);

		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1){
			return kthSmallest(root.right, k - count - 1);
		}

		return root.val;
	}

	public int getCount(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getCount(root.left) + getCount(root.right) + 1;
	}
}
