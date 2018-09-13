package leetcode_170_200;

import org.junit.Test;
import util.TreeNode;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _297 {

	public static void main(String[] args) {
		String[] array = "0,1;1,2;3,4;7,8;15,16;31,32;63,64;127,128;255,256;511,512;".split(";");

		System.out.println();
	}

	@Test
	public void test() {
		_297 demo = new _297();
		Integer[] values = {1,2,3,null,null,4,5};
		TreeNode root = TreeNode.createTree(values);
		String s = demo.serialize(root);
		System.out.println(s);

		TreeNode newRoot = demo.deserialize(s);

		System.out.println();
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		Queue<TreeNode> treeNodeQueue = new LinkedBlockingQueue<>();

		treeNodeQueue.add(root);
		int i = 0;

		StringBuilder sb = new StringBuilder();

		while (!treeNodeQueue.isEmpty()) {
			TreeNode node = treeNodeQueue.poll();
			sb.append(node.val);
			sb.append(",");

			if (node.left != null) {
				treeNodeQueue.add(node.left);
				sb.append(++i);
			} else {
				sb.append("-");
			}
			sb.append(",");
			if (node.right != null) {
				treeNodeQueue.add(node.right);
				sb.append(++i);
			} else {
				sb.append("-");
			}
			sb.append(";");
		}

		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0) {
			return null;
		}
		List<String> list = Stream.of(data.split(";")).collect(Collectors.toList());

		return getRoot(list, 0);
	}

	private TreeNode getRoot(List<String> list, int index) {
		if (index >= list.size()) {
			return null;
		}

		String[] data = list.get(index).split(",");
		int value = Integer.parseInt(data[0]);

		TreeNode root = new TreeNode(value);
		if (!data[1].equals("-")) {
			root.left = getRoot(list, Integer.parseInt(data[1]));
		}

		if (!data[2].equals("-")) {
			root.right = getRoot(list, Integer.parseInt(data[2]));
		}

		return root;
	}
}
