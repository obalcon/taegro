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
public class FazendaServiceTest  {

    
    @Autowired
    private FazendaService fazendaService;
    
    @Autowired
    private TalhaoService talhaoService;
    
    
    @Test
    public void FindByName_thenReturnFazenda() {
      
        Fazenda fazenda = new Fazenda();
        fazenda.setNome("Fazenda_teste");
 
        fazendaService.save(fazenda);
        
        Fazenda faz = fazendaService.findByNome(fazenda.getNome());
        
      
        assertThat(faz.getNome()).isEqualTo(fazenda.getNome());
    }
    @Test
    public void findTodos() {
      
        List<Fazenda> lista = fazendaService.findTodos();
        Integer conta = lista.size();        
        assertThat(conta).isEqualTo(2);
    }
    @Test
    public void findById() {
    	Long id = new Long(1);
    	Optional<Fazenda> lista = fazendaService.findById(id);
    	Fazenda fazenda = lista.get();
    	assertThat(fazenda.getNome()).isEqualTo("Fazenda_1");
     }
    @Test
    public void delete() {
    	
        Fazenda fazenda = new Fazenda();
        fazenda.setNome("Fazenda_teste");
        fazendaService.save(fazenda);
        
        Fazenda faz = fazendaService.findByNome(fazenda.getNome());
    	
        
    	fazendaService.delete(faz.getId());
    	
    	Optional<Fazenda> listaN = fazendaService.findById(faz.getId());
    	
    	assertThat(listaN).isEmpty();
     }
    
    @Test
    public void totalproducao() {
    	
    	Fazenda fazenda = fazendaService.findByNome("Fazenda_1");
    	/*Fiz esta carga pois , fazenda não traz os a talhoes(lazy) no junit a conexao e fechada 
    	 * como é somente um teste optei por carregar a lista por fora 
    	 *  */
    	List<Talhao> listaT = talhaoService.findByFazenda(fazenda);
    	
        fazenda.setTalhoes(listaT);
    	Long producao =  fazendaService.getTotalProdFaz(fazenda);
	   
    	assertThat(producao).isEqualTo(30);
    	
    }
}
