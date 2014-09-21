package lambda.controller;

import java.util.Optional;

import lambda.model.Book;
import lambda.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	String bookHome() { return "this is book's home"; }
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	Book getBook(@PathVariable("id") int id) {

		Optional<Book> optBook = bookService.getBook(id);

		// case: the book exists
		if (optBook.isPresent()) {
			return optBook.get();
		}

		return null;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void addBook(@PathVariable(value="id") int id,
			@RequestParam(value="title", required=true) String title,
			@RequestParam(value="author", required=true) String author ) {
		
		bookService.addBook(new Book(id, title, author));
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.DELETE) 
	@ResponseStatus(HttpStatus.OK)
	void deleteBook(@PathVariable(value="id") int id) {
		bookService.deleteBook(id);
	}
}
