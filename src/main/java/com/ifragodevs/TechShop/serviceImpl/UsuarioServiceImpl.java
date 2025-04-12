package com.ifragodevs.TechShop.serviceImpl;

import java.sql.SQLException;
import java.util.Optional;

import com.ifragodevs.TechShop.entity.Usuario;
import com.ifragodevs.TechShop.exception.ServiceJdbException;
import com.ifragodevs.TechShop.repository.UsuarioRepository;
import com.ifragodevs.TechShop.service.UsuarioService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository usuarioRepository;
	
	@Inject
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Optional<Usuario> findByUsernameAndPassword(String username, String password) {
		
		try {
			return Optional.ofNullable(usuarioRepository.findByUsername(username)).filter(usuario -> usuario.getPassword().equals(password));
		} catch (SQLException e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}

}
