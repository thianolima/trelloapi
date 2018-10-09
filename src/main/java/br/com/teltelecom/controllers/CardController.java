package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.CardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("cards")
public class CardController {

	@Autowired
	CardService service;
	
	@GetMapping(value="/{idCard}/membros")
	public ResponseEntity<?> listarMembros(@PathVariable String idCard) {
		try {									
			return ResponseEntity.ok(service.listarMembros(idCard));
		}catch(RuntimeException e) {
			log.error("CardController - listarMembros: idboard = " + idCard + " ERRO: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value="/{idCard}/acoes")
	public ResponseEntity<?> listarAcoes(@PathVariable String idCard) {
		try {									
			return ResponseEntity.ok(service.listarAcoes(idCard));
		}catch(RuntimeException e) {
			log.error("CardController - listarAcoes: idboard = " + idCard + " ERRO: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	
}
