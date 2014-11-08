package com.doordie.linkedlists;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicates {
	
	//Solution using hash map.
	//store the nodes with value has keys and then merge 
	//keys with single nodes
	public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        
        Map<Integer, ListNode> nodes = new LinkedHashMap<Integer, ListNode>();

        while (head != null) {
        	ListNode node = head;
            head = head.next;
        	node.next = null;

            if (nodes.containsKey(node.value)) {
            	node.next = nodes.get(node.value);
            	nodes.put(node.value, node);
            } else {
            	nodes.put(node.value, node);
            }
        }
        
        ListNode dummy = new ListNode(-1, null); 
        ListNode node = dummy;
        
        for (Map.Entry<Integer, ListNode> entry : nodes.entrySet()) {
        	if (entry.getValue().next == null) {
        		node.next = entry.getValue();
        		node = node.next;
        	}
        }
        
        return dummy.next;
    }
	
	//iterative way of removing duplicates
	public static ListNode deleteDuplicatesEx(ListNode head) {
		ListNode dummy = new ListNode(-1, null); 
        ListNode node = dummy;

        while (head != null) {
        	ListNode current = head;
        	while (head.next != null && head.value == head.next.value)
        		head = head.next;

        	if (current == head) {
        		node.next = current;
        		node = node.next;
        	}
        	head = head.next;
        }
        
        node.next = null;
        return dummy.next;
	}
	
	
	public static void main(String[] args) {
		//create list
		int [][] tests = {
							{1, 2, 3, 4, 5, 6},
							{1, 1, 1, 2, 3, 4},
							{1, 2, 2, 3, 3, 4},
							{1, 2, 3, 3, 4, 4},
							{-3, -1, -1, 0, 0, 0, 0, 0, 2},	
							{1, 1, 1, 1},
							{1}
					     };
		
		for (int[] test : tests) {
			ListNode head = LinkedList.buildList(test);
			LinkedList.print(head);
			head = RemoveDuplicates.deleteDuplicatesEx(head);
			LinkedList.print(head);
			System.out.println();
		}	
	}

}
