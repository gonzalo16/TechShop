package com.ifragodevs.TechShop.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletContextListener, ServletRequestListener, HttpSessionListener{

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().log("App inicializando...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().log("Finalizando app ...");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionCreated(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionDestroyed(se);
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestDestroyed(sre);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestInitialized(sre);
	}

	

	
}
