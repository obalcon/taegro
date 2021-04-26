package br.com.aegro.teste.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.aegro.teste.modelo.Registro;
import br.com.aegro.teste.modelo.Talhao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistroServiceTest {

	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private TalhaoService talhaoService;
		
	@Test
	public void findByIdTest() {
		
	    Optional <Registro> lista = registroService.findById(new Long(2));
	    Registro reg = lista.get();
	    assertThat(reg.getId()).isEqualTo(2);
	}
	@Test
	public void  testfindAll() {
		
		List<Registro> lista = registroService.findAll();
		int totalReg = lista.size();
		// 4 é total de registros inseridos na criação da base  
		assertThat(totalReg).isEqualTo(4);
	}
	
	@Test
	public void testSave() {
		Optional<Talhao> tal = talhaoService.findById(new Long(1));
		Talhao talhao = tal.get();
		Registro registro = new Registro();
		registro.setRegistro(100);
		registro.setTalhao(talhao);
		
		registroService.save(registro);
		
		Optional<Registro> lista = registroService.findById(new Long(5));
		Registro novoReg = lista.get();
		
		// 4 é total de registros inseridos na criação da base +1 5 
		// seria o total após a inclusão. ID tb  é 5
		assertThat(novoReg.getId()).isEqualTo(5);
		
	}
	

	@Test
	public void delete() {
		Optional <Registro> lista = registroService.findById(new Long(1));
	    Registro reg = lista.get();
	    registroService.delete(reg.getId());
	    Optional <Registro> list = registroService.findById(reg.getId());
	    assertThat(list).isEmpty();
		
	}
	
}
