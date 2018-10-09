package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.entities.ActionEntity;
import br.com.teltelecom.entities.CardEntity;
import br.com.teltelecom.entities.MemberEntity;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class CardService {
	
	@Autowired
	TrelloUtil trello;
	
	public CardEntity[] listar(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard +"/cards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			CardEntity[] cards = restTemplate.getForObject(url, CardEntity[].class);						
			return cards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public MemberEntity[] listarMembros(String idCard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idCard +"/members?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			MemberEntity[] members = restTemplate.getForObject(url, MemberEntity[].class);						
			return members;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ActionEntity[] listarAcoes(String idCard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idCard +"/actions?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=id,type,date,data&memberCreator=false";
			ActionEntity[] actions = restTemplate.getForObject(url, ActionEntity[].class);						
			return actions;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
