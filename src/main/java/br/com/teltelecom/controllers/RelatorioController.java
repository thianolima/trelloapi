package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.RelatorioService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/trello/relatorios")
public class RelatorioController {
	
	@Autowired
	RelatorioService service;
	
	@GetMapping(value= "/boards/{idboard}")
	public ResponseEntity<?> listar(@PathVariable String idboard) {	
		try {
			return ResponseEntity.ok(service.listar(idboard));
		}catch(Exception e) {
			log.error("RelatorioController: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
}
