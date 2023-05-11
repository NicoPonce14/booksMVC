package com.nicolas.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.bookapi.models.Book;
import com.nicolas.bookapi.services.BookServ;

@RestController
public class BookApi {
//	private final BookService bookService;
//
//	public BookApi(BookService bookService){
//	        this.bookService = bookService;
//	    }
	@Autowired
	private BookServ bookService;

	// Otros métodos han sido removidos para resumir.
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping("/api/books/all")
	public List<Book> listAll() {
		
		return bookService.allBooks();
	}
	@PostMapping("/api/books/crear")
	public void createBook(Book b) {
		bookService.createBook(b);
	}

}
