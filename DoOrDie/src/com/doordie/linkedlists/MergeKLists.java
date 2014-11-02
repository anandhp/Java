package com.doordie.linkedlists;

import java.util.ArrayList;
import java.util.List;


/**
 * Merge k sorted linked lists and return it as one sorted list.
 */

public class MergeKLists {

    public ListNode mergeKLists(List<ListNode> lists, int low, int high) {
        if (high < low)
            return null;
        
        if (low == high)
        	return lists.get(low);
        
        int mid = (low + high) / 2;
        ListNode left = mergeKLists(lists, low, mid);
        ListNode right = mergeKLists(lists, mid + 1, high);
        
        ListNode result = new ListNode(-1, null);
        ListNode current = result;

        while (left != null && right != null) {
            if (left.value < right.value) {
                current.next = left;
                left = left.next;
            }
            else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        while (left != null) {
            current.next = left;
            left = left.next;
            current = current.next;
        }
        
        while (right != null) {
            current.next = right;
            right = right.next;
            current = current.next;
        }
        
        current.next = null;
        return result.next;
    }
 
    public ListNode mergeKLists(List<ListNode> lists) {
        return mergeKLists(lists, 0, lists.size() - 1);
    }
    
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(LinkedList.buildList(A));
		lists.add(LinkedList.buildList(A));
		lists.add(LinkedList.buildList(A));
		lists.add(LinkedList.buildList(A));
		lists.add(LinkedList.buildList(A));

		ListNode head = new MergeKLists().mergeKLists(lists);
		
		System.out.println("Merged List");
		LinkedList.print(head);
	}

}
