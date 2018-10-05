package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.RelatorioService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/trello/relatorio")
public class RelatorioController {
	
	@Autowired
	RelatorioService service;
	
	@GetMapping(params= {"idboard"})
	public ResponseEntity<?> listar(@RequestParam String idboard) {	
		try {
			return ResponseEntity.ok(service.listar(idboard));
		}catch(Exception e) {
			log.error("RelatorioController: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
}
