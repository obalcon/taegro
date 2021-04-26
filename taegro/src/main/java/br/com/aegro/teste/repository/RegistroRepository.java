package br.com.aegro.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.aegro.teste.modelo.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

	@Query(value="SELECT SUM(r.registro) FROM Registro r where r.talhao.id = ?1")
	public Long selectTotalRegistro(Long id);

}
