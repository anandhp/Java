package com.doordie.linkedlists;

public class ReverseList {

	//Recursive solution
	public static ListNode reverseListRec(ListNode head) {
		if (head.next == null)
			return head;

		//reverse the rest and assign the current node at the end
		ListNode rest = head.next;
		ListNode newHead = reverseListRec(rest);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	//Iterative reverse using three pointers
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	//Tester
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6};
		ListNode head = LinkedList.buildList(A);
		LinkedList.print(head);
		head = ReverseList.reverseListRec(head);
		LinkedList.print(head);
	}

}
