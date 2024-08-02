package es.vivelibre.prueba.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.vivelibre.prueba.dto.Book;
import es.vivelibre.prueba.service.BookService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Data
@Slf4j
public class BookServiceImpl implements BookService {

	private static final String BOOKS_FILE = "books.json";

	private List<Book> books;

	/**
	 * Inicialize books.
	 */
	private void inicializeBooks () {
		String path = getClass().getClassLoader().getResource(BOOKS_FILE).getPath();

		try {
			String jsonContent = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

			ObjectMapper mapper = new ObjectMapper();
			this.books = mapper.readValue(jsonContent, new TypeReference<ArrayList<Book>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * BufferedReader bufferedReader;
		 * try {
		 * bufferedReader = new BufferedReader(new FileReader(path));
		 * Gson gson = new Gson();
		 * Book[] json = gson.fromJson(bufferedReader, Book[].class);
		 * } catch (FileNotFoundException e) {
		 * e.printStackTrace();
		 * }
		 */

		log.debug("Books: " + this.books.toString());
	}

	// private Optional<BookDate> filter (String filter, List<Book> books) {
	//
	// }

	@Override
	public List<Book> booksNoPublishDate () {
		if (null == this.books || 0 == this.books.size()) {
			inicializeBooks();
		}

		// String filter = ""

		return null;
	}

}