package com.ifragodevs.TechShop.controller;

import java.io.IOException;

import com.ifragodevs.TechShop.anotations.ProductoServicePrincipal;
import com.ifragodevs.TechShop.entity.Carro;
import com.ifragodevs.TechShop.entity.ItemCarro;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.service.ProductoService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Carro carro;
	
	@Inject
	@ProductoServicePrincipal
	private ProductoService productoService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer idProducto = Integer.parseInt(req.getParameter("id"));
		
		Producto producto = productoService.findById(idProducto);
		if(producto!=null) {
			ItemCarro item = new ItemCarro(1,producto);			
			carro.addItem(item);
		}
		
		resp.sendRedirect(req.getContextPath() + "/ver-carro");
	}
}
