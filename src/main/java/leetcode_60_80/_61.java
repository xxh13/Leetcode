package leetcode_60_80;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * Created by john on 2017/3/10.
 */
public class _61 {

    public static void main(String[] args) {
        _61 demo = new _61();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        demo.print(demo.rotateRight(node1, 6));
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int i = 0, length = getLength(head);

        if (length == 0) return head;

        k = k % (length) ;
        k = length - 1 - k;
        while (i < k) {
            if (p == null)
                return head;
            p = p.next;
            i++;
        }
        if (p == null || p.next == null) {
            return head;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;

        return newHead;
    }

    private int getLength(ListNode head) {
        int i = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

    public void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

      /*
       * Definition for singly-linked list.
       */
    static private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
