package br.com.aegro.teste.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aegro.teste.modelo.Fazenda;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

	Page<Fazenda> findByNome(String nome, Pageable paginacao);
		  Fazenda findByNome(String nome);
}
