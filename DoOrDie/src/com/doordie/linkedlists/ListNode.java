package com.doordie.linkedlists;

public class ListNode {
	public int value;
	public ListNode next;
	
	public ListNode(int value, ListNode next) {
		this.value = value;
		this.next = next;
	}
	
	public void print() {
		System.out.println(value + " ");
	}
}
