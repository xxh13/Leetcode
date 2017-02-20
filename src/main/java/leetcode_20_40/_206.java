package leetcode_20_40;

/**
 * reverse Linked List
 * Created by XXH on 2017/2/17.
 */
public class _206 {

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

        _206 demo = new _206();
        demo.printList(demo.reverseList1(node1));
    }

    public void printList(ListNode head) {
        ListNode p = head;

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    //iterative
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }

    static private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
