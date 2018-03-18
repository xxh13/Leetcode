package leetcode_120_140;
import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _141 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node1;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        _141 demo = new _141();
        System.out.println(demo.hasCycle2(node1));
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return false;
            } else {
                set.add(cur);
            }

            cur = cur.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;

        while (slow != null && fast != null) {
            if (slow == fast) return true;

            slow = slow.next;
            if (fast.next == null) return false;
            fast = fast.next.next;
        }

        return true;
    }


    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
