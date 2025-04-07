package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.serviceImpl.ProductoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Connection conn = (Connection) req.getAttribute("conexion");
			ProductoServiceImpl productoService = new ProductoServiceImpl(conn);
			req.setAttribute("categorias", productoService.listarCategoria());
			Integer idProducto;
			try{
				idProducto = Integer.valueOf(req.getParameter("id"));
			}catch(NumberFormatException e) {
				idProducto = 0;
			}
			
			//Buscamos el producto a la bbdd
			Producto producto = new Producto();
			producto.setCategoria(new Categoria());
			if(idProducto > 0) {
				try {
					producto = productoService.findById(idProducto);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			req.setAttribute("producto", producto);
			getServletContext().getRequestDispatcher("/productForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = (Connection) req.getAttribute("conexion");
		ProductoServiceImpl productoService = new ProductoServiceImpl(conn);
		
		//OBTENCION DE DATOS
		String nombre = req.getParameter("nombre");
		String id_categoriaStr = req.getParameter("categoria");
		Integer id_categoria = 0;
		Integer precio = null;
		
		try {
			precio = Integer.valueOf(req.getParameter("precio"));
		}catch(NumberFormatException e) {
			precio = 0;
		}
		String sku = req.getParameter("sku");
		String fecha_str = req.getParameter("fecha_registro");
		
		//OBTENCION CATEGORIA ID
		if(id_categoriaStr != null && !id_categoriaStr.isEmpty()) {
			id_categoria = Integer.parseInt(id_categoriaStr);
		}
		
		/*Validaciones*/
		Map<String,String> errores = new HashMap<>();
		if(nombre == null || nombre.isEmpty()) {
			errores.put("nombre","el nombre no puede ser vacio");
		}
		if(sku == null || sku.isBlank()) {
			errores.put("sku", "el sku no puede ser vacio");
		}
		if(fecha_str == null || fecha_str.isBlank()) {
			errores.put("fecha_registro", "fecha no puede ser vacio");
		}
		if(precio.equals(0)) {
			errores.put("precio", "precio es requerido");
		}
		if(id_categoria.equals(0)) {
			errores.put("categoria", "la categoria es requerida!");
		}

		
		LocalDate fecha;
		try {
			fecha = LocalDate.parse(fecha_str,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}catch(DateTimeParseException e) {
			fecha = null;
		}
		
		Producto nuevoProducto = new Producto();
		Categoria categoriaSeleccioada = new Categoria();
		categoriaSeleccioada.setId(id_categoria);
		
		nuevoProducto.setNombre(nombre);
		nuevoProducto.setPrecio(precio);
		nuevoProducto.setSku(sku);
		nuevoProducto.setFechaRegistro(fecha);
		nuevoProducto.setCategoria(categoriaSeleccioada);
		
		
		if(errores.isEmpty()) {
			//Si errores esta vacio significa que estan los campos llenos
			try {
				productoService.save(nuevoProducto);
				resp.sendRedirect(req.getContextPath() + "/productos");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			req.setAttribute("errores", errores);
			req.setAttribute("categorias", productoService.listarCategoria());
			req.setAttribute("producto", nuevoProducto);
			getServletContext().getRequestDispatcher("/productForm.jsp").forward(req, resp);
		}
		
	}
	

}
