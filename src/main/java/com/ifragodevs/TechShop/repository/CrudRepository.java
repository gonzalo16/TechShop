package com.ifragodevs.TechShop.repository;

import java.util.List;

public interface CrudRepository<T> {

	List<T> listar() throws Exception;
	
	T findById(Integer id) throws Exception;
	
	void save(T t) throws Exception;
	
	void eliminar(Integer id) throws Exception;
}
