package br.edu.atitus.denguealertaexp.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

import br.edu.atitus.denguealertaexp.entities.UsuarioEntity;
import br.edu.atitus.denguealertaexp.services.UsuarioService;

public class UsuarioAutoCadastro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite seu e-mail: ");
		String email = scan.nextLine();
		System.out.println("Digite seu endereço: ");
		String endereco = scan.nextLine();
		System.out.println("Digite sua senha: ");
		String senha = scan.nextLine();
		System.out.println("Digite seu CPF: ");
		String cpf = scan.nextLine();
		
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setName(nome);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		usuario.setSenha(senha);
		usuario.setCpf(cpf);
		usuario.setTipoUsuario(2);

		UsuarioService usuarioService = new UsuarioService();
		
		try {
			usuarioService.save(usuario);
			System.out.println("Usuário cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
