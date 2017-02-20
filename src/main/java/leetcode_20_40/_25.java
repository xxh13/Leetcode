package leetcode_20_40;

import util.ListNode;

import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * Created by XXH on 2017/2/17.
 */
public class _25 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        _25 demo = new _25();
        demo.printList(demo.reverseKGroup(node1, 3));
    }

    public void printList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode begin = dummyNode;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return dummyNode.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = pre.next;

        //in case k is bigger than the length of list
        int count = 0;
        while (count < k - 1) {
            if (cur == null) {
                break;
            }
            count++;
            cur = cur.next;
        }

        while (cur != null) {

            cur = pre.next;
            //reverse every k nodes
            for (int i = 0; i < k - 1; i++) {
                ListNode node = pre;
                for (int j = 0; j < k - 1 - i; j++) {
                    pre.next = cur.next;
                    cur.next = cur.next.next;
                    pre.next.next = cur;

                    pre = pre.next;
                    cur = pre.next;
                }
                pre = node;
                cur = pre.next;
            }

            count = 0;
            while (count < k) {
                count++;
                pre = pre.next;
            }

            cur = pre.next;

            //test if the list has enough nodes left and move the pre point
            count = 0;
            while (count < k - 1) {
                if (cur == null) {
                    break;
                }
                count++;
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }
    */

    static private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
