package com.doordie.linkedlists;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialize the linked list. This class needs ListNode class to 
 * implement Serializable interface. Otherwise it would crash!
 */
public class SerializeLinkedList {

	//Tester
	public static void main(String[] args) {

		int[] A = {1, 2, 3, 4, 5, 6};
		ListNode head = LinkedList.buildList(A);

		//just serialize the head. it would recursively serialize
		//all nodes from it
		try {
			FileOutputStream file = new FileOutputStream("list.ser");
			ObjectOutputStream writer = new ObjectOutputStream(file);
			writer.writeObject(head);
			writer.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//similarly de-serialize the just head would get all nodes!!
		//pretty cool isnt it?
		ListNode newHead = null;
		try {
			FileInputStream file = new FileInputStream("list.ser");
			ObjectInputStream reader = new ObjectInputStream(file);
			newHead = (ListNode)reader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LinkedList.print(head);
		LinkedList.print(newHead);
	}

}
