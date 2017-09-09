package leetcode_80_100;


public class _82 {

    public static void main(String[] args) {
        _82 demo = new _82();
        demo.printList(demo.deleteDuplicates(demo.createList()));
    }

    public ListNode createList() {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

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

        ListNode pre = head;
        ListNode cur = head.next;

        boolean hasDuplicates = false;
        boolean hasDuplicatesAtHead = false;

        while (cur != null) {
            hasDuplicatesAtHead = false;
            hasDuplicates = false;

            while (cur != null && pre.val == cur.val) {
                pre = cur;
                cur = pre.next;
                hasDuplicatesAtHead = true;
            }
            if (cur == null) return null;
            if (hasDuplicatesAtHead) {
                head = cur;
                pre = head;
                cur = pre.next;
            }else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                    hasDuplicates = true;
                }

                if (hasDuplicates) {
                    pre.next = cur.next;
                    cur = pre.next;
                } else {
                    pre = pre.next;
                    cur = pre.next;
                }
            }
        }

        return head;
    }


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
    }
}
