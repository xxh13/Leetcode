package leetcode_170_200;

import org.junit.Test;
import util.TreeNode;

public class _222 {

	@Test
	public void test() {
		Integer[] values = {1, 2, 3, 4, 5, 6};
		TreeNode root = TreeNode.createTree(values);
		assert countNodes(root) == 6;
	}

	public int countNodes(TreeNode root) {
		int nodes = 0, h = height(root);
		TreeNode node = root;
		while (h > -1) {
			if (height(node.right) == h - 1) {
				nodes += (1 << h);
				node = node.right;
			} else {
				nodes += (1 << h -1);
				node = node.left;
			}
			h--;
		}

		return nodes;
	}

	private  int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}
}
