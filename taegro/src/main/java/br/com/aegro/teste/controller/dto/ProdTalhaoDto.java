package br.com.aegro.teste.controller.dto;

public class ProdTalhaoDto {

	private Long id;
	private Long fazenda;
	private Long total; 

    public ProdTalhaoDto() {}
	
    public ProdTalhaoDto(Long id , Long fazenda, Long total) {
		this.id = id;
		this.fazenda = fazenda;
		this.total = total;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getFazenda() {
		return fazenda;
	}


	public void setFazenda(Long fazenda) {
		this.fazenda = fazenda;
	}


	public Long getTotal() {
		return total;
	}


	public void setTotal(Long total) {
		this.total = total;
	}
    
}
