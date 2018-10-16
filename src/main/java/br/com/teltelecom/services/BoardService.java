package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.dtos.BoardDto;
import br.com.teltelecom.dtos.CardDto;
import br.com.teltelecom.dtos.MemberDto;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class BoardService {
	
	@Autowired
	TrelloUtil trello;
	
	public BoardDto[] listar() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/members/me/boards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&filed=all";
			BoardDto[] boards = restTemplate.getForObject(url, BoardDto[].class);						
			return boards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public MemberDto[] listarMembros(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard + "/members?key=" + trello.getKey() + "&token=" + trello.getToken(); 
			MemberDto[] members = restTemplate.getForObject(url, MemberDto[].class);						
			return members;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public CardDto[] listarCards(String idBoard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/boards/" + idBoard +"/cards?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			CardDto[] cards = restTemplate.getForObject(url, CardDto[].class);						
			return cards;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
