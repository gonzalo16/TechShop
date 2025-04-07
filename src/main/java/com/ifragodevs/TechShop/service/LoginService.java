package com.ifragodevs.TechShop.service;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {

	Optional<String> getEmail(HttpServletRequest request);
}
