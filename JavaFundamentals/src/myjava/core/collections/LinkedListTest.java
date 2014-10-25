package myjava.core.collections;

import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<String>();
		a.add("One");
		a.add("Two");
		a.add("Three");
		
		List<String> b = new LinkedList<String>();
		b.add("Four");
		b.add("Five");
		b.add("Six");
		b.add("Seven");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		
		//merge all words from b to a
		while (bIter.hasNext()) {
			if (aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		//remove every second word from b
		bIter = b.iterator();
		while (bIter.hasNext()) {
			bIter.next();
			if (bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println(b);
		
		//remove the b elements from a
		a.removeAll(b);
		
		System.out.println(a);
	}
}
