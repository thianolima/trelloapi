package br.com.teltelecom.entities;

import java.util.Date;

import lombok.Data;

@Data
public class CardEntity {

	private String id;
	private String shortUrl;
	private String name;
	private Date due;	
	
}
