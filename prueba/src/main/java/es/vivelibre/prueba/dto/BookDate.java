package es.vivelibre.prueba.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BookDate {

	private Book book;
	private Date date;

}