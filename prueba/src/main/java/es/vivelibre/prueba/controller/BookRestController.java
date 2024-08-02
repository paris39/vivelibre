package es.vivelibre.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vivelibre.prueba.dto.Book;
import es.vivelibre.prueba.service.BookService;
import lombok.Data;

@Data
@RestController
@RequestMapping ("/book")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GetMapping (value = "/booksNoPublishDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> booksNoPublishDate () {
		List<Book> bookList = bookService.booksNoPublishDate();

		return bookList;
	}
}