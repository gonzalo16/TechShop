package com.ifragodevs.TechShop.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBaseDatosDS {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Context initContext;
		Context envContext;
		DataSource ds = null;
		try {
			initContext = new InitialContext();
			envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/mysqlDB");
			return ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
