package leetcode_80_100;

import javax.xml.parsers.FactoryConfigurationError;
import java.util.List;

/**
 *
 * Created by XXH on 2017/9/5.
 */
public class _92 {

    public static void main(String[] args) {
        _92 demo = new _92();

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

        demo.printList(demo.reverseBetween(node1, 1, 2));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = pre.next;
        ListNode temp_pre = pre;
        ListNode temp_cur = cur;
        int i = 0;
        while (cur != null) {
            // recode the position where list reverse start
            if (i == m - 1) {
                temp_pre = pre;
                temp_cur = cur;
            }
            while (i >= m && i < n) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                i++;
            }
            // record the position where list reverse end
            if (i == n) {
                temp_pre.next = pre;
                temp_cur.next = cur;
            }
            if (cur == null)
                break;
            pre = cur;
            cur = pre.next;
            i++;
        }
        return newHead.next;
    }

    private void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
