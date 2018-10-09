package br.com.teltelecom.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teltelecom.dtos.RelatorioDto;
import br.com.teltelecom.entities.ActionEntity;
import br.com.teltelecom.entities.CardEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelatorioService {

	@Autowired
	BoardService boardService;
	
	@Autowired
	CardService cardService;
	
	public List<RelatorioDto> listar(String idBoard) {
		try {
			List<RelatorioDto> dtos = new ArrayList<RelatorioDto>();
			
			CardEntity[] cards = boardService.listarCards(idBoard);				
			for(CardEntity card : cards) {
				if(card.getDue() != null) {
					RelatorioDto dto = new RelatorioDto();
					
					dto.setIdCard(card.getId());
					dto.setDescricao(card.getName());
					dto.setShortUrl(card.getShortUrl());
					dto.setDataEntrega(card.getDue());
					dto.setEmergencial(card.getName().contains("#Emergencial!"));					
					dto.setDataInicioQA(encontrarDataInicioQA(card.getId()));
					dto.setHorasGastas(somarHorasGastas(card.getId()));
					dto.setTotalEnvioQA(totalEnvioParaQA(card.getId()));
					
					if(!dto.getEmergencial()) {
						dto.setHorasEstimada(encontrarHorasEstimadas(card.getId()));
					} else {
						dto.setHorasEstimada(dto.getHorasGastas());
					}
					
					dto.setMembros(cardService.listarMembros(card.getId()));
					
					dtos.add(dto);
				}
			}

			return dtos;
		}catch(Exception e) {
			log.error("RelatorioService Listar: idboard = " + idBoard + " ERRO: " + e.getMessage());			
			return null;
		}		
	}
	
	private Date encontrarDataInicioQA(String idCard) {
		try {
			ActionEntity[] actions = cardService.listarAcoes(idCard);
			for(ActionEntity action : actions) {
				if(action.getData().getListAfter() != null) {
					if(action.getData().getListAfter().getName().equals("QA/Testes")) {
						return action.getDate();
					}
				}
			}			
			return null;
		}catch(Exception e) {
			log.error("encontrarDataInicioQA - idcard: " + idCard + " ERRO: " + e.getMessage());
			return null;
		}
	}
	
	private Double encontrarHorasEstimadas(String idCard) {
		try {
			ActionEntity[] actions = cardService.listarAcoes(idCard);
			for(ActionEntity action : actions) {
				if(action.getData().getText() != null) {
					if(action.getData().getText().contains("plus! @global 0/")) {
						String valor = action.getData().getText().substring(16);
						return Double.parseDouble(valor);
					}
				}
			}		
			return 0d;
		}catch(Exception e) {
			log.error("encontrarHorasEstimadas: - idcard: " + idCard + " ERRO: " + e.getMessage());
			return 0d;
		}
	}
	
	private Double somarHorasGastas(String idCard) {
		Double totalHoras = 0d;		
		try {
			ActionEntity[] actions = cardService.listarAcoes(idCard);
			for(ActionEntity action : actions) {
				if(action.getData().getText() != null) {
					if(action.getData().getText().contains("plus!")) {
						
						if((!action.getData().getText().contains("global")) &&
						   (!action.getData().getText().contains("etransfer"))&&
						   (!action.getData().getText().contains("reset"))) {
							
							String[] mat = action.getData().getText().split(" ");
							String valor = mat[mat.length - 1];
							valor = valor.substring(0, valor.indexOf("/"));
							totalHoras += Double.parseDouble(valor);
						}
					}
				}
			}		
		}catch(Exception e) {
			log.error("somarHorasGastas:  - idcard: " + idCard + " ERRO: " + e.getMessage());
			return totalHoras;
		}
		
		return totalHoras;
	}
	
	private int totalEnvioParaQA(String idCard) {
		int qtd = 0;
		try {
			for(ActionEntity dto : cardService.listarAcoes(idCard)) {			
				if (dto.getData().getListAfter() != null) {
					if((dto.getData().getListAfter().getName().contains("QA/Testes")) &&
					   (!dto.getData().getListBefore().getName().contains("QA/Testes"))){
							qtd++;
					}
				}		
			}			
		}catch(RuntimeException e) {
			log.error("totalEnvioParaQA:  - idcard: " + idCard + " ERRO: " + e.getMessage());
			return qtd;
		}
		
		return qtd;
	}
}
