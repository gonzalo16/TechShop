package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class procesarFormularioServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String paises[] = req.getParameterValues("paises");
		
		
		writer.print("<!DOCTYPE html>");
		writer.print("<html>");
			writer.print("<head>");
			writer.print("</head>");
			
				writer.print("<body>");
				writer.print("<h1>Resultado form: </h1>");
				writer.print("<h3>Username: " +username + " </h3>");
				writer.print("<h3>Password: " +password + " </h3>");
				writer.print("<h3>Email: " +email + " </h3>");
				writer.print("<h3>Paises: </h3>");
				
				writer.print("<ul>");
				Arrays.asList(paises).forEach(l -> {writer.println("<li>"+l +"</li>");});
				writer.print("</ul>");

				writer.print("</body>");
		writer.print("</html>");
		writer.close();
	}
}
