package com.nicolas.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nicolas.bookapi.models.Book;
import com.nicolas.bookapi.services.BookServ;

import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookServ bookserv;

	@GetMapping("/")
	public String raiz() {
		return "redirect:/books";
	}

	// trae todos los datos de la Base de datos y los muestra en la vista
	@GetMapping("/books")
	public String index(Model m) {
		List<Book> libros = bookserv.allBooks();
		m.addAttribute("libros", libros);
		return "index.jsp";
	}

	// crea un nuevo registro en la bd por vista
	@GetMapping("/books/new")
	public String nuevo(@ModelAttribute("book") Book book) {
		return "nuevo.jsp";
	}

	@PostMapping("/books/new")
	public String nuevoLibro(@Valid @ModelAttribute("book") Book book, BindingResult binding) {
		if (binding.hasErrors()) {
			return "nuevo.jsp";
		} else {
			bookserv.createBook(book);
			return "redirect:/books";
		}
	}
	
	//metodo que devuelve un solo registro de la base de datos por id
	@GetMapping("/books/{bookId}")
	public String mostrarLibro(Model m, @PathVariable("bookId") Long bookId) {
		m.addAttribute("libro",bookserv.findBook(bookId));
		return "mostrar.jsp";
	}
	
	//metodo para llenar los campos del formulario con los datos que se van a editar
	@GetMapping("/books/edit/{bookId}")
	public String cargaFormularioLibro(@ModelAttribute("libro") Book Libro,@PathVariable("bookId") Long bookId,Model m) {
		m.addAttribute("unlibro",bookserv.findBook(bookId));
		return "editar.jsp";
	}
	
	
	//Metodo que actualiza el valor de los campos en la base de datos
	@PutMapping("/books/edit/{bookId}")
	public String editarLibro(@ModelAttribute("libro") Book Libro,@PathVariable("bookId") Long bookId,Model m,BindingResult binding) {
		if (binding.hasErrors()) {
			return "editar.jsp";
		} else {
			bookserv.updateBook(Libro);
			return "redirect:/books";
		}
	}

	//Metodo para eliminar un registro
	@GetMapping("/books/delete/{bookId}")
	public String eliminarLibro(@PathVariable("bookId") Long bookId) {
//		Book unlibro = bookserv.findBook(bookId);
		bookserv.deleteBook(bookId);
		return "redirect:/books";
	}

}
