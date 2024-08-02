package es.vivelibre.prueba.service;

import java.util.List;

import es.vivelibre.prueba.dto.Book;

public interface BookService {

	/**
	 * Books no publish date.
	 *
	 * @return the list
	 */
	public List<Book> booksNoPublishDate ();
}