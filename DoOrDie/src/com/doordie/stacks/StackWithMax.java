package com.doordie.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Design Stack data structure that does push, pop and max operations in O(1) time.
 */

@SuppressWarnings("serial")
public class StackWithMax extends Stack<Integer> {
	private Integer currentMax = Integer.MIN_VALUE;
	
	public Integer push(Integer element) {
		if (element < currentMax)
			return super.push(element);
		else {
			super.push(currentMax + element);
			currentMax = element;
			return currentMax;
		}
	}
	
	public Integer pop() throws EmptyStackException {
		if (super.empty())
			throw new EmptyStackException();
		
		Integer element = super.pop();
		if (element < currentMax)
			return element;
		else {
			Integer prevMax  = element - currentMax;
			element = element - prevMax;
			currentMax = prevMax;
		}
		
		return element;
		
	}
	
	public Integer max() throws EmptyStackException {
		if (super.empty())
			throw new EmptyStackException();
		return currentMax;
	}
	
	public Integer top() throws EmptyStackException {
		if (super.empty())
			throw new EmptyStackException();
		
		Integer element = super.peek();
		if (element < currentMax)
			return element;
		else {
			return element - currentMax;
		}
	}
	
	public void printState() {
		if (super.empty())
			return;
		System.out.println("Stack - Max: "+ this.max() +  ", Top: "+ this.top());
	}	
	
	public static void main(String[] args) {
		
		StackWithMax stack = new StackWithMax();
		System.out.print("Pushed " + stack.push(1) + " "); stack.printState();
		System.out.print("Pushed " + stack.push(2) + " "); stack.printState();
		System.out.print("Pushed " + stack.push(5) + " "); stack.printState();
		System.out.print("Pushed " + stack.push(3) + " "); stack.printState();
		System.out.print("Pushed " + stack.push(8) + " "); stack.printState();
		System.out.print("Pushed " + stack.push(6) + " "); stack.printState();
		
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
		System.out.print("Popped " + stack.pop() + " "); stack.printState();
	}

}
