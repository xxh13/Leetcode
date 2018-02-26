package util;

public class TreeLinkNode {

    int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int x) { val = x; }


    public static TreeLinkNode builder(String[] array) {
        if (array.length == 0) return null;
        TreeLinkNode[] nodes = new TreeLinkNode[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("#")) {
                nodes[i] = new TreeLinkNode(Integer.parseInt(array[i]));

                // has right node
                if (i * 2 + 2 < array.length) {
                    nodes[i].right = nodes[i * 2 + 2];
                }
                if (i * 2 + 1 < array.length) {
                    nodes[i].left = nodes[i * 2 + 1];
                }
            } else {
                nodes[i] = null;

            }
        }
        return nodes[0];
    }
}
