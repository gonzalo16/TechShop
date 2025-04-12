package com.ifragodevs.TechShop.exception;

public class ServiceJdbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ServiceJdbException(String message) {
        super(message);
    }

    public ServiceJdbException(String message, Throwable cause) {
        super(message, cause);
    }
}
