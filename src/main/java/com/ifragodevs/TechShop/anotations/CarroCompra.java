package com.ifragodevs.TechShop.anotations;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Named
@SessionScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
public @interface CarroCompra {

}
