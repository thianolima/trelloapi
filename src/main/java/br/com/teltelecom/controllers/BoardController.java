package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("boards")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		try {									
			return ResponseEntity.ok(service.listar());
		}catch(RuntimeException e) {
			log.error("BoardController - listar: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value="/{idBoard}/cards")
	public ResponseEntity<?> listarCards(@PathVariable String idBoard) {
		try {									
			return ResponseEntity.ok(service.listarCards(idBoard));
		}catch(RuntimeException e) {
			log.error("BoardController - listarCards: idboard = " + idBoard + " ERRO: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value="/{idBoard}/membros")
	public ResponseEntity<?> listarMembros(@PathVariable String idBoard) {
		try {									
			return ResponseEntity.ok(service.listarMembros(idBoard));
		}catch(RuntimeException e) {
			log.error("BoardController - listarMembros: idboard = " + idBoard + " ERRO: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
