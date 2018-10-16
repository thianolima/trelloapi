package br.com.teltelecom.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class CardDto {

	private String id;
	private String shortUrl;
	private String name;
	private Date due;	
	
}
