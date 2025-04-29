package com.ifragodevs.TechShop.serviceImpl;

import com.ifragodevs.TechShop.service.LoginService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ApplicationScoped
public class LoginServiceImpl implements LoginService{

	@Override
	public String getUsername(HttpServletRequest request) {
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return username;
        }
        return null;
	}
}
