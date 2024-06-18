package br.edu.atitus.denguealerta.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.denguealerta.components.TipoUsuario;
import br.edu.atitus.denguealerta.dtos.SigninDTO;
import br.edu.atitus.denguealerta.dtos.SignupDTO;
import br.edu.atitus.denguealerta.entities.UsuarioEntity;
import br.edu.atitus.denguealerta.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UsuarioService usuarioService;
	private final AuthenticationConfiguration auth;
	
	public AuthController(UsuarioService usuarioService, AuthenticationConfiguration auth) {
		super();
		this.usuarioService = usuarioService;
		this.auth = auth;
	}
	
	
	@PostMapping("/signin")
	public String signin(@RequestBody SigninDTO signinDTO) {
		try {
			auth.getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(signinDTO.getEmail(), signinDTO.getSenha()));
		} catch (Exception e) {
			return "Falha na Autenticação";
		}
		return "Autenticado";
	}

	@PostMapping("/signup")
	public String signup(@RequestBody SignupDTO signupDTO) {
		UsuarioEntity novoUsuario = new UsuarioEntity();
		BeanUtils.copyProperties(signupDTO, novoUsuario);
		novoUsuario.setTipo(TipoUsuario.Cidadao);
		try {
			usuarioService.save(novoUsuario);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	
	

}
