package br.com.aegro.teste.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.aegro.teste.modelo.Registro;
import br.com.aegro.teste.modelo.Talhao;
import br.com.aegro.teste.service.TalhaoService;

public class RegistroForm {

	@NotNull 
	private Integer registro;

	
	@NotNull 
	private  Long talhaoid;
	

	public Integer getRegistro() {
		return registro;
	}

	public void setRegistro(Integer registro) {
		this.registro = registro;
	}

	public Long getTalhaoid() {
		return talhaoid;
	}

	public void setTalhaoid(Long talhaoid) {
		this.talhaoid = talhaoid;
	}


	public Registro converter(TalhaoService  talhaoService) {
		Optional<Talhao> talhao  = talhaoService.findById(talhaoid);
		return new Registro(registro, talhao.get());
	}


}
