package com.ifragodevs.TechShop.repository;

import java.sql.SQLException;

import com.ifragodevs.TechShop.entity.Usuario;

public interface UsuarioRepository extends Repository<Usuario>{

	Usuario findByUsername(String username) throws SQLException;
}
