package br.com.teltelecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.teltelecom.services.IndicadorService;

@RestController
@RequestMapping("/trello/indicadores")
public class IndicadorController {

	@Autowired
	IndicadorService service;
	
	@GetMapping(params= {"idcard","idIndicador"})
	public ResponseEntity<?> listar(@RequestParam String idcard, @RequestParam String idIndicador) {
		
		if(idIndicador.equals("0001")) {
			try {									
				return ResponseEntity.ok(service.totalEnvioParaQA(idcard));
			}catch(RuntimeException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		}
		
		return ResponseEntity.badRequest().body("Código de identificador não encontrado: " + idIndicador);
	}
}
