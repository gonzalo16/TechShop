package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.ifragodevs.TechShop.entity.Usuario;
import com.ifragodevs.TechShop.service.UsuarioService;
import com.ifragodevs.TechShop.service.LoginService;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginService loginService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		Optional<String> usernameOptional = loginService.getUsername(req);
		
		if(usernameOptional.isPresent()) {
			resp.setContentType("text/html;charset=UTF-8");
			writer.print("<!DOCTYPE html>");
			writer.print("<html>");
				writer.print("<head>");
				writer.print("</head>");
					writer.print("<body>");
					writer.print("<h1>has iniciado sesion con éxito</h1>");
					writer.println("<p><a href='" + req.getContextPath() + "/productos.html'>volver</a></p>");
					writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username_req = req.getParameter("username");
		String password_req = req.getParameter("password");
		
		Optional<Usuario> usuarioOptional = usuarioService.findByUsernameAndPassword(username_req, password_req);
		if(usuarioOptional.isPresent()) {
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username_req);
			resp.sendRedirect(req.getContextPath()+ "/login.html");
		}else {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
		}
	}

}
