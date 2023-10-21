import java.util.List;
import java.util.stream.Stream;

public class Bookshelf {

	private List<Book> books = List.of();

	public void addBook(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("books must not be null");
		}
		books = Stream.concat(books.stream(), Stream.of(book)).toList();
	}

	public Book findBookById(int id) {
		return books.stream()
			.filter(book -> book.id() == id)
			.findFirst()
			.orElseThrow(() -> new BookNotFoundException("book not found"));
	}

	public Book findBookByTitle(String title) {
		return books.stream()
			.filter(book -> book.title().equals(title))
			.findFirst()
			.orElseThrow(() -> new BookNotFoundException("book not found"));
	}
}
