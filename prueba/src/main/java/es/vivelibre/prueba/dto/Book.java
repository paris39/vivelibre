package es.vivelibre.prueba.dto;

import lombok.Data;

@Data
public class Book {

	private String id;
	private String title;
	private int pages;
	private String summary;
	private Author author;

}