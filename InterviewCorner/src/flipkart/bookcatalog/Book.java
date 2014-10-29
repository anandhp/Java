package flipkart.bookcatalog;

import java.util.Comparator;

public class Book implements Comparable<Book> {

	public String name;
	public String author;
	public int count;
	
	public Book() {}
	
	public Book(String name, String author, int count) {
		this.name = name;
		this.author = author;
		this.count = count;
	}
	
	public String getName() { return this.name; }
	public String getAuthor() { return this.author; } 
	public int getCount() { return this.count; }
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) return false;

		Book book = (Book) obj;
		return this.name.equals(book.name) 
				&& this.author.equals(book.author);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.author.hashCode();
	}

	@Override
	public int compareTo(Book o) {
		return this.name.compareTo(o.name);
	}	
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public class CountComparator implements Comparator<Book> {

		@Override
		public int compare(Book book, Book otherBook) {
			return otherBook.getCount() - book.getCount();
		}
		
	}
}
