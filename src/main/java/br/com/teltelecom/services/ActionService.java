package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.teltelecom.entities.ActionEntity;
import br.com.teltelecom.util.TrelloUtil;

@Service
public class ActionService {

	@Autowired
	TrelloUtil trello;
	
	public ActionEntity[] listar(String idcard) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = trello.getUrl() + "/cards/" + idcard +"/actions?key=" + trello.getKey() + "&token=" + trello.getToken() + "&fields=id,type,date,data&memberCreator=false";
			ActionEntity[] actions = restTemplate.getForObject(url, ActionEntity[].class);						
			return actions;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
