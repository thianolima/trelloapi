package br.com.teltelecom.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.teltelecom.entities.MemberEntity;
import lombok.Data;

@Data
public class RelatorioDto {

	String idCard;
	String descricao;
	String shortUrl;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date dataInicioQA;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date dataEntrega;
	
	Boolean Emergencial;
	Double horasEstimada;
	Double horasGastas;
	int totalEnvioQA;
	
	MemberEntity[] membros;
}
