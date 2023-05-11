package com.nicolas.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.bookapi.models.Book;
import com.nicolas.bookapi.repositories.BookRepo;

@Service
public class BookServ {

	//se puede hacer asi tambien
	// private final BookRepo bookRepository;

	// public BookServ(BookRepo bookRepository) {
	// this.bookRepository = bookRepository;
	// }

	//otra forma
	@Autowired
	private BookRepo bookRepository;

	// Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// Creando un libro.
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// Obteniendo la información de un libro
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//Servicio para actualizar un libro
	/*public Book updateBook(Long id, String title,String lang,String description,int pages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			 Book bookToUpdate = optionalBook.get();
	            bookToUpdate.setTitle(title);
	            bookToUpdate.setDescription(description);
	            bookToUpdate.setLanguage(lang);
	            bookToUpdate.setNumberOfPages(pages);
	            bookRepository.save(bookToUpdate);
	            return bookToUpdate;
		} else {
			return null;
		}
		
	}*/
	
	public Book updateBook(Long id, String title,String lang,String description,int pages) {
		Book optionalBook = bookRepository.findById(id).orElse(null);
		if(optionalBook != null) {
			optionalBook.setTitle(title);
			optionalBook.setDescription(description);
			optionalBook.setLanguage(lang);
			optionalBook.setNumberOfPages(pages);
			bookRepository.save(optionalBook);
			return optionalBook;
		}else {
			return optionalBook;
		}
	}
	
	public Book updateBook(Book b) {
		Book updateLibro = findBook(b.getId());
		
		updateLibro.setTitle(b.getTitle());
		updateLibro.setDescription(b.getDescription());
		updateLibro.setLanguage(b.getLanguage());
		updateLibro.setNumberOfPages(b.getNumberOfPages());
		
		bookRepository.save(updateLibro);
		
		return updateLibro;
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
}
