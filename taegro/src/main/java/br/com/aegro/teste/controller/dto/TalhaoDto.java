package br.com.aegro.teste.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.aegro.teste.modelo.Registro;
import br.com.aegro.teste.modelo.Talhao;

public class TalhaoDto {
	
	private Long id;
	private Integer area;
	private Long idFazenda;
	private String nomeFazenda;
	private List<RegistroDto> registros;
	
	
	public TalhaoDto (Talhao talhao) {
		this.id = talhao.getId();
		this.area = talhao.getArea();
		this.idFazenda = talhao.getFazenda().getId();
		this.nomeFazenda = talhao.getFazenda().getNome();
		this.registros = this.converter(talhao.getRegistros());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public List<RegistroDto> getRegistros() {
		return registros;
	}
	public void setRegistros(List<RegistroDto> registros) {
		this.registros = registros;
	}
	public List<RegistroDto>  converter (List<Registro> listaR) {
		List<RegistroDto> result = new ArrayList<RegistroDto>();
		for (Registro registro : listaR) {
			 RegistroDto registroDto = new  RegistroDto(registro);
			 result.add(registroDto);
		}
		return result;
	}
	public Long getIdFazenda() {
		return idFazenda;
	}
	public void setIdFazenda(Long idFazenda) {
		this.idFazenda = idFazenda;
	}
	public String getNomeFazenda() {
		return nomeFazenda;
	}
	public void setNomeFazenda(String nomeFazenda) {
		this.nomeFazenda = nomeFazenda;
	}
	
}
