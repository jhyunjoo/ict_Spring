package com.spring.mvc_mybatis.ch05.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05;
import com.spring.mvc_mybatis.ch05.dto.UserDTO_5;

@Service
public class UserServiceImpl_ch05 implements UserService_ch05 {

	@Autowired
	private UserDAO_ch05 dao;
	
	// 목록조회
	@Override
	public void getUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - getUserList()");
		
		List<UserDTO_5> list = dao.selectUserList();
		
		model.addAttribute("list", list);
		
//		getUserList
//		아이디	이름	등록일
//		1	john	2025-08-08
//		2	jasmine	2025-08-08
	}

	// 1건 조회
	@Override
	public void getUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - getUser()");
		
		UserDTO_5 user = dao.selectUser(1);
		
		model.addAttribute("user", user);
		
//		getUser
//		아이디	이름	등록일
//		1	john	2025-08-08
	}

	// insert후 목록조회
	@Override
	public void insertUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - insertUserList()");
		
		UserDTO_5 user = new UserDTO_5(3, "hyun", Date.valueOf("2025-08-13"));
		
		//insert
		int cnt = dao.insertUser(user);
		// 목록조회
		List<UserDTO_5> list = dao.selectUserList();
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("list", list);
		
//		insert후 목록조회
//		성공 : 1
//		아이디	이름	등록일
//		1	john	2025-08-08
//		2	jasmine	2025-08-08
//		3	hyun	2025-08-13
	}

	// update후 목록조회
	@Override
	public void updateUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - updateUserList()");
	}

	// delete후 목록조회
	@Override
	public void deleteUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - deleteUserList()");
	}

}
