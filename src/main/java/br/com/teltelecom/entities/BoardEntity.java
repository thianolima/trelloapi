package br.com.teltelecom.entities;

public class BoardEntity {

	private String id;
	private String name;
	private String shortLink;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	@Override
	public String toString() {
		return "BoardEntity [id=" + id + ", name=" + name + "]";
	}	
}
