package leetcode_80_100;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come
 * before nodes greater than or equal to x.

 * You should preserve the original relative order of the nodes in each of the two partitions.

   For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.
 * Created by XXH on 2017/9/2.
 */
public class _86 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        _86 demo = new _86();
//        demo.printList(node1);
        demo.printList(demo.partition(node1, 4));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode h1 = new ListNode(x - 1);
        h1.next = head;
        ListNode p1 = h1.next;
        ListNode pre = h1;
        ListNode h2 = new ListNode(x - 1);
        ListNode p2 = h2;

        while (p1 != null) {
            while (p1 != null && p1.val >= x){
                p2.next = p1;
                p2 = p2.next;
                p1 = p1.next;
            }
            if (p1 != null) {
                pre.next = p1;
                pre = p1;
                p1 = pre.next;
            }
        }
        p2.next = null;
        pre.next = h2.next;
        return h1.next;
    }

    private void printList(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            printList(head.next);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
