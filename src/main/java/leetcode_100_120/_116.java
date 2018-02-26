package leetcode_100_120;

import util.TreeLinkNode;

public class _116 {

    public static void main(String[] args) {
        String[] array = {"2", "1", "3", "0", "7", "9", "1", "2"};
        TreeLinkNode root = TreeLinkNode.builder(array);

        _116 demo = new _116();
        demo.connect2(root);

         System.out.println();
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }


        connect(root.left);
        connect(root.right);
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode treeLinkNode = root;

        while (treeLinkNode != null) {
            boolean hasChild = false;
            TreeLinkNode node = treeLinkNode;
            treeLinkNode = null;

            TreeLinkNode pre = null;
            while (node != null) {
                if (node.left != null) {
                    if (!hasChild) {
                        hasChild = true;
                        treeLinkNode = node.left;
                    }
                    if (pre != null) {
                        pre.next = node.left;
                    }
                    pre = node.left;
                }

                if (node.right != null) {
                    if (!hasChild) {
                        hasChild = true;
                        treeLinkNode = node.right;
                    }
                    if (pre != null) {
                        pre.next = node.right;
                    }
                    pre =  node.right;
                }

                node = node.next;
            }
        }

    }

}
