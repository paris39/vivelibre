package es.vivelibre.prueba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude (Include.NON_NULL)
@JsonPropertyOrder ({ "authVivelibreToken", "date" })
public class TokenResponse {

	@JsonProperty
	private String authVivelibreToken;

	@JsonProperty
	private String date;

}
