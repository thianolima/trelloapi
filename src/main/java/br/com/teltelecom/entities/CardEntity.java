package br.com.teltelecom.entities;

import java.util.Date;

public class CardEntity {

	private String id;
	private String shortUrl;
	private String name;
	private Date due;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getShortUrl() {
		return shortUrl;
	}
	
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}	
	
	
}
