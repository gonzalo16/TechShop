package com.ifragodevs.TechShop.repository;

import java.sql.SQLException;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;

public interface CategoriaRepository {

	List<Categoria> listar() throws SQLException;
}
