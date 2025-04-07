package com.ifragodevs.TechShop.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private Integer id;
	
	private String nombre;
	
	private Categoria categoria;
	
	private int precio;
	
	private String sku;
	
	private LocalDate fechaRegistro;
}
