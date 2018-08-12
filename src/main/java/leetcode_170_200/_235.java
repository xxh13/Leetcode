package leetcode_170_200;

import org.junit.Test;
import util.TreeNode;


/**
 * Lowest Common Ancestor of a Binary Search Tree
 */
public class _235 {

	@Test
	public void test() {
		Integer[] values = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root = TreeNode.createTree(values);
		System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// if the p is on the left(right) while q is on the right(left)
		if (((root.val - p.val) * (root.val - q.val) <= 0)) {
			return root;
		}
		// p and q are both on the left side
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return lowestCommonAncestor(root.left, p, q);
	}
}
