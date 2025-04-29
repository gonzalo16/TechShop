package com.ifragodevs.TechShop.filter;

import java.io.IOException;

import com.ifragodevs.TechShop.exception.ServiceJdbException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ConexionBBDDFilter implements Filter{
	
	//@Inject
	//@Named("connBean")
	//private Connection conn;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		try {
			
			chain.doFilter(request, response);
			
		}catch(ServiceJdbException ex) {
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
			ex.printStackTrace();
		}

		/*try(Connection conn = this.conn){
			
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
		}*/
	}

}
