package com.doordie.linkedlists;

public class ReverseBetween {
    
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1, null);
        ListNode current = dummy;
        int index = 1;
        
        dummy.next = head;

        while (head != null && index < m) {
            head = head.next;
            current = current.next;
            index++;
        }

        while (head != null && index < n) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = current.next;
            current.next = next;
            index++;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		//create list
		int[] A = {1, 2, 3, 4, 5, 6};
		ListNode head = LinkedList.buildList(A);
		
		//Test reversing
		LinkedList.print(head);
		head = ReverseBetween.reverseBetween(head, 3, 5);
		LinkedList.print(head);
	}

}
