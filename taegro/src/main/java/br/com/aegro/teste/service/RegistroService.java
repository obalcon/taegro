package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import br.com.aegro.teste.modelo.Registro;

public interface RegistroService {

    List <Registro> findAll();

    void save(Registro talhao);

    Optional <Registro> findById(Long id);

    void delete(long id);
    
}

