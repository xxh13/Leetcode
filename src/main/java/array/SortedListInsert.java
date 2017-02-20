package array;

/**
 * num : 147
 * Sort a linked list using insertion sort.
 * Created by XXH on 2016/8/20.
 */
public class SortedListInsert {


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = head.next;
        ListNode pre = head;
        while(node != null){
            //insert into the head of the linked list
            if(head.val > node.val){
                pre.next = node.next;
                node.next = head;
                head = node;

                node = pre.next;
            }else{
                ListNode p = head;
                ListNode n = head.next;
                while(n.next != null && n!=node && n.val <= node.val){
                    p = p.next;
                    n = n.next;
                }
                if(n != node && n.val != node.val){
                    pre.next = node.next;
                    node.next = n;
                    p.next = node;

                    node = pre.next;
                }else{
                    pre = pre.next;
                    node = pre.next;
                }
            }
        }

        return head;
    }

    static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }
}
