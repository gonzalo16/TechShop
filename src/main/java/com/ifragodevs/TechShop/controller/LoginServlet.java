package com.ifragodevs.TechShop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String email = "sdvsef@gmail.com";
	
	private static String password = "1234";
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
		PrintWriter writer = resp.getWriter();
		
		
		Optional<Cookie> cookieOpt = Arrays.stream(cookies)
				.filter(c -> "email".equals(c.getName()))
				.findFirst();
		
		if(cookieOpt.isPresent()) {
			resp.setContentType("text/html;charset=UTF-8");
			writer.print("<!DOCTYPE html>");
			writer.print("<html>");
				writer.print("<head>");
				writer.print("</head>");
					writer.print("<body>");
					writer.print("<h1>has iniciado sesion con éxito</h1>");
					writer.println("<p><a href='" + req.getContextPath() + "/index.html'>volver</a></p>");
					writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}else {
			getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email_req = req.getParameter("email");
		String password_req = req.getParameter("password");
		if(email.equals(email_req) && password.equals(password_req)) {
			
			
			Cookie userCookie = new Cookie("email",email_req);
			
			resp.addCookie(userCookie);
			resp.sendRedirect(req.getContextPath()+ "/login.html");
		}else {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
		}
	}

}
