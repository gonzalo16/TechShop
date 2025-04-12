package com.ifragodevs.TechShop.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ifragodevs.TechShop.anotations.RepositoryAnnotation;
import com.ifragodevs.TechShop.entity.Categoria;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@RepositoryAnnotation
public class CategoriaRepositoryImpl implements Repository<Categoria>{
	
	@Inject
	@Named("connBean")
	private Connection conn;

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

	@Override
	public Categoria findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Categoria t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
