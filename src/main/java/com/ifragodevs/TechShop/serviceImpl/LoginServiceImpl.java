package com.ifragodevs.TechShop.serviceImpl;

import java.util.Arrays;
import java.util.Optional;

import com.ifragodevs.TechShop.service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class LoginServiceImpl implements LoginService{

	@Override
	public Optional<String> getEmail(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies() != null ? request.getCookies(): new Cookie[0];
		return Arrays.stream(cookies)
				.filter(c -> "email".equals(c.getName()))
				.map(Cookie::getValue)
				.findAny();
	}

}
