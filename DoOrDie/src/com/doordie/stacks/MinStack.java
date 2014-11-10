package com.doordie.stacks;

import java.util.Stack;

public class MinStack {
    //Data containers of stack
    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> baseStack = new Stack<Integer>();
    
    public void push(int x) {
        baseStack.push(x);
        
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        if (!minStack.empty() && minStack.peek() == baseStack.peek())
            minStack.pop();
        
        baseStack.pop();    
    }

    public int top() {
        return baseStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-1);
		
		System.out.println(stack.getMin());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.getMin());
	}
}
