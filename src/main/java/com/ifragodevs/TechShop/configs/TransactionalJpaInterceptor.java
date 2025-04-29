package com.ifragodevs.TechShop.configs;

import com.ifragodevs.TechShop.anotations.TransactionalJpa;
import com.ifragodevs.TechShop.exception.ServiceJdbException;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;

@Interceptor
@TransactionalJpa
public class TransactionalJpaInterceptor {

	@Inject
	private EntityManager em;
	
	@AroundInvoke
	public Object transactional(InvocationContext invocation) throws Exception {

		try {

			em.getTransaction().begin();
			Object resultado = invocation.proceed();
			em.getTransaction().commit();

			return resultado;
		} catch (ServiceJdbException e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
}
