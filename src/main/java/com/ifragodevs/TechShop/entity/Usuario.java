package com.ifragodevs.TechShop.entity;

import lombok.Data;

@Data
public class Usuario {

	private Long id;
	
	private String username;
	
	private String email;
	
	private String password;
}
