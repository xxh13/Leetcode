package leetcode_20_40;


import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list
 * Created by XXH on 2017/2/16.
 */
public class _23 {

    public static void main(String[] args) {
        _23 demo = new _23();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        ListNode[] lists = {node1, node2, node3, node4};
        ListNode node = demo.mergeKLists(lists);
        demo.printList(node);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int left = 0, right = lists.length - 1;
        return mergeLists(lists, left, right);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int middle = (left + right) / 2;
        ListNode nodeLeft = mergeLists(lists, left, middle);
        ListNode nodeRight = mergeLists(lists, middle + 1, right);

        return mergeTwoLists(nodeLeft, nodeRight);
    }

    //method1
    private ListNode mergeList1(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int i = 0, length = lists.length;
        while (i < length - 1) {
            lists[i+1] = mergeTwoLists(lists[i], lists[i + 1]);
            i++;
        }
        return lists[lists.length - 1];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    private void printList(ListNode node) {
        ListNode p = node;
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
