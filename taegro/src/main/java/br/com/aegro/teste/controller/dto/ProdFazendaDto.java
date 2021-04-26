package br.com.aegro.teste.controller.dto;

public class ProdFazendaDto {
	
	private String nomeFazenda;
	private String codigoFazenda;
	private Long  totalFazenda;
	
	
	public String getNomeFazenda() {
		return nomeFazenda;
	}
	public void setNomeFazenda(String nomeFazenda) {
		this.nomeFazenda = nomeFazenda;
	}
	public String getCodigoFazenda() {
		return codigoFazenda;
	}
	public void setCodigoFazenda(String codigoFazenda) {
		this.codigoFazenda = codigoFazenda;
	}
	public Long getTotalFazenda() {
		return totalFazenda;
	}
	public void setTotalFazenda(Long totalFazenda) {
		this.totalFazenda = totalFazenda;
	}
	

}
