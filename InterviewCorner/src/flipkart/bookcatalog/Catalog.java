package flipkart.bookcatalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Catalog {
	private Set<Book> books = new HashSet<Book>();
	private BookTrie bookNameTrie = new BookTrie();
	private BookTrie authorTrie = new BookTrie();
	
	
	public void addBookToCatalog(Book book) {
		books.add(book);

		bookNameTrie.add(book.getName(), book);
		authorTrie.add(book.getAuthor(), book);
	}
	
	public List<Book> searchBookByName(String name) {
		return bookNameTrie.search(name);
	}

	public List<Book> searchBookByAuthor(String name) {
		return authorTrie.search(name);
	}
	
	public List<Book> getMostSoldBooks(String name) {
		List<Book> list = new ArrayList<Book>();
		return list;
	}
}
