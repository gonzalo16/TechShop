package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola-mundo")
public class holamundo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String param1 = req.getParameter("param");
		String param2 = req.getParameter("param2");
		int param3 = Integer.parseInt(req.getParameter("param3"));
		
		writer.print("<!DOCTYPE html>");
		writer.print("<html>");
			writer.print("<head>");
			writer.print("</head>");
				writer.print("<body>");
				writer.print("<h1>Hola parametros desde get</h1>");
				
				if(param1 != null && param2 != null && param3 != 0) {
					writer.print("<h3>El parametro 1 es: " +param1 + " </h3>");
					writer.print("<h3>El parametro 2 es: " +param2 + " </h3>");
					writer.print("<h3>El parametro 3 es: " +param3 + " </h3>");
				}
				
				writer.print("</body>");
		writer.print("</html>");
		writer.close();
	}

}
