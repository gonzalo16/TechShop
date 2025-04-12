package com.ifragodevs.TechShop.anotations;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

@Named
@ApplicationScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE})
public @interface RepositoryAnnotation {

}
