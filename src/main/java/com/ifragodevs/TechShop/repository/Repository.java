package com.ifragodevs.TechShop.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

	List<T> listar() throws SQLException;
	
	T findById(Integer id) throws SQLException;
	
	void save(T t) throws SQLException;
	
	void eliminar(Integer id) throws SQLException;
}
