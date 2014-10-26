package com.doordie.linkedlists;

/**
 *	Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1) 
 * 	Examples
 * 
 *	Input List:  1->2->3->4->5->6
 *	Output List: 1->3->5->6->4->2
 *
 *	Input List:  12->14->16->18->20
 *	Output List: 12->16->20->18->14
 *
 */

public class ReverseAltNodes {
	
	public static void reverseAltNodes(ListNode head) {
		if (head == null || head.next == null)
			return;
		
		ListNode next = head.next;
		ListNode revList = null;
		while (next != null && next.next != null) {
			head.next = next.next;
			head = head.next;
			next.next = revList;
			revList = next;
			next = head.next;
		}
		if (next != null) {
			next.next = revList;
			revList = next;
		}
		head.next = revList;
	}

	//Tester method
	public static void main(String[] args) {
		//create list
		int[] A = {1, 2, 3, 4, 5, 6};
		ListNode head = LinkedList.buildList(A);
		
		//Test reversing
		LinkedList.print(head);
		ReverseAltNodes.reverseAltNodes(head);
		LinkedList.print(head);
	}
}
