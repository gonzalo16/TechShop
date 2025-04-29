package com.ifragodevs.TechShop.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = entityManagerFactoryBuild();

	private static EntityManagerFactory entityManagerFactoryBuild() {
		return Persistence.createEntityManagerFactory("ejemploJPA");
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
