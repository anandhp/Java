package com.doordie.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private class LRUNode {
		public Integer key;
		public Integer value;
		public LRUNode next;
		public LRUNode prev;
		
		LRUNode (int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}

	}
	private LRUNode head = null, tail = null;
	private Map<Integer, LRUNode> itemMap;
	private int capacity;

	public LRUCache(int capacity) {
		itemMap = new HashMap<Integer, LRUNode>();
		this.capacity = capacity;

		head = new LRUNode(-1, -1);
		tail = new LRUNode(-1, -1);
		head.next = tail;
		tail.prev = head;
		
    }
    
    public int get(int key) {
    	LRUNode node = itemMap.get(key);
        if (node == null)
        	return -1;
        
        int result = node.value;
        set(key, result);
        return result;
    }
    
    public void set(int key, int value) {
       LRUNode node = itemMap.get(key);
       if (node == null) {
    	   LRUNode newNode = new LRUNode(key, value);
    	   newNode.next = head.next;
    	   head.next = newNode;
    	   newNode.prev = head;
		   newNode.next.prev = newNode;
		   itemMap.put(key, newNode);
		   
		   if (itemMap.size() > capacity) {
			   LRUNode lastNode = tail.prev;
			   lastNode.prev.next = tail;
			   tail.prev = lastNode.prev;
			   itemMap.remove(lastNode.key);
		   }
       }
       else {
    	   node.prev.next = node.next;
    	   node.next.prev = node.prev;
    	   node.next = head.next;
    	   node.next.prev = node;
    	   node.prev = head;
    	   head.next = node;
    	   node.value = value;
       }
    }
    
    
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(5);
		
		System.out.println(lruCache.get(10));
		lruCache.set(1, 1);
		lruCache.set(2, 2);
		lruCache.set(3, 3);
		System.out.println(lruCache.get(3));
		lruCache.set(4, 4);
		lruCache.set(3, 4);
		lruCache.set(5, 5);
		lruCache.set(6, 6);
		System.out.println(lruCache.get(1));
		lruCache.set(3, 4);
		System.out.println(lruCache.get(3));
		
	}

}
