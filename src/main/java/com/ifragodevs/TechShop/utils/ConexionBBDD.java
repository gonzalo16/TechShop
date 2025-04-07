package com.ifragodevs.TechShop.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {

	private static String url = "jdbc:mysql://localhost:3306/techshop_db";
	private static String username = "root";
	private static String password = "sasa";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,username,password);
	}
}
