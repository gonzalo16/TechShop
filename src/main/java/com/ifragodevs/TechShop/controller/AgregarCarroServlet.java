package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.ifragodevs.TechShop.entity.Carro;
import com.ifragodevs.TechShop.entity.ItemCarro;
import com.ifragodevs.TechShop.entity.Producto;
import com.ifragodevs.TechShop.service.ProductoService;
import com.ifragodevs.TechShop.serviceImpl.ProductoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = (Connection) req.getAttribute("conexion");
		
		Integer idProducto = Integer.parseInt(req.getParameter("id"));
		ProductoService service  = new ProductoServiceImpl(conn);
		
		Producto producto = null;
		try {
			producto = service.findById(idProducto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(producto!=null) {
			ItemCarro item = new ItemCarro(1,producto);
			Carro carro = null;
			
			HttpSession session = req.getSession();
			if(session.getAttribute("carro") == null) {
				carro = new Carro();
				session.setAttribute("carro", carro);
			}else {
				carro = (Carro) session.getAttribute("carro");
			}
			
			carro.addItem(item);
		}
		
		resp.sendRedirect(req.getContextPath() + "/ver-carro");
	}

	
}
