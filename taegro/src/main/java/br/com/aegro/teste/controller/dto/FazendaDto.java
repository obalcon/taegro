package br.com.aegro.teste.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;

public class FazendaDto {

	private Long id;
	private String nome;
	private List<TalhaoDto> talhoes;

	
	public FazendaDto(Fazenda fazenda) {
		this.id = fazenda.getId();
		this.nome = fazenda.getNome();
		this.talhoes = this.convertTalhao(fazenda.getTalhoes());
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	public static Page<FazendaDto> converter(Page<Fazenda> fazendas) {
		return fazendas.map(FazendaDto::new);
	}


	public List<TalhaoDto> getTalhoes() {
		return talhoes;
	}


	public void setTalhoes(List<TalhaoDto> talhoes) {
		this.talhoes = talhoes;
	}

	public List<TalhaoDto> convertTalhao(List<Talhao> talhoes) {
		List<TalhaoDto> result = new ArrayList<TalhaoDto>();
		for (Talhao talhao : talhoes) {
			result.add(new TalhaoDto(talhao));
		}
		return result;
	}
	

}
