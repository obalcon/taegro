package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aegro.teste.modelo.Registro;
import br.com.aegro.teste.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
    private RegistroRepository registroRepository;
	
	@Override
	public List<Registro> findAll() {
		// TODO Auto-generated method stub
		 return registroRepository.findAll();
    
	}

	@Override
	public void save(Registro talhao) {
		// TODO Auto-generated method stub
		registroRepository.save(talhao);
	}

	@Override
	public Optional<Registro> findById(Long id) {
		// TODO Auto-generated method stub
		 return registroRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		registroRepository.deleteById(id);
	}
	
	

}
