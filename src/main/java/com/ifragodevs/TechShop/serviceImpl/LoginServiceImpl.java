package com.ifragodevs.TechShop.serviceImpl;

import java.util.Optional;

import com.ifragodevs.TechShop.service.LoginService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ApplicationScoped
public class LoginServiceImpl implements LoginService{

	@Override
	public Optional<String> getUsername(HttpServletRequest request) {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
	}
}
