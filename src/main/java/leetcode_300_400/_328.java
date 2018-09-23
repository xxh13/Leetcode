package leetcode_300_400;

import org.junit.Test;
import util.ListNode;

public class _328 {


	@Test
	public void test() {
		int[] values = {1, 2, 3};
		ListNode head = ListNode.initList(values);
		head = oddEvenList(head);
		ListNode.printList(head);
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode even = head.next, odd = head.next.next;
		ListNode evenHead = head.next;

		while (even != null && odd != null) {
			cur.next = odd;
			even.next = odd.next;
			odd.next = evenHead;

			cur = cur.next;

			even = even.next;
			if (even == null) break;
			odd = even.next;
		}

		return head;
	}
}
