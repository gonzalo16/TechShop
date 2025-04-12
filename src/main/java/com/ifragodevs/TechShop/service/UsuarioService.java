package com.ifragodevs.TechShop.service;

import java.util.Optional;

import com.ifragodevs.TechShop.entity.Usuario;

public interface UsuarioService {

	Optional<Usuario> findByUsernameAndPassword(String username, String password);
}
