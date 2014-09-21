package lambda.service;

import java.util.Optional;

import lambda.model.Book;
import lambda.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public void addBook(Book book) {
		bookRepository.addBook(book);
	}
	
	public Optional<Book> getBook(int id) {
		return bookRepository.getBook(id);
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteBook(id);
	}

}
