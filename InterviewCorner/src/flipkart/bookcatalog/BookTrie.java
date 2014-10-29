package flipkart.bookcatalog;

import java.util.List;

public class BookTrie {
	private BookTrieNode root = new BookTrieNode();
	
	public void add(String name, Book book) {
		BookTrieNode crawler = root;
		
		for (int i = 0; i < name.length(); i++) {
			int index = Character.getNumericValue(name.charAt(i)) - Character.getNumericValue('A');
			if (crawler.get(index) == null)
				crawler.set(index, new BookTrieNode());
			crawler = crawler.get(index);
		}
		
		crawler.setBook(book);
	}
	
	public List<Book> search(String name) {
		BookTrieNode crawler = root;
		for (int i = 0; i < name.length(); i++) {
			int index = Character.getNumericValue(name.charAt(i)) - Character.getNumericValue('A');
			crawler = crawler.get(index);
			
			if (crawler == null)
				return null;
		}		
		return crawler.getBooks();
	}
	
	
}
