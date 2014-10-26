package com.doordie.linkedlists;

/**
 * Given the linked list as below
 * 1->2->3->4->5->6
 * 
 * Alter the list to look as below
 * 1->6->2->5->3->4
 */

public class AlterList {

	public static ListNode alterList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		//find the midpoint of the list
		ListNode p = head, q = head.next;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		
		q = p.next;
		p.next = null;
		
		//reverse the half of the list
		//Note that reverse list function is used from other solutions
		p = head;
		q = ReverseList.reverseList(q);
		
		//now merge both list nodes alternatively
		while (p != null && q != null) {
			ListNode t = p.next;
			ListNode s = q.next;
			p.next = q;
			q.next = t;
			p = t;
			q = s;
		}	
		
		return head;
	}
	
	//Tester
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		ListNode head = LinkedList.buildList(A);
		LinkedList.print(head);
		AlterList.alterList(head);
		LinkedList.print(head);
	}

}
