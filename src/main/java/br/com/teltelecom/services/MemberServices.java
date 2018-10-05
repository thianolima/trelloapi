package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.teltelecom.entities.MemberEntity;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class MemberServices {

	@Autowired
	TrelloUtil trello;
	
	public MemberEntity[] listar(String idCard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idCard +"/members?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=all";
			MemberEntity[] members = restTemplate.getForObject(url, MemberEntity[].class);						
			return members;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
