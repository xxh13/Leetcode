package leetcode_300_400;

import org.junit.Test;
import util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class _337 {

	@Test
	public void test() {
		Integer[] values = {3,1};
		TreeNode root = TreeNode.createTree(values);
		System.out.println(rob(root));
	}

	public int rob(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		int value1 = rob(root, false, map);
		int value2 = rob(root, true, map);
		return Math.max(value1, value2);
	}


	/**
	 *
	 * @param root
	 * @param rob: 当前节点的parent节点是否被抢劫
	 * @return
	 */
	public int rob(TreeNode root, boolean rob, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}

		// parent被抢劫了
		if (rob) {
			return rob(root.left, false, map) + rob(root.right, false, map);
		}
		// 如果parent没有被抢劫
		else {
			if (map.containsKey(root)) {
				return map.get(root);
			}
			int value1 = rob(root.left, false, map) + rob(root.right, false, map);           //不抢劫当前节点
			int value2 = rob(root.left, true, map) + rob(root.right, true, map) + root.val;  //抢劫当前节点
			map.put(root, Math.max(value1, value2));
			return Math.max(value1, value2);
		}
	}
}
