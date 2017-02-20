package leetcode_1_20;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Created by XXH on 2017/1/20.
 */
public class _19 {

    public static void main(String[] args) {
        _19 demo = new _19();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        demo.removeNthFromEnd(node1, 2);
        demo.printList(node1);
    }

    private void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
         int i = 0;
         ListNode p1 = head, p2 = head;

         while (i < n) {
             p2 = p2.next;
             i++;
         }

         if (p2 == null) return head.next;

         while (p2.next != null) {
             p2 = p2.next;
             p1 = p1.next;
         }

         p1.next = p1.next.next;

         return head;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
