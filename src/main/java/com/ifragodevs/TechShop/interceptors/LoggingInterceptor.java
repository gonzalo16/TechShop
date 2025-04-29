package com.ifragodevs.TechShop.interceptors;

import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Logging
@Interceptor
public class LoggingInterceptor {

	@Inject
	private Logger logg;
	
	@AroundInvoke
	public Object logging(InvocationContext context) throws Exception {
		
		logg.info("***** Entrando antes de invocar el metodo " +context.getMethod().getName() + " de la clase: " +context.getMethod().getDeclaringClass());
		Object resultado = context.proceed();
		logg.info("***** Saliendo de la invocacion del metodo " +context.getMethod().getName() + " de la clase: " +context.getMethod().getDeclaringClass());
		return resultado;
	}
}
