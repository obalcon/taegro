package br.com.aegro.teste.controller.dto;

import java.util.List;

public class ProdTotalFazendaDto {

	List<ProdFazendaDto> fazendas;
	
	public ProdTotalFazendaDto(List<ProdFazendaDto> fazendas) {
		this.fazendas = fazendas;
	}

	public List<ProdFazendaDto> getFazendas() {
		return fazendas;
	}

	public void setFazendas(List<ProdFazendaDto> fazendas) {
		this.fazendas = fazendas;
	}
	
}
