package leetcode_170_200;

import org.junit.Test;
import util.ListNode;

public class _206 {

    @Test
    public void test() {
        int[] values = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.initList(values);

        ListNode.printList(reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        head.next = null;

        return newHead;
    }
}
