package br.edu.atitus.denguealerta.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.atitus.denguealerta.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends GenericRepository<UsuarioEntity>{
	
	boolean existsByCpf(String cpf);
	
	boolean existsByEmail(String email);
	
	boolean existsByCpfAndIdNot(String cpf, UUID id);
	
	boolean existsByEmailAndIdNot(String email, UUID id);
	
	Optional<UsuarioEntity> findByEmail(String email);

}
