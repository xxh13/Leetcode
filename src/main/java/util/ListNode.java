package util;


public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }


    public static ListNode initList(int[] list) {
        ListNode[] nodeLists = new ListNode[list.length];

        for (int i = 0; i < list.length; i++) {
            nodeLists[i] = new ListNode(list[i]);
            if (i != 0) {
                nodeLists[i -1].next = nodeLists[i];
            }
        }

        return nodeLists[0];
    }


    public static void printList(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

}
