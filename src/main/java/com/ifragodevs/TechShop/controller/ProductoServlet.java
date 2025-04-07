package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.service.LoginService;
import com.ifragodevs.TechShop.service.ProductoService;
import com.ifragodevs.TechShop.serviceImpl.LoginServiceImpl;
import com.ifragodevs.TechShop.serviceImpl.ProductoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/productos.html","/productos"})
public class ProductoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = (Connection) req.getAttribute("conexion");
		
		ProductoService service = new ProductoServiceImpl(conn);
		List<Producto> productos = new ArrayList<>();
		try {
			productos = service.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		LoginService login = new LoginServiceImpl();
		Optional<String> emailUser = login.getEmail(req);
		
		req.setAttribute("productos", productos);
		req.setAttribute("email", emailUser);
		getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
	}
}
