package com.doordie.linkedlists;

/**
 *	Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *    
 *	For example:
 *		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *		return 1->4->3->2->5->NULL. 
 *    
 *
 */

public class ReverseListBwBounds {

	//function for reversing nodes between bounds
	//assumes start and end points are inside list length
	public static ListNode reverse(ListNode head, int m, int n) {
		int index = 1;
		ListNode dummy = new ListNode(-1, head);
		ListNode node = dummy;

		//get the starting point
		while (node != null && index < m) {
			node = node.next;
			index++;
		}
		
		if (node == null)
			return head;
		
		//start reversing nodes till reach end point
		ListNode start = node;
		node = node.next;
		while (node != null && index < n) {
			ListNode next = node.next;
			node.next = node.next.next;
			next.next = start.next;
			start.next = next;
			index++;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5, 6};

		//Build list and print
		ListNode head = LinkedList.buildList(A);
		LinkedList.print(head);
		
		//reverse nodes in bounds and print
		head = ReverseListBwBounds.reverse(head, 2, 4);
		LinkedList.print(head);
	}

}
