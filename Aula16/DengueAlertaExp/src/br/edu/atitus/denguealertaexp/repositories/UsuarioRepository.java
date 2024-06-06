package br.edu.atitus.denguealertaexp.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import br.edu.atitus.denguealertaexp.entities.UsuarioEntity;

public class UsuarioRepository {
	private Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/denguealertaexp";
		String username = "postgres";
		String password = "postgres";
		return DriverManager.getConnection(url, username, password);
	}
	
	public UsuarioEntity save(UsuarioEntity usuario) throws Exception {
		if (usuario.getId() == null)
			usuario.setId(UUID.randomUUID());
		
		String sql = "insert into usuario (nome, email, endereco, cpf, senha, tipo, id)"
				+ " values (?, ?, ?, ?, ?, ?, ?)";

		Connection con = getConnection();
		PreparedStatement pst;
		pst = con.prepareStatement(sql);
		pst.setString(1, usuario.getName());
		pst.setString(2, usuario.getEmail());
		pst.setString(3, usuario.getEndereco());
		pst.setString(4, usuario.getCpf());
		pst.setString(5, usuario.getSenha());
		pst.setInt(6, usuario.getTipoUsuario());
		pst.setObject(7, usuario.getId());

		pst.executeUpdate();
		return usuario;
	}

}
