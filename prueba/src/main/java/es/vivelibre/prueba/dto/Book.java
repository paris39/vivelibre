package es.vivelibre.prueba.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Book {

	@JsonProperty
	private String id;
	@JsonProperty
	private String title;
	@JsonProperty
	private Timestamp publicationTimestamp;
	@JsonProperty
	private int pages;
	@JsonProperty
	private String summary;
	@JsonProperty
	private Author author;

}