package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.entities.BoardEntity;
import br.com.teltelecom.entities.CardEntity;
import br.com.teltelecom.entities.MemberEntity;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class BoardService {
	
	@Autowired
	TrelloUtil trello;
	
	public BoardEntity[] listar() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/members/me/boards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&filed=all";
			BoardEntity[] boards = restTemplate.getForObject(url, BoardEntity[].class);						
			return boards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public MemberEntity[] listarMembros(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard + "/members?key=" + trello.getKey() + "&token=" + trello.getToken(); 
			MemberEntity[] members = restTemplate.getForObject(url, MemberEntity[].class);						
			return members;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public CardEntity[] listarCards(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard +"/cards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			CardEntity[] cards = restTemplate.getForObject(url, CardEntity[].class);						
			return cards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
