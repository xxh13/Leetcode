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
    	if (values.length == 0) {
    		return null;
	    }
    	return getRoot(values, 0);
    }

	private static TreeNode getRoot(Integer[] values, int i) {
    	if (i >= values.length || values[i] == null) {
    		return null;
	    }

	    TreeNode root = new TreeNode(values[i]);
    	root.left = getRoot(values, i * 2 + 1);
    	root.right = getRoot(values, i * 2 + 2);

    	return root;
	}

}
