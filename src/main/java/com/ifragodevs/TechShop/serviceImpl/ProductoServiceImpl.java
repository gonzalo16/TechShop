package com.ifragodevs.TechShop.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.repository.CategoriaRepository;
import com.ifragodevs.TechShop.repository.CategoriaRepositoryImpl;
import com.ifragodevs.TechShop.repository.ProductoRepositoryImpl;
import com.ifragodevs.TechShop.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{
	
	private ProductoRepositoryImpl repository;
	
	private CategoriaRepository categoriaRepository;
		
	public ProductoServiceImpl(Connection con) {
		repository = new ProductoRepositoryImpl(con);
		categoriaRepository = new CategoriaRepositoryImpl(con);
	}

	@Override
	public List<Producto> listar() throws SQLException {
		return repository.listar();
	}

	@Override
	public Producto findById(Integer id) throws SQLException {
		return repository.findById(id);
	}

	@Override
	public void save(Producto producto) throws SQLException {
		repository.save(producto);
	}

	@Override
	public List<Categoria> listarCategoria(){
		List<Categoria> listCategoria = null;
		try {
			listCategoria = categoriaRepository.listar();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return listCategoria;
	}

	@Override
	public void eliminar(Integer id) throws SQLException {
		repository.eliminar(id);
	}


}
