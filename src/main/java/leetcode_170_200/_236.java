package leetcode_170_200;

import org.junit.Test;
import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _236 {

	@Test
	public void test() {
		Integer[] values = {3,5,1,6,2,0,8,null,null,7,4};
		TreeNode root = TreeNode.createTree(values);

		_236 demo = new _236();
		TreeNode node = demo.lowestCommonAncestor(root, root.left.right, root.left.left);

		System.out.println(node.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<Integer, TreeNode> map = new HashMap<>();
		depthFirstTravel(root, map, null);

		List<TreeNode> pDescendants = getAllDescendant(p, map);
		List<TreeNode> qDescendants = getAllDescendant(q, map);

		TreeNode parent = null;

		for (int i = pDescendants.size() - 1, j = qDescendants.size() - 1; i>=0 && j >= 0; i--, j--) {
			if (pDescendants.get(i) == qDescendants.get(j)) {
				parent = pDescendants.get(i);
			} else {
				break;
			}
		}

		return parent;

	}

	private void depthFirstTravel(TreeNode node, Map<Integer, TreeNode> map, TreeNode parent) {
		// if the node is leaf node,
		if (node == null)
			return;

		map.put(node.val, parent);
		depthFirstTravel(node.left,  map, node);
		depthFirstTravel(node.right, map, node);
	}

	private List<TreeNode> getAllDescendant(TreeNode p, Map<Integer, TreeNode> map) {
		List<TreeNode> list = new ArrayList<>();
		TreeNode node = p;

		while (node != null) {
			list.add(node);
			node = map.get(node.val);
		}

		return list;
	}
}
