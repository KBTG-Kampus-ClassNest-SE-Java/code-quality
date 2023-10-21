import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookshelfTest {

	@Test
	@DisplayName("add clean code book to bookshelf and the bookshelf should contain clean code book")
	void addCleanCodeBook() {
		var bookshelf = new Bookshelf();

		bookshelf.addBook(new Book(1, "Clean Code"));

		assertEquals("Clean Code", bookshelf.findBookById(1).title());
	}

	@Test
	@DisplayName("given bookshelf empty should throw BookNotFoundException")
	void findBookById1InEmptyBookshelf() {
		var bookshelf = new Bookshelf();

		assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));
	}

	@Test
	@DisplayName("given bookshelf empty should throw BookNotFoundException with message book not found")
	void findBookById1InEmptyBookshelfExceptionShouldBeBookNotFound() {
		var bookshelf = new Bookshelf();

		var exception = assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));

		assertEquals("book not found", exception.getMessage());
	}
}
