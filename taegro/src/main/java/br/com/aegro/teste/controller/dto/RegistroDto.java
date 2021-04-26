package br.com.aegro.teste.controller.dto;

import org.springframework.data.domain.Page;

import br.com.aegro.teste.modelo.Registro;

public class RegistroDto {

	private Long id;
	private Integer registro;
	private Long talhao_id;

	
	public RegistroDto(Registro registro) {
		this.id = registro.getId();
		this.registro = registro.getRegistro();
		this.talhao_id = registro.getTalhao().getId();
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getRegistro() {
		return registro;
	}



	public void setRegistro(Integer registro) {
		this.registro = registro;
	}



	public Long getTalhao_id() {
		return talhao_id;
	}



	public void setTalhao_id(Long talhao_id) {
		this.talhao_id = talhao_id;
	}



	public static Page<RegistroDto> converter(Page<Registro> registros) {
		return registros.map(RegistroDto::new);
	}

}
