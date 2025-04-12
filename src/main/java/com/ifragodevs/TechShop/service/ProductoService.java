package com.ifragodevs.TechShop.service;

import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;

public interface ProductoService{
	
	List<Producto> listar() throws SQLException;
	
	List<Categoria> listarCategoria();
	
	Producto findById(Integer id) throws SQLException;
	
	void eliminar(Integer id) throws SQLException;
	
	void save(Producto producto) throws SQLException;
}
