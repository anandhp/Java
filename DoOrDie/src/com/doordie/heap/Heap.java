package com.doordie.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap<T> {
	//comparator for decided type of heap
	private Comparator<T> comparator;
	//container for the data
	private List<T> data;

	//ctor needs the minheap or maxheap comparator
	public Heap(Comparator<T> comparator) {
		this.comparator = comparator;
		data = new ArrayList<T>();
	}
	
	
	//adds element to the heap
	public void push(T item) {
		data.add(0, item);
		heapify(0);
	}
	
	//remove element from the heap
	public T pop() {
		if (data.isEmpty())
			throw new NoSuchElementException("Heap is empty");

		T element = data.remove(0);

		if (data.isEmpty())
			return element;
		
		data.add(0, data.remove(data.size() - 1));
		heapify(0);

		return element;
	}
	
	//get the top element of the heap
	public T top() {
		if (data.isEmpty())
			throw new NoSuchElementException("Heap is empty");
		
		return data.get(0);
	}
	
	public boolean empty() { return data.isEmpty(); }

	//heapify function
	private void heapify(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		
		int i = index;
		int size = data.size();
		
		if (left < size && comparator.compare(data.get(i), data.get(left)) < 0)
			i = left;
		if (right< size && comparator.compare(data.get(i), data.get(right)) < 0)
			i = right;
		
		if (i != index) {
			T element = data.get(i);
			data.set(i, data.get(index));
			data.set(index, element);
			
			//heapify the next index
			heapify(i);
		}
	}

}
