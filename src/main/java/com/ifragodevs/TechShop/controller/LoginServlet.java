package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.util.Optional;

import com.ifragodevs.TechShop.entity.Usuario;
import com.ifragodevs.TechShop.service.UsuarioService;


import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
		
	@Inject
	private UsuarioService usuarioService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username_req = req.getParameter("username");
		String password_req = req.getParameter("password");
		
		Optional<Usuario> usuarioOptional = usuarioService.findByUsernameAndPassword(username_req, password_req);
		if(usuarioOptional.isPresent()) {
			
			HttpSession session = req.getSession();
			session.setAttribute("username", username_req);
			resp.sendRedirect(req.getContextPath() + "/login_success.jsp");
		}else {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
		}
	}

}
