package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ifragodevs.TechShop.configs.ProductoServicePrincipal;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.service.LoginService;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/productos.html","/productos"})
public class ProductoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Inject
	@ProductoServicePrincipal
	private ProductoService service;
	
	@Inject
	private LoginService loginService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Producto> productos = new ArrayList<>();
		try {
			productos = service.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Optional<String> username = loginService.getUsername(req);
		
		req.setAttribute("productos", productos);
		req.setAttribute("username", username);
		getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
	}
}
