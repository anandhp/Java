package com.doordie.linkedlists;

public class LinkedList {

	public static ListNode buildList(int[] list) {
		ListNode head = null;
		for (int i = list.length - 1; i >= 0; i--) {
			ListNode newNode = new ListNode(list[i], head);
			head = newNode;
		}
		return head;
	}
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.print("->" + head.value);
			head = head.next;
		}
		System.out.println();
	}
}
