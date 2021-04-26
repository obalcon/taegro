package br.com.aegro.teste.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aegro.teste.controller.dto.FazendaDto;
import br.com.aegro.teste.controller.dto.ProdFazendaDto;
import br.com.aegro.teste.controller.dto.ProdTalhaoDto;
import br.com.aegro.teste.controller.dto.ProdTotalFazendaDto;
import br.com.aegro.teste.controller.dto.RegistroDto;
import br.com.aegro.teste.controller.dto.TalhaoDto;
import br.com.aegro.teste.controller.dto.TalhaoListaDto;
import br.com.aegro.teste.controller.form.RegistroForm;
import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Registro;
import br.com.aegro.teste.modelo.Talhao;
import br.com.aegro.teste.service.FazendaService;
import br.com.aegro.teste.service.RegistroService;
import br.com.aegro.teste.service.TalhaoService;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
	
	@Autowired
	private FazendaService fazendaService;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private TalhaoService talhaoService;
	
	@GetMapping("/lista")
	@Cacheable(value = "listaFazenda")
	public Page<FazendaDto> lista(@RequestParam(required = false) String nome, 
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		if (nome == null) {
			Page<Fazenda> fazendas = fazendaService.findAll(paginacao);
			return FazendaDto.converter(fazendas);
		} else {
			Page<Fazenda> fazendas = fazendaService.findByNome(nome, paginacao);
			return FazendaDto.converter(fazendas);
		}
	}
	@GetMapping("/prodtotalfazenda")
	public ResponseEntity<ProdTotalFazendaDto> getTotalProdFazenda() {
		    List<Fazenda> fazendas = fazendaService.findTodos();
		    Long total = new Long(0);
		    List<ProdFazendaDto> fazendasdto = new ArrayList<ProdFazendaDto>();
		    if(!fazendas.isEmpty()){
		    	for (Fazenda fazenda : fazendas) {
		    		total = fazendaService.getTotalProdFaz(fazenda);
			    	ProdFazendaDto prodFazenda = new ProdFazendaDto();
			    	prodFazenda.setCodigoFazenda(fazenda.getId().toString());
			    	prodFazenda.setNomeFazenda(fazenda.getNome());
			    	prodFazenda.setTotalFazenda(total);
			    	fazendasdto.add(prodFazenda);
				}
		    	ProdTotalFazendaDto prodTotalFazendaDto = new ProdTotalFazendaDto(fazendasdto);
		    	return ResponseEntity.ok(prodTotalFazendaDto);
	
		    }
		    return ResponseEntity.notFound().build();
	}
	/* Total produzido por uma fazenda */
	@GetMapping("/prodfazenda")
	public ResponseEntity<ProdFazendaDto> getProdFazenda(@RequestParam(required = true)String id) {
		try { 
		Optional<Fazenda> oFazenda = fazendaService.findById(Long.parseLong(id));
		    Long total = new Long(0);
		    if(oFazenda.isPresent()){
		    	Fazenda fazenda = (Fazenda)oFazenda.get();
		    	total = fazendaService.getTotalProdFaz(fazenda);
		    	ProdFazendaDto prodFazenda = new ProdFazendaDto();
		    	prodFazenda.setCodigoFazenda(fazenda.getId().toString());
		    	prodFazenda.setNomeFazenda(fazenda.getNome());
		    	prodFazenda.setTotalFazenda(total);
		    	return ResponseEntity.ok(prodFazenda);
		    }
		    return ResponseEntity.notFound().build();
		}catch(Exception e ) {
		    return ResponseEntity.notFound().build();
		}
	}
	/*  Valor produzido por um talhao */
	@GetMapping("/prodtalhao")
	public ResponseEntity<ProdTalhaoDto> getProdTalhao(@RequestParam(required = true)String id) {
		    Optional<Talhao> oTalhao = talhaoService.findById(Long.parseLong(id));
		    if(oTalhao.isPresent()) {
		    	Talhao talhao = (Talhao)oTalhao.get();
				Long total = talhaoService.getTotalProd(talhao);
				ProdTalhaoDto prodTalhaoDto = new ProdTalhaoDto(talhao.getId(),talhao.getFazenda().getId(),total);
				return ResponseEntity.ok(prodTalhaoDto);
		    }
	
		    return ResponseEntity.notFound().build();
	}

	/* Registro  valor produzido por um talhao  */
	@PostMapping("/novoregistro")
	@Transactional
	public ResponseEntity<RegistroDto> cadastrar(@RequestBody @Valid RegistroForm form, UriComponentsBuilder uriBuilder) {
		Registro registro = form.converter(talhaoService);
		registroService.save(registro);
		
		URI uri = uriBuilder.path("/fazenda/{id}").buildAndExpand(registro.getId()).toUri();
		return ResponseEntity.created(uri).body(new RegistroDto(registro));
	}
	
	/* Lista de info dos talhoes e seus registros */
	@GetMapping("/listatalhoes")
	public ResponseEntity<TalhaoListaDto> listatalhoes() {
		    List<Talhao> talhoes = talhaoService.findAll();
		    List<TalhaoDto> listaT = new  ArrayList<TalhaoDto>();
		   
	
		    if(!talhoes.isEmpty()){
		    	for (Talhao talhao : talhoes) {
		    		TalhaoDto talhaoDto = new TalhaoDto(talhao);
		    		listaT.add(talhaoDto);
				}
		    	TalhaoListaDto lista = new TalhaoListaDto(listaT);
		    	return ResponseEntity.ok(lista);
	
		    }
		    return ResponseEntity.notFound().build();
	}

	
	
}