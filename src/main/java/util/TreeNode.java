package util;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) { this.val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] values) {
    	TreeNode[] nodes = new TreeNode[values.length];
		for (int i = values.length - 1; i >= 0; i--) {
			if (values[i] != null) {
				nodes[i] = new TreeNode(values[i]);
				if (i * 2 + 1 < values.length) {
					nodes[i].left = nodes[i * 2 + 1];
				}

				if (i * 2 + 2 < values.length) {
					nodes[i].right = nodes[i * 2 + 2];
				}
			} else {
				nodes[i] = null;
			}
		}

		return nodes[0];
    }

}
