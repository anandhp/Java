package flipkart.bookcatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookTrieNode {
	private static final int AlphabetSize = 26;

	private BookTrieNode[] children = new BookTrieNode[AlphabetSize];
	private Set<Book> books = new TreeSet<Book>(new Book().new CountComparator());
	
	public BookTrieNode() {
	}
	
	public void set(int i, BookTrieNode node) {
		children[i] = node;
	}
	
	public BookTrieNode get(int i) {
		return children[i];
	}

	public void setBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks() { 
		List<Book> bookList = new ArrayList<Book>();
		bookList.addAll(this.books);
		
		for (BookTrieNode child :children) {
			if (child != null)
				bookList.addAll(child.getBooks());
		}
		
		return bookList;
	}
}
