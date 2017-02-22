package leetcode_01_20;

import util.ListNode;

/**
 * Add Two Numbers
 * Created by XXH on 2017/1/9.
 */
public class _2 {

    public static void main(String[] args) {
        _2 demo = new _2();
        ListNode node1 = new ListNode(9);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = demo.addTwoNumbers(node1, node4);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = result;

        int value = 0;
        int carry = 0;

        while (l1 != null && l2 != null) {
            value = (carry + l1.val + l2.val) % 10;
            carry = (carry + l1.val + l2.val) / 10;
            result.next = new ListNode(value);
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        while (l1 != null) {
            value = (carry + l1.val) % 10;
            carry = (carry + l1.val) / 10;
            l1.val = value;
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }

        while (l2 != null) {
            value = (carry + l2.val) % 10;
            carry = (carry + l2.val) / 10;
            l2.val = value;
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        return p.next;
    }
}
