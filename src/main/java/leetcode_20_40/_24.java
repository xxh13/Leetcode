package leetcode_20_40;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Created by XXH on 2017/2/16.
 */
public class _24 {

    public static void main(String[] args) {
        _24 demo = new _24();
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
//        demo.printList(node1);
        demo.printList(demo.swapPairs(node1));
    }

    public ListNode swapPairs(ListNode head) {
        // the list has only one node or it is just an empty list
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode pre = dummyNode, cur = pre.next;

        while (cur != null && cur.next != null) {        //when only one node left, we do not handle
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;

            pre = pre.next.next;
            cur = pre.next;
        }

        return dummyNode.next;
    }

    public void printList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    static private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
