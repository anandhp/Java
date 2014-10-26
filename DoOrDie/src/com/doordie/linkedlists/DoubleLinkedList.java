package com.doordie.linkedlists;

/**
 * Implement double linked list using single linked list.
 * 
 * The idea is to use next pointer in the single linked list to 
 * store both next and previous pointers by XOR them. This is memory 
 * efficient implementation of double linked list.
 */

public class DoubleLinkedList {

	public static ListNode createList(int[] A) {
		ListNode head = null;
		for (int i = A.length - 1; i >= 0; i--) {
		}
		
		return head;
	}
	
	public static void traverseBackForth(ListNode head) {
		
	}

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		ListNode head = DoubleLinkedList.createList(A);
		DoubleLinkedList.traverseBackForth(head);
	}
}
