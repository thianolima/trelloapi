package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("trello/boards")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		try {									
			return ResponseEntity.ok(service.listar());
		}catch(RuntimeException e) {
			log.error("RelatorioController - listar: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
