package com.spring.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
