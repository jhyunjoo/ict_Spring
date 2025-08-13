package com.spring.mvc_mybatis.ch05.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface UserService_ch05 {
	
	// 목록조회
	public void getUserList(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;

	// 1건 조회
	public void getUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
	// insert후 목록조회
	public void insertUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;

	// update후 목록조회
	public void updateUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
	// delete후 목록조회
	public void deleteUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
}
