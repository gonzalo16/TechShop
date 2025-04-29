package com.ifragodevs.TechShop.serviceImpl;

import java.util.Optional;

import com.ifragodevs.TechShop.anotations.RepositoryJpa;
import com.ifragodevs.TechShop.anotations.Service;
import com.ifragodevs.TechShop.entity.Usuario;
import com.ifragodevs.TechShop.exception.ServiceJdbException;
import com.ifragodevs.TechShop.repository.UsuarioRepository;
import com.ifragodevs.TechShop.service.UsuarioService;

import jakarta.inject.Inject;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Inject
	@RepositoryJpa
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findByUsernameAndPassword(String username, String password) {
		
		try {
			return Optional.ofNullable(usuarioRepository.findByUsername(username)).filter(usuario -> usuario.getPassword().equals(password));
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}

}
