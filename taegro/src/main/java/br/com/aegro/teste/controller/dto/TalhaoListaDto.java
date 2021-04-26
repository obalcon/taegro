package br.com.aegro.teste.controller.dto;

import java.util.List;

public class TalhaoListaDto {
	
	private List<TalhaoDto> listaTalhoes;
	
	
	
	public TalhaoListaDto(List<TalhaoDto> listaTalhoes) {
		
		this.listaTalhoes = listaTalhoes;
	}

	public List<TalhaoDto> getLista() {
		return listaTalhoes;
	}

	public void setLista(List<TalhaoDto> listaTalhoes) {
		this.listaTalhoes = listaTalhoes;
	}

	
}
