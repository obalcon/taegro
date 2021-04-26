package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;

public interface TalhaoService {

    List <Talhao> findAll();

    void save(Talhao talhao);

    Optional <Talhao> findById(Long id);

    void delete(long id);
    
    List<Talhao> findByFazenda(Fazenda fazenda);
    
    Long getTotalProd(Talhao talhao);
}
