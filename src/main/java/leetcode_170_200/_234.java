package leetcode_170_200;

import org.junit.Test;
import util.ListNode;

public class _234 {

    @Test
    public void test() {
        int[] list = {1};
        ListNode head = ListNode.initList(list);
        assert isPalindrome(head);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            fast = reverseList(slow);
        } else {
            fast = reverseList(slow.next);
        }
        slow = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }


    private ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode next) {
        if (head == null) {
            return next;
        }
        ListNode nextNode = head.next;
        head.next = next;
        return reverseList(nextNode, head);
    }
}
