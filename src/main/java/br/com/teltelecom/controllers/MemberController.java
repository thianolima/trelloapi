package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.MemberServices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/trello/members")
public class MemberController {

	@Autowired
	MemberServices service;
	
	@GetMapping(params={"idcard"})
	public ResponseEntity<?> listar(@RequestParam String idcard) {
		try {									
			return ResponseEntity.ok(service.listar(idcard));
		}catch(RuntimeException e) {
			log.error("MemberController - listar: idcard: " + idcard + " Erro: " + e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
