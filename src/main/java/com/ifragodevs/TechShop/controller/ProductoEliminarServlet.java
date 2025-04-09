package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.serviceImpl.ProductoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = (Connection) req.getAttribute("conexion");
		ProductoServiceImpl productoService = new ProductoServiceImpl(conn);
		Producto findedProduct;
		Integer idProducto;
		
		try {
			idProducto = Integer.parseInt(req.getParameter("id"));
		}catch(NumberFormatException e) {
			idProducto = 0;
		}
		
		if(idProducto > 0) {
			try {
				findedProduct = productoService.findById(idProducto);
				if(findedProduct != null) {
					productoService.eliminar(idProducto);
					resp.sendRedirect(req.getContextPath()+"/productos");
				}else {
					resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No existe el producto");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"El ID se debe enviar en la URI");
		}
	}
}
