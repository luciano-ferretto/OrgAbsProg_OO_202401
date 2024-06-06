package br.edu.atitus.denguealertaexp.services;

import br.edu.atitus.denguealertaexp.entities.UsuarioEntity;
import br.edu.atitus.denguealertaexp.repositories.UsuarioRepository;

public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		this.usuarioRepository = new UsuarioRepository();
	}
	
	public UsuarioEntity save(UsuarioEntity usuario) throws Exception {
		if (usuario == null)
			throw new Exception("Objeto nulo");
		if (usuario.getName() == null || usuario.getName().isEmpty())
			throw new Exception("Nome inválido");
		
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty())
			throw new Exception("E-mail inválido");
		
		if (usuario.getEndereco() == null || usuario.getEndereco().isEmpty())
			throw new Exception("Endereço inválido");
		
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty())
			throw new Exception("Senha inválido");
		
		if (usuario.getCpf() == null || usuario.getCpf().isEmpty())
			throw new Exception("CPF inválido");
		
		if (usuario.getTipoUsuario() < 0 || usuario.getTipoUsuario() > 2)
			throw new Exception("Tipo de usuário inválido");
		
		return usuarioRepository.save(usuario);
	}

	
	
	
	
	
	
	
}
