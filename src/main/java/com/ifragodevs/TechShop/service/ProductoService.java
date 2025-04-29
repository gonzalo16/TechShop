package com.ifragodevs.TechShop.service;

import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;

public interface ProductoService{
	
	List<Producto> listar();
	
	List<Categoria> listarCategoria();
	
	Producto findById(Integer id);
	
	void eliminar(Integer id);
	
	void save(Producto producto);
}
