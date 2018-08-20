package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.entities.ActionEntity;
import br.com.teltelecom.services.ActionService;

@RestController
@RequestMapping("trello/actions")
public class ActionController {
	
	
	@Autowired
	ActionService service;

	@GetMapping(params={"idcard"})
	public ResponseEntity<?> listar(@RequestParam String idcard) {
		try {									
			return ResponseEntity.ok(service.listar(idcard));
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(params={"idcard","qa"})
	public ResponseEntity<?> indicadorQA(@RequestParam String idcard,@RequestParam String qa) {
		try {
			int qtd=0;
			for(ActionEntity dto : service.listar(idcard)) {			
				if (dto.getData().getListAfter() != null) {
					if((dto.getData().getListAfter().getName().contains("QA/Testes")) &&
					   (!dto.getData().getListBefore().getName().contains("QA/Testes"))){
							qtd++;
					}
				}		
			}			
			return ResponseEntity.ok(qtd);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
