package com.ifragodevs.TechShop.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;

public class ProductoRepositoryImpl implements Repository<Producto>{

	private Connection conn;
	
	public ProductoRepositoryImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Producto> listar() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT p.*,c.nombre as categoria FROM productos as p "
					+ "INNER JOIN categorias as c ON (p.categoria_id = c.id) ORDER BY p.id ASC")){
			
				while(rs.next()) {
					Producto p = new Producto();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setPrecio(rs.getInt("precio"));
					Categoria c = new Categoria();
					c.setId(rs.getInt("categoria_id"));
					c.setNombre(rs.getString("categoria"));
					p.setCategoria(c);
					productos.add(p);
				}
			}
		
		return productos;
	}

	@Override
	public Producto findById(Integer id) throws SQLException {
		Producto p = null;
		try(PreparedStatement stmt = conn.prepareStatement("SELECT p.*,c.nombre as categoria FROM productos as p "
				+ "INNER JOIN categorias as c ON (p.categoria_id = c.id) WHERE p.id= ?")){
			
			stmt.setInt(1,id);
			
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					p = getProducto(rs);
				}
			}
		}
				
		return p;
	}

	@Override
	public void save(Producto t) throws SQLException {
		
		String query;
		
		if(t.getId() != null && t.getId() > 0) {
			query = "UPDATE productos SET nombre=?, precio=?, sku=?,categoria_id=? WHERE id=?";
		}else {
			query = "INSERT INTO productos (nombre,precio,sku,categoria_id,fecha_registro) VALUES (?,?,?,?,?)";
		}
		
		try(PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, t.getNombre());
			stmt.setInt(2, t.getPrecio());
			stmt.setString(3, t.getSku());
			stmt.setInt(4,t.getCategoria().getId());
			
			if(t.getId() != null && t.getId() > 0) {
				stmt.setInt(5, t.getId());
			}else {
				stmt.setDate(5, Date.valueOf(t.getFechaRegistro()));
			}
			
			stmt.executeUpdate();
		}
	}
	
	 private Producto getProducto(ResultSet rs) throws SQLException {
	        Producto p = new Producto();
	        p.setId(rs.getInt("id"));
	        p.setNombre(rs.getString("nombre"));
	        p.setPrecio(rs.getInt("precio"));
	        p.setSku(rs.getString("sku"));
	        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
	        
	        Categoria c = new Categoria();
	        c.setId(rs.getInt("categoria_id"));
	        c.setNombre(rs.getString("categoria"));
	        p.setCategoria(c);

	        return p;
	    }

	@Override
	public void eliminar(Integer id) throws SQLException {
		String sql = "delete from productos where id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }

	}
}
