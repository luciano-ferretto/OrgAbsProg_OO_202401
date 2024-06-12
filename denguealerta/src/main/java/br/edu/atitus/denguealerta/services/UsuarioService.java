package br.edu.atitus.denguealerta.services;

import br.edu.atitus.denguealerta.components.Validador;
import br.edu.atitus.denguealerta.entities.UsuarioEntity;


public class UsuarioService extends GenericService<UsuarioEntity> {

	@Override
	public void validate(UsuarioEntity objeto) throws Exception {
		if (objeto.getNome() == null || objeto.getNome().isEmpty())
			throw new Exception("Nome informado inválido");
		if (objeto.getEmail() == null || objeto.getEmail().isEmpty())
			throw new Exception("E-mail informado inválido");
		if (objeto.getEndereco() == null || objeto.getEndereco().isEmpty())
			throw new Exception("Endereço informado inválido");
		if (objeto.getCpf() == null || objeto.getCpf().isEmpty())
			throw new Exception("CPF informado inválido");
		if (objeto.getSenha() == null || objeto.getSenha().isEmpty())
			throw new Exception("Senha informada inválida");
		
		if (!Validador.validaCPF(objeto.getCpf()))
			throw new Exception("CPF informado inválido");
		if (!Validador.validaEmail(objeto.getEmail()))
			throw new Exception("E-mail informado inválido");
		
		//TODO validar cpf já existente
		//TODO validar email já existente
	}
	
	

}
