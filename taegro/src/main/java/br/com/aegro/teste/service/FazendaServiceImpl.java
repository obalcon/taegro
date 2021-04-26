package br.com.aegro.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;
import br.com.aegro.teste.repository.FazendaRepository;

@Service
public class FazendaServiceImpl implements FazendaService {

	@Autowired
    private FazendaRepository fazendaRepository;
	
	@Autowired
    private TalhaoService talhaoRepository;
	
	@Override
	public Page<Fazenda> findAll(Pageable paginacao) {
		// TODO Auto-generated method stub
		 return fazendaRepository.findAll(paginacao);
    
	}
	public List<Fazenda> findTodos() {
		// TODO Auto-generated method stub
		 return fazendaRepository.findAll();
    
	}
	@Override
	public void save(Fazenda fazenda) {
		// TODO Auto-generated method stub
		 fazendaRepository.save(fazenda);
	}

	@Override
	public Optional<Fazenda> findById(Long id) {
		// TODO Auto-generated method stub
		 return fazendaRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		fazendaRepository.deleteById(id);
	}

	@Override
	public Page<Fazenda> findByNome(String nome, Pageable paginacao) {
		// TODO Auto-generated method stub
		 return fazendaRepository.findByNome(nome,paginacao);
	}
	
	@Override
	public Long getTotalProdFaz(Fazenda fazenda) {
		Long total = new Long(0);
		for (Talhao talhao : fazenda.getTalhoes()) {
			 total = total + talhaoRepository.getTotalProd(talhao);
		}
		return total;
	}
	 public Fazenda findByNome(String nome) {
		 return fazendaRepository.findByNome(nome);
	 }
}
