package com.ifragodevs.TechShop.controller;

import java.io.IOException;

import com.ifragodevs.TechShop.service.LoginService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginService loginService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = loginService.getUsername(req);
		
		if(username != null) {
			HttpSession sessionOut = req.getSession();
			sessionOut.invalidate();
		}
		
		resp.sendRedirect(req.getContextPath() + "/login.html");
	}
}
