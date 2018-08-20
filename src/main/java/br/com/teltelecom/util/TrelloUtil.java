package br.com.teltelecom.util;

import org.springframework.beans.factory.annotation.Value;

public class TrelloUtil {
	
	@Value("${trello.key}")
	private String key;
	
	@Value("${trello.token}")
	private String token;
	
	@Value("${trello.url}")
	private String url;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
