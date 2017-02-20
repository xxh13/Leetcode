package leetcode_20_40;

/**
 * Merge Two Sorted Lists
 * Created by XXH on 2017/2/14.
 */
public class _21 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(13);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(9);

//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;

//        l5.next = l6;
//        l6.next = l7;

        _21 demo = new _21();
        demo.printList(demo.mergeTwoLists(l1, l5));

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p = new ListNode(0), head = p;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        //if list1 has remaining
        if (l1 != null) {
            p.next = l1;
        }
        //if list2 has remaining
        else {
            p.next = l2;
        }

        return head.next;
    }

    private void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
