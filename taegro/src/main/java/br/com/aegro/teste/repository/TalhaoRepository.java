package br.com.aegro.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;

public interface TalhaoRepository extends JpaRepository<Talhao, Long> {
	
	public List<Talhao>findByFazenda(Fazenda fazenda);

}
