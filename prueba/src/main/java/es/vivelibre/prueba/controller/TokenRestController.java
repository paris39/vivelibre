package es.vivelibre.prueba.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vivelibre.prueba.dto.BookDate;
import es.vivelibre.prueba.dto.TokenResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@RestController
@RequestMapping ("/get-token")
@Slf4j
public class TokenRestController {

	@Value ("${prueba.token.host}")
	private String HOST;
	@Value ("${prueba.token.port}")
	private int PORT;
	@Value ("${prueba.token.endpoint}")
	private String ENDPOINT;

	/**
	 * Gets the token.
	 *
	 * @param user
	 *        the user
	 * @param password
	 *        the password
	 * @return the token
	 */
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public TokenResponse getToken () {
		LocalDateTime today = LocalDateTime.now();
		String date = today.getMonthValue() + " " + today.getDayOfMonth() + ", " + today.getYear();

		// Llamada a Token
		String token = getAccessToken();
		return new TokenResponse(token, date);
	}

	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	private String getAccessToken () {
		String response = new String();

		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
		HttpRequest httpRequest = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create(String.format("http://%s:%d/%s", HOST, PORT, ENDPOINT)))
			.header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
			.build();
		log.debug("URL: " + httpRequest.uri());
		try {
			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			response = httpResponse.body();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return response;
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