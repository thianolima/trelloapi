package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.entities.CardEntity;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class CardService {
	
	@Autowired
	TrelloUtil trello;
	
	public CardEntity[] listar(String idboard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idboard +"/cards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			CardEntity[] cards = restTemplate.getForObject(url, CardEntity[].class);						
			return cards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
