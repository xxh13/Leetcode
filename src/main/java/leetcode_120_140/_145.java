package leetcode_120_140;

import org.junit.Test;
import util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145 {

	@Test
	public void test() {
		Integer[] values = {1, 2, 3, null, 4};
		postorderTraversal(TreeNode.createTree(values)).forEach(System.out::println);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<PostTreeNode> stack = new Stack<>();
		List<Integer> list = new LinkedList<>();

		if (root == null) {
			return list;
		}

		stack.push(new PostTreeNode(root, 1));

		while (!stack.isEmpty()) {
			PostTreeNode node = stack.peek();
			if (node.count == 3) {
				list.add(node.treeNode.val);
				stack.pop();
			} else {
				TreeNode left = node.treeNode.left;
				if (node.count == 1) {
					if (left != null) {
						stack.push(new PostTreeNode(left, 1));
					}
				}
				if (node.count == 2) {
					TreeNode right = node.treeNode.right;
					if (right != null) {
						stack.push(new PostTreeNode(right, 1));
					}
				}
				node.count++;
			}

		}
		return list;
	}


	private static class PostTreeNode {
		int count; //记录出入栈的次数
		TreeNode treeNode;

		public PostTreeNode(TreeNode treeNode, int count) {
			this.treeNode = treeNode;
			this.count = count;
		}
	}
}
