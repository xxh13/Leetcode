package baidu;


import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个节点，找出节点的前节点
 */
public class PreTreeNode {


	/**
	 * 找出二叉树中序遍历的前一个节点
	 * @param node
	 * @return
	 */
	public static TreeNode findInorderPreNode(TreeNode node) {

		//if the node is leaf node
		if (node.left == null && node.right == null) {
			if (!node.isLeft) {
				return node.parent;
			} else {
				TreeNode tn = node;
				while (tn != null && !tn.isLeft) {
					tn = tn.parent;
				}
				return tn;
			}
		} else {
			if (node.isLeft) {
				TreeNode tn = node;
				if (tn.left != null) {
					return tn.left;
				}
				while (tn != null && tn.isLeft) {
					tn = tn.parent;
				}
				return tn;
			} else {
				if (node.parent.left == null) {
					return node.parent;
				}
				List<TreeNode> list = new LinkedList<>();
				inorder(node.parent.left, list);
				return list.get(list.size() - 1);
			}
		}
	}

	private static void inorder(TreeNode root, List<TreeNode> list) {
		if (root == null) return;
		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		boolean isLeft;

		public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent, boolean isLeft) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.isLeft = isLeft;
		}
	}
}
