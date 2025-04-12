package com.ifragodevs.TechShop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.anotations.RepositoryAnnotation;
import com.ifragodevs.TechShop.entity.Usuario;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@RepositoryAnnotation
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@Inject
	@Named("connBean")
	private Connection conn;
	
	@Override
	public List<Usuario> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Usuario t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findByUsername(String username) throws SQLException {
		Usuario usuario = null;
		
		try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE username=?")){
			stmt.setString(1, username);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setUsername(rs.getString("username"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
				}
			}
		}
		return usuario;
	}

}
