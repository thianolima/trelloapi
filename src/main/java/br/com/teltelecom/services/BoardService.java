package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.entities.BoardEntity;
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
}
