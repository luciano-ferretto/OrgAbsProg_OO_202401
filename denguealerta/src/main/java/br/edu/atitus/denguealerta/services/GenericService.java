package br.edu.atitus.denguealerta.services;

import java.util.ArrayList;
import java.util.List;

import br.edu.atitus.denguealerta.entities.GenericEntity;

public abstract class GenericService<E extends GenericEntity> {
	
	public abstract void validate(E objeto) throws Exception;
	
	public void save(E objeto) throws Exception {
		if (objeto == null)
			throw new Exception("Objeto nulo");
		validate(objeto);
		//TODO invocar metodo save do repostiory
	}

}
