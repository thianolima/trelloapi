package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.ActionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			log.error("RelatorioController - listar: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	
}
