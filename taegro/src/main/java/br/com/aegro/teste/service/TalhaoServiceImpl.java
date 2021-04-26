package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;
import br.com.aegro.teste.repository.RegistroRepository;
import br.com.aegro.teste.repository.TalhaoRepository;

@Service
public class TalhaoServiceImpl implements TalhaoService {

	@Autowired
    private TalhaoRepository talhaoRepository;
	
	@Autowired
    private RegistroRepository registroRepository;
	
	@Override
	public List<Talhao> findAll() {
		// TODO Auto-generated method stub
		 return talhaoRepository.findAll();
    
	}

	@Override
	public void save(Talhao talhao) {
		// TODO Auto-generated method stub
		talhaoRepository.save(talhao);
	}

	@Override
	public Optional<Talhao> findById(Long id) {
		// TODO Auto-generated method stub
		 return talhaoRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		talhaoRepository.deleteById(id);
	}
	public List<Talhao> findByFazenda(Fazenda fazenda){
		return talhaoRepository.findByFazenda(fazenda);
	}
	public Long getTotalProd(Talhao talhao) {
		return registroRepository.selectTotalRegistro(talhao.getId());
	}
	
}
