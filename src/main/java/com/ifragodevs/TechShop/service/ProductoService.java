package com.ifragodevs.TechShop.service;

import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.repository.Repository;

public interface ProductoService extends Repository<Producto>{
	
	List<Producto> listar() throws SQLException;
	
	List<Categoria> listarCategoria();
	
	void save(Producto producto) throws SQLException;
}
