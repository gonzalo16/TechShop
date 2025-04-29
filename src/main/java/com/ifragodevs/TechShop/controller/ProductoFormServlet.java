package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import com.ifragodevs.TechShop.anotations.ProductoServicePrincipal;
import com.ifragodevs.TechShop.entity.Categoria;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.exception.ServiceJdbException;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*
 * Controlador para cuando se quiere actualizar o insertar un producto
 * - Cuando se da a "editar" en la vista
 * */
@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@ProductoServicePrincipal
	private ProductoService productoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idProducto = parseInteger(req.getParameter("id"));

		// Buscamos el producto a la bbdd
		Producto producto = new Producto();
		producto.setCategoria(new Categoria());
		if (idProducto > 0) {
			try {
				producto = productoService.findById(idProducto);
			} catch (Exception e) {
				throw new ServiceJdbException(e.getMessage(), e.getCause());
			}
		}

		req.setAttribute("categorias", productoService.listarCategoria());
		req.setAttribute("producto", producto);
		getServletContext().getRequestDispatcher("/productForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// OBTENCION DE DATOS
		String nombre = req.getParameter("nombre");
		String sku = req.getParameter("sku");
		String fecha_str = req.getParameter("fecha_registro");

		Integer id_producto;
		Integer id_categoria;
		Integer precio;

		precio = parseInteger(req.getParameter("precio"));
		id_categoria = parseInteger(req.getParameter("categoria"));

		/* Validaciones */
		Map<String, String> errores = validarFormulario(nombre, sku, fecha_str, precio, id_categoria);

		LocalDate fecha = parseDate(fecha_str);

		try {
			id_producto = Integer.valueOf(req.getParameter("id"));
		} catch (NumberFormatException e) {
			id_producto = null;
		}

		Producto nuevoProducto = new Producto();

		Categoria categoriaSeleccioada = new Categoria();
		categoriaSeleccioada.setId(id_categoria);

		nuevoProducto.setId(id_producto);
		nuevoProducto.setNombre(nombre);
		nuevoProducto.setPrecio(precio);
		nuevoProducto.setSku(sku);
		nuevoProducto.setFechaRegistro(fecha);
		nuevoProducto.setCategoria(categoriaSeleccioada);

		if (errores.isEmpty()) {
			
			productoService.save(nuevoProducto);
			resp.sendRedirect(req.getContextPath() + "/productos");

		} else {
			req.setAttribute("errores", errores);
			req.setAttribute("categorias", productoService.listarCategoria());
			req.setAttribute("producto", nuevoProducto);
			getServletContext().getRequestDispatcher("/productForm.jsp").forward(req, resp);
		}

	}

	private Map<String, String> validarFormulario(String nombre, String sku, String fecha_str, Integer precio,
			Integer id_categoria) {
		Map<String, String> errores = new HashMap<String, String>();
		if (nombre == null || nombre.isEmpty()) {
			errores.put("nombre", "el campo nombre es requerido");
		}
		if (sku == null || sku.isBlank()) {
			errores.put("sku", "el campo sku es requerido");
		}
		if (fecha_str == null || fecha_str.isBlank()) {
			errores.put("fecha_registro", "el campo fecha es requerido");
		}
		if (precio.equals(0)) {
			errores.put("precio", "el campo precio es requerido");
		}
		if (id_categoria.equals(0)) {
			errores.put("categoria", "el campo categoria es requerido");
		}
		return errores;
	}

	private Integer parseInteger(String data) {
		try {
			return Integer.valueOf(data);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private LocalDate parseDate(String date) {
		try {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (DateTimeParseException e) {
			return null;
		}
	}

}
