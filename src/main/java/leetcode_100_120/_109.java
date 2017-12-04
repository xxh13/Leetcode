package leetcode_100_120;

import util.ListNode;
import util.TreeNode;

import static util.TreeUtil.printTreeHierarchy;

public class _109 {

    public static void main(String[] args) {
        _109 demo = new _109();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;


        TreeNode root = demo.sortedListToBST(node1);
        printTreeHierarchy(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode p1 = head, p2 = head;
        ListNode pre1 = head;

        boolean first = true;

        while (p2 != null && p2.next != null) {
            if (first) {
                first = false;
            } else {
                pre1 = pre1.next;
            }

            p1 = p1.next;
            p2 = p2.next.next;
        }

        pre1.next = null;

        TreeNode node = new TreeNode(p1.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(p1.next);

        return node;
    }
}
