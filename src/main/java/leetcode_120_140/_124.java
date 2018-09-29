package leetcode_120_140;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _124 {

	@Test
	public void test() {
		Integer[] values = {-10,9,20,null,null,15,7};
		TreeNode root = TreeNode.createTree(values);
		System.out.println(maxPathSum(root));
	}

	public int maxPathSum(TreeNode root) {
		int max = Integer.MIN_VALUE;

		List<TreeNode> treeNodes = new ArrayList<>();
		treeNodes.add(root);

		while (!treeNodes.isEmpty()) {
			TreeNode node = treeNodes.remove(0);
			if (node != null) {
				int subMax = node.val;
				if (node.left != null) {
					treeNodes.add(node.left);
					int leftMax = maxSubPathSum(node.left, 0, 0);
					subMax += (leftMax > 0 ? leftMax : 0);
				}
				if (node.right != null) {
					treeNodes.add(node.right);
					int rightMax = maxSubPathSum(node.right, 0, 0);
					subMax += (rightMax > 0 ? rightMax : 0);
				}
				max = Math.max(subMax, max);
			}
		}

		return max;
	}

	private int maxSubPathSum(TreeNode root, int max, int sum) {
		if (root == null) return max;

		sum += root.val;
		max = Math.max(max, sum);

		int leftMax = maxSubPathSum(root.left, max, sum);
		int rightMax = maxSubPathSum(root.right, max, sum);

		return Math.max(leftMax, rightMax);
	}
}
