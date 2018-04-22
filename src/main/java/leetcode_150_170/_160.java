package leetcode_150_170;

import util.ListNode;


public class _160 {

    /*
     solution1 : https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
     */

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    /**
     * solution2:
     * align the two linked list by the end
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode a = headA, b = headB;

        while (lengthA > lengthB) {
            a = a.next;
            lengthA --;
        }

        while (lengthB > lengthA) {
            b = b.next;
            lengthB --;
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;
    }

    private int getLength(ListNode listNode) {
        int length = 0;
        ListNode p = listNode;
        while (p != null) {
            length++;
            p = p.next;
        }

        return length;
    }
}
