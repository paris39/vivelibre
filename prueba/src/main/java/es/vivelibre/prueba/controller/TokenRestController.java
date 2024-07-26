package es.vivelibre.prueba.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vivelibre.prueba.dto.BookDate;
import es.vivelibre.prueba.dto.TokenResponse;
import lombok.Data;

@Data
@RestController
public class TokenRestController {

	/**
	 * Gets the token.
	 *
	 * @param user
	 *        the user
	 * @param password
	 *        the password
	 * @return the token
	 */
	@GetMapping (value = "/get-token", produces = APPLICATION_JSON_VALUE)
	public TokenResponse getToken (String user, String password) {
		LocalDateTime today = LocalDateTime.now();
		String date = today.getMonthValue() + " " + today.getDayOfMonth() + ", " + today.getYear();

		// Llamada a Token
		String token = new String();

		return new TokenResponse(token, date);
	}

	/**
	 * Filter.
	 *
	 * @param filter
	 *        the filter
	 * @param books
	 *        the books
	 * @return the optional
	 */
	public Optional<BookDate> filter (String filter, List<Book> books) {
		BookDate bookDate = new BookDate();

		return Optional.ofNullable(bookDate);
	}

}