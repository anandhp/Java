package flipkart.bookcatalog;

public class Application {

	public static void main(String[] args) {

		Catalog catalog = new Catalog();

		catalog.addBookToCatalog(new Book("ABC", "XY", 20));
		catalog.addBookToCatalog(new Book("DEF", "XY", 45));
		catalog.addBookToCatalog(new Book("EFG", "XY", 67));
		catalog.addBookToCatalog(new Book("HIJ", "ABC", 25));
		
		System.out.println(catalog.searchBookByAuthor("XY"));
	}

}
