package com.ifragodevs.TechShop.anotations;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ifragodevs.TechShop.interceptors.Logging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Logging
@Named
@Stereotype
@ApplicationScoped
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
public @interface Service {

}
