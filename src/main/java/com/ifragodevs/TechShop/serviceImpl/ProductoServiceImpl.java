package com.ifragodevs.TechShop.serviceImpl;

import java.util.List;

import com.ifragodevs.TechShop.anotations.ProductoServicePrincipal;
import com.ifragodevs.TechShop.anotations.RepositoryJpa;
import com.ifragodevs.TechShop.anotations.Service;
import com.ifragodevs.TechShop.anotations.TransactionalJpa;
import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.exception.ServiceJdbException;
import com.ifragodevs.TechShop.interceptors.Logging;
import com.ifragodevs.TechShop.repository.CrudRepository;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.inject.Inject;

@Service
@TransactionalJpa
@ProductoServicePrincipal
public class ProductoServiceImpl implements ProductoService{
	
	@Inject
	@RepositoryJpa
	private CrudRepository<Producto> productoRepository;
	
	@Inject
	@RepositoryJpa
	private CrudRepository<Categoria> categoriaRepository;
	
	
	@Override
	@Logging
	public List<Producto> listar(){
		try {
			return productoRepository.listar();
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}


	@Override
	public void save(Producto producto){
		try {
			productoRepository.save(producto);
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Categoria> listarCategoria(){
		try {
			return categoriaRepository.listar();
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public void eliminar(Integer id){
		try {
			productoRepository.eliminar(id);
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}


	@Override
	public Producto findById(Integer id){
		try {
			return productoRepository.findById(id);
		} catch (Exception e) {
			throw new ServiceJdbException(e.getMessage(), e.getCause());
		}
	}


}
