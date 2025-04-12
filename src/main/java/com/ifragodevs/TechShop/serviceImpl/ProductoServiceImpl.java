package com.ifragodevs.TechShop.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.configs.ProductoServicePrincipal;
import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.repository.Repository;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
@ProductoServicePrincipal
public class ProductoServiceImpl implements ProductoService{
	
	@Inject
	private Repository<Producto> productoRepository;
	
	@Inject
	private Repository<Categoria> categoriaRepository;
	
	
	@Override
	public List<Producto> listar() throws SQLException {
		return productoRepository.listar();
	}


	@Override
	public void save(Producto producto) throws SQLException {
		productoRepository.save(producto);
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
		productoRepository.eliminar(id);
	}


	@Override
	public Producto findById(Integer id) throws SQLException {
		return productoRepository.findById(id);
	}


}
