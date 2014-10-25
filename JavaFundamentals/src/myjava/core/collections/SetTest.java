package myjava.core.collections;
import java.util.*;

public class SetTest {
	public class Item implements Comparable<Item>{
		private String name;
		private String code;
		
		public Item() {
			
		}
		public Item(String n, String c) {
			this.name = n;
			this.code = c;
		}
		
		public int compareTo(Item other) {
			return name.compareTo(other.name);
		}
		
		public String toString() {
			return name + " " + code;
		}
		
		public class ItemComparator implements Comparator<Item> {
			public int compare(Item one, Item two) {
				return one.code.compareTo(two.code);
			}
		}
	}
	public static void main(String[] args) {
		Set<Item> treeSet = new TreeSet<Item>(new SetTest().new Item().new ItemComparator());
		treeSet.add(new SetTest().new Item("Toaster", "3333"));
		treeSet.add(new SetTest().new Item("Widget", "2222"));
		treeSet.add(new SetTest().new Item("Modem", "1111"));
		
		System.out.println(treeSet);
		
		Set<Item> hashSet = new HashSet<Item>();
		hashSet.add(new SetTest().new Item("Toaster", "3333"));
		hashSet.add(new SetTest().new Item("Widget", "2222"));
		hashSet.add(new SetTest().new Item("Modem", "1111"));
		
		System.out.println(hashSet);
		
	}

}
