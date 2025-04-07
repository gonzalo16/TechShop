package com.ifragodevs.TechShop.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.ifragodevs.TechShop.utils.ConexionBBDD;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class ConexionBBDDFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try(Connection conn = ConexionBBDD.getConnection()){
			
			if(conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}
			
			try {
				request.setAttribute("conexion", conn);
				chain.doFilter(request, response);
				conn.commit();
				
			}catch(SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}
			
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
