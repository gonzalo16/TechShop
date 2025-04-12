package com.ifragodevs.TechShop.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

public class ProducerResources {

	@Produces
	@RequestScoped
	@Named("connBean")
	private Connection beanConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/techshop_db","root","sasa");
	}
}
