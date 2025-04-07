package com.ifragodevs.TechShop.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;


public class CategoriaRepositoryImpl implements CategoriaRepository{
	
	private Connection conn;
	
	public CategoriaRepositoryImpl(Connection conn) {
		this.conn = conn; 
	}

	@Override
	public List<Categoria> listar() throws SQLException {
		List<Categoria> listaCategorias = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")){
				
					while(rs.next()) {
						Categoria c = new Categoria();
						c.setId(rs.getInt("id"));
						c.setNombre(rs.getString("nombre"));
						listaCategorias.add(c);
					}
				}
		return listaCategorias;
	}

}
