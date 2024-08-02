package es.vivelibre.prueba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Author {

	@JsonProperty
	private String name;
	@JsonProperty
	private String firstSurname;
	@JsonProperty
	private String bio;

}