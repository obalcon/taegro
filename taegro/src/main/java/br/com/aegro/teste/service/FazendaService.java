package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.aegro.teste.modelo.Fazenda;

public interface FazendaService {

    Page <Fazenda> findAll(Pageable paginacao);

    void save(Fazenda fazenda);

    Optional <Fazenda> findById(Long id);

    void delete(long id);
    
	Page<Fazenda> findByNome(String nome, Pageable paginacao);
	
	Long getTotalProdFaz(Fazenda id);
	
	List<Fazenda> findTodos();
	
	 Fazenda findByNome(String nome);
}
