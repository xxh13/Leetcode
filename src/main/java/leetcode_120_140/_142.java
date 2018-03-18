package leetcode_120_140;

import util.ListNode;

public class _142 {

    public static void test() {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;

            //meet in a circle
            if (slow == fast) {
                break;
            }
        }

        if (slow == null || fast == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
