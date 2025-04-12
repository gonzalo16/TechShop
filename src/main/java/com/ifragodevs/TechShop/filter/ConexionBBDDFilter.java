package com.ifragodevs.TechShop.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class ConexionBBDDFilter implements Filter{
	
	@Inject
	@Named("connBean")
	private Connection conn;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try(Connection conn = this.conn){
			
			if(conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}
			
			try {
				
				chain.doFilter(request, response);
				conn.commit();
				
			}catch(SQLException e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
