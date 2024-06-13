package br.edu.atitus.denguealerta.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.atitus.denguealerta.entities.GenericEntity;

public interface GenericRepository<E extends GenericEntity> 
	extends JpaRepository<E, UUID>{

}
