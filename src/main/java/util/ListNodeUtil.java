package util;

public class ListNodeUtil {

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
