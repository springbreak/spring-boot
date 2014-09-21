package lambda.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lambda.model.Book;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	Map<Integer, Book> books;
	
	public BookRepositoryImpl() {
		this.books = new HashMap<Integer, Book>();
	}

	@Override
	public void addBook(Book book) {
		books.put(book.getId(), book);
	}

	@Override
	public Optional<Book> getBook(int id) {
		
		Book book = books.get(id);
		
		if (book != null) {
			return Optional.of(book);
		}
		
		return Optional.empty();
	}

	@Override
	public void deleteBook(int id) {
		
		for(int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == id) {
				books.remove(i); 
				return;
			}
		}
	}
}
