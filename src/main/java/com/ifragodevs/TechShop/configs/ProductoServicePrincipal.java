package com.ifragodevs.TechShop.configs;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD,FIELD,PARAMETER,TYPE})
public @interface ProductoServicePrincipal {

}
