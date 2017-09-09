package leetcode_80_100;

public class _83 {

    public static void main(String[] args) {
        _83 demo = new _83();
        demo.printList(demo.deleteDuplicates(demo.createList()));
    }

    public ListNode createList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        return node1;
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;

        while (cur != null) {

            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }

            cur = cur.next;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        ListNode(ListNode next) {
            this.next = next;
        }
    }
}
