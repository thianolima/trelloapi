package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.dtos.ActionDto;
import br.com.teltelecom.dtos.CardDto;
import br.com.teltelecom.dtos.MemberDto;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class CardService {
	
	@Autowired
	TrelloUtil trello;
	
	public CardDto[] listar(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard +"/cards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			CardDto[] cards = restTemplate.getForObject(url, CardDto[].class);						
			return cards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public MemberDto[] listarMembros(String idCard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idCard +"/members?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			MemberDto[] members = restTemplate.getForObject(url, MemberDto[].class);						
			return members;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public ActionDto[] listarAcoes(String idCard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idCard +"/actions?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=id,type,date,data&memberCreator=false";
			ActionDto[] actions = restTemplate.getForObject(url, ActionDto[].class);						
			return actions;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
