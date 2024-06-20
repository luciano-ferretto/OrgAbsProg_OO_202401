package br.edu.atitus.denguealerta.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.atitus.denguealerta.entities.GenericEntity;
import br.edu.atitus.denguealerta.repositories.GenericRepository;

public abstract class GenericService<E extends GenericEntity> {
	
	public abstract void validate(E objeto) throws Exception;
	
	protected abstract GenericRepository<E> getRepository();
	
	public final Page<E> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}
	
	public final E save(E objeto) throws Exception {
		if (objeto == null)
			throw new Exception("Objeto nulo");
		validate(objeto);
		return getRepository().save(objeto);
	}
	
	

}
