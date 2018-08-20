package br.com.teltelecom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teltelecom.entities.ActionEntity;

@Service
public class IndicadorService {

	@Autowired
	ActionService actionService;
	
	//0001
	public int totalEnvioParaQA(String idcard) {
		try {
			int qtd=0;
			for(ActionEntity dto : actionService.listar(idcard)) {			
				if (dto.getData().getListAfter() != null) {
					if((dto.getData().getListAfter().getName().contains("QA/Testes")) &&
					   (!dto.getData().getListBefore().getName().contains("QA/Testes"))){
							qtd++;
					}
				}		
			}			
			return qtd;
		}catch(RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
