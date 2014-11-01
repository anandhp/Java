package com.doordie.stacks;

import java.util.Stack;

public class SimulatedQueue<E> {
	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();
	

	public void enqueue(E item) {
		inbox.push(item);
	}
	
	public E dequeue() throws Exception {
		//If no element in the queue
		if (inbox.empty())
			throw  new Exception("No elemement in the queue");
		
		// move all the elements from inbox to outbox
		while(!inbox.empty())
			outbox.push(inbox.pop());
		
		//get the top items from outbox which item to dequeued
		E returnItem = outbox.pop();

		//move all items back to inbox;
		while (!outbox.empty())
			inbox.push(outbox.pop());
		
		//return the item
		return returnItem;
	}
	
	public E peek() { return inbox.firstElement(); }
	
	public static void main(String[] args) throws Exception {
		
		SimulatedQueue<String> queue = new SimulatedQueue<String>();
		
		queue.enqueue("One");
		queue.enqueue("Two");
		queue.enqueue("Three");
		
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.peek());

	}

}
