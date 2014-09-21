package lambda.repository;

import java.util.Optional;

import lambda.model.Book;

public interface BookRepository {
	void addBook(Book book);
	Optional<Book> getBook(int id);
	void deleteBook(int id);
}
