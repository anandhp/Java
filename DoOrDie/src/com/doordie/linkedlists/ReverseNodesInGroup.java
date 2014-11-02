package com.doordie.linkedlists;

/**
 *	Given a linked list, reverse the nodes of a linked list k at a 
 *	time and return its modified list. If the number of nodes is not a 
 *	multiple of k then left-out nodes in the end should remain as it is.
 *	
 *	You may not alter the values in the nodes, only nodes itself may be changed.
 *	
 *	Only constant memory is allowed.
 *	
 *	For example,
 *	Given this linked list: 1->2->3->4->5
 *	
 *	For k = 2, you should return: 2->1->4->3->5
 *	
 *	For k = 3, you should return: 3->2->1->4->5
 *	
 */

public class ReverseNodesInGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
            
        ListNode dummy = new ListNode(-1, null);
        ListNode current = dummy;
        dummy.next = head;
        
        while(true) {
            ListNode indexer = current.next;
            int i = 0;
            for (i = 0; i < k && indexer != null; i++)
                indexer = indexer.next;

            if (indexer == null && i < k)
                break;

            ListNode swapper = current.next; 

            while (swapper.next != indexer) {
                ListNode next = swapper.next;
                ListNode curNext = current.next;
                current.next = next;
                swapper.next = next.next;
                next.next = curNext;
            }
            
            current = swapper;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
		int[] A = {1, 2, 3 , 4, 5, 6};
		ListNode head = LinkedList.buildList(A);
		
		LinkedList.print(head);
		head = ReverseNodesInGroup.reverseKGroup(head, 3);
		LinkedList.print(head);

    }

}
