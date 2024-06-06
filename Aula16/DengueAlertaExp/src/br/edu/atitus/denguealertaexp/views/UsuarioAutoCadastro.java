package br.edu.atitus.denguealertaexp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

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
		
		String url = "jdbc:postgresql://localhost:5432/denguealertaexp";
		String username = "postgres";
		String password = "postgres";
		
		String sql = "insert into usuario (nome, email, endereco, cpf, senha, tipo, id)"
				+ " values (?, ?, ?, ?, ?, ?, ?)";
		
		Connection con;
		PreparedStatement pst;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, email);
			pst.setString(3, endereco);
			pst.setString(4, cpf);
			pst.setString(5, senha);
			pst.setInt(6, 2);
			pst.setObject(7, UUID.randomUUID());
			
			int linhasAfetadas = pst.executeUpdate();
			if (linhasAfetadas > 0)
				System.out.println("Cadastro realizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
