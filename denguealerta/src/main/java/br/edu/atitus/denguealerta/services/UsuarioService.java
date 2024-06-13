package br.edu.atitus.denguealerta.services;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.atitus.denguealerta.components.Validador;
import br.edu.atitus.denguealerta.entities.UsuarioEntity;
import br.edu.atitus.denguealerta.repositories.GenericRepository;
import br.edu.atitus.denguealerta.repositories.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<UsuarioEntity> {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected GenericRepository<UsuarioEntity> getRepository() {
		return this.usuarioRepository;
	}

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

		if (objeto.getId() != null) {
			if (usuarioRepository.existsByCpfAndIdNot(objeto.getCpf(), objeto.getId()))
				throw new Exception("Já existe usuário com este CPF");
			if (usuarioRepository.existsByEmailAndIdNot(objeto.getEmail(), objeto.getId()))
				throw new Exception("Já existe usuário com este e-mail");
		} else {
			if (usuarioRepository.existsByCpf(objeto.getCpf()))
				throw new Exception("Já existe usuário com este CPF");
			if (usuarioRepository.existsByEmail(objeto.getEmail()))
				throw new Exception("Já existe usuário com este e-mail");
		}
		// TODO validar se usuário tem permissão para o tipo escolhido
	}

}
