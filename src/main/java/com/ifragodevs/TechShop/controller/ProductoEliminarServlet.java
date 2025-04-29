package com.ifragodevs.TechShop.controller;

import java.io.IOException;

import com.ifragodevs.TechShop.anotations.ProductoServicePrincipal;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@ProductoServicePrincipal
	private ProductoService productoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Producto findedProduct;
		Integer idProducto = parseInteger(req.getParameter("id"));

		if (idProducto > 0) {

			findedProduct = productoService.findById(idProducto);
			if (findedProduct != null) {
				productoService.eliminar(idProducto);
				resp.sendRedirect(req.getContextPath() + "/productos");
			} else {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto");
			}

		} else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El ID se debe enviar en la URI");
		}
	}

	private Integer parseInteger(String data) {
		try {
			return Integer.valueOf(data);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
