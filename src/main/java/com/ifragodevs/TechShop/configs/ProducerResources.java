package com.ifragodevs.TechShop.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.ifragodevs.TechShop.utils.JpaUtil;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ProducerResources {
	
	@Inject
    private Logger log;


	@Produces
	@RequestScoped
	@Named("connBean")
	private Connection beanConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/techshop_db","root","sasa");
	}
	
	@Produces
	private Logger beanLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	@Produces
	@RequestScoped
	private EntityManager beanEntityManager() {
		log.info("abriendo la conexion del EntityManager!");
		return JpaUtil.getEntityManager();
	}
	
	public void close(@Disposes EntityManager entityManager) {
		if(entityManager.isOpen()) {
			entityManager.close();
			log.info("cerrando la conexion del EntityManager!");
		}
	}
}
