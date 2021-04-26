package br.com.aegro.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aegro.teste.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
