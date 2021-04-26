package br.com.aegro.teste.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aegro.teste.modelo.Fazenda;
import br.com.aegro.teste.modelo.Talhao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TalhaoServiceTest {
	
	  @Autowired
	  private TalhaoService talhaoService;
	    
	    @Autowired
	    private FazendaService fazendaService;
	    
	  public void findAllTest() {
	   List<Talhao> lista = talhaoService.findAll();
	   
	   Integer conta = lista.size();        
       assertThat(conta).isEqualTo(2);
	  }
	  @Test
	    public void FindByName_thenReturnTalhao() {
	      
	        Talhao  talhao = new Talhao();
	        Optional<Fazenda> faz = fazendaService.findById(new Long(1));
	    
	        Fazenda fazenda = faz.get();
	        talhao.setFazenda(fazenda);
	        talhao.setArea(100);
	      
	        talhaoService.save(talhao);
	        
	        Optional<Talhao> ta = talhaoService. findById(new Long(5));
	        Talhao tal = ta.get();
	      
	        assertThat(tal.getId()).isEqualTo(5);
	    }
	   
	    @Test
	    public void findById() {
	    	Long id = new Long(1);
	    	Optional<Talhao> lista = talhaoService.findById(id);
	    	Talhao tal = lista.get();
	    	assertThat(tal.getId()).isEqualTo(1);
	     }
	    @Test
	    public void delete() {
	    
	        Talhao  talhao = new Talhao();
	        Optional<Fazenda> faz = fazendaService.findById(new Long(1));
	    
	        Fazenda fazenda = faz.get();
	        talhao.setFazenda(fazenda);
	        talhao.setArea(100);
	      
	        talhaoService.save(talhao);
	        
	        Optional<Talhao> tal = talhaoService. findById(new Long(5));
	        
	        talhaoService.delete(tal.get().getId());
	        
	        Optional<Talhao> talh = talhaoService. findById(new Long(5));
		      
	        
	     	assertThat(talh).isEmpty();
	     }
	    
	    @Test
	    public void totalDoTalhao() {
	    	Optional<Talhao> tal = talhaoService.findById(new Long(1));
	    	Long producao =  talhaoService.getTotalProd(tal.get());
	    	assertThat(producao).isEqualTo(10);
	    }
	  
}
