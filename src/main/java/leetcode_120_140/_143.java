package leetcode_120_140;

import util.ListNode;

public class _143 {

    public static void main(String[] args) {
        _143 demo = new _143();
        int[] list = {1, 2};
        ListNode head = ListNode.initList(list);

        demo.reorderList1(head);

        ListNode.printList(head);
    }



    /**
     * O(n2)
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = cur;
            ListNode temp = cur.next;
            if (temp == null) break;
            while (temp.next != null) {
                pre = pre.next;
                temp = pre.next;
            }
            pre.next = null;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;

        }
    }

    public void reorderList1(ListNode head) {
        if (head == null) return;
        ListNode fast = head, slow = head;
        while (slow.next != null && slow.next.next != null) {
            fast = fast.next;
            slow = slow.next;
            slow = slow.next;
        }
        //now fast is in the middle, we seperate the list in the middle position
        ListNode head2 = fast.next;
        if (head2 == null) {
            return;
        }
        ListNode temp1 = head2.next;
        fast.next = null;

        head2.next = null;
        if (temp1 != null) {
            ListNode temp2 = temp1.next;
            while (temp1 != null) {
                temp1.next = head2;
                head2 = temp1;
                temp1 = temp2;
                if (temp1 == null) {
                    break;
                }
                temp2 = temp2.next;
            }
        }

        ListNode next1 = head.next, next2 = head2.next;
        fast = head;
        slow = head2;
        while (slow != null && fast != null) {
            slow.next = fast.next;
            fast.next = slow;
            fast = next1;
            slow = next2;
            if (next1 == null) {
                break;
            }
            next1 = next1.next;
            if (next2 == null) {
                break;
            }
            next2 = next2.next;
        }
    }
}
