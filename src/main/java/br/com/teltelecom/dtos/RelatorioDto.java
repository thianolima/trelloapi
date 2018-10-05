package br.com.teltelecom.dtos;

import java.util.Date;
import java.util.List;

import br.com.teltelecom.entities.MemberEntity;
import lombok.Data;

@Data
public class RelatorioDto {

	String idCard;
	String descricao;
	String shortUrl;
	Date dataInicioQA;
	Date dataEntrega;
	Boolean Emergencial;
	Double horasEstimada;
	Double horasGastas;
	int totalEnvioQA;
	
	MemberEntity[] membros;
}
