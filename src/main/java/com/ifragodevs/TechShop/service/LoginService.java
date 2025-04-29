package com.ifragodevs.TechShop.service;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {

	String getUsername(HttpServletRequest request);
}
