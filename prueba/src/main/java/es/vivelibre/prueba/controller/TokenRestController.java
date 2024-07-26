package es.vivelibre.prueba.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

		return new TokenResponse("string", date);
	}

}