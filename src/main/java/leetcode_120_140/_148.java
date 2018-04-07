package leetcode_120_140;

import util.ListNode;

public class _148 {

    public static void main(String[] args) {
        int[] values = {};
        ListNode head = ListNode.initList(values);
        _148 demo = new _148();

        ListNode node = demo.sortList(head);

        ListNode.printList(node);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode h1 =sortList(head);
        ListNode h2 = sortList(slow);
        return merge(h1, h2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        p = head.next;
        head.next = null;
        return p;
    }
}
