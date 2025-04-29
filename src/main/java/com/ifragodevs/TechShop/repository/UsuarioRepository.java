package com.ifragodevs.TechShop.repository;

import com.ifragodevs.TechShop.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario>{

	Usuario findByUsername(String username) throws Exception;
}
