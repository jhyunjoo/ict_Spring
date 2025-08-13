package com.spring.mvc_mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc_mybatis.ch01.service.UserServiceImpl_ch01;
import com.spring.mvc_mybatis.ch02.service.UserServiceImpl_ch02;
import com.spring.mvc_mybatis.ch03.service.UserServiceImpl_ch03;
import com.spring.mvc_mybatis.ch04.service.UserServiceImpl_ch04;
import com.spring.mvc_mybatis.ch05.service.UserServiceImpl_ch05;

@Controller
public class MyBatisController {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisController.class);
	
	@Autowired
	private UserServiceImpl_ch01 service1;
	
	@Autowired
	private UserServiceImpl_ch02 service2;
	
	@Autowired
	private UserServiceImpl_ch03 service3;
	
	@Autowired
	private UserServiceImpl_ch04 service4;
	
	@Autowired
	private UserServiceImpl_ch05 service5;
	
	// ch01 ------------------------------------------------------
	// ch01. user:address => 1:1 => association
	@RequestMapping("/getAddressInfo_1")
	public String getAddressInfo_1(HttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException{
		logger.info("<<< url => /getAddressInfo_1 >>>");
		
		service1.getAddressInfo_1(request, response, model);
		
		return "address/getAddressInfo";
	}
	
	@RequestMapping("/getAddressInfo_2")
	public String getAddressInfo_2(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getAddressInfo_1 >>>");
		
		service1.getAddressInfo_2(request, response, model);
		
		return "address/getAddressInfo";
	}
	
	// ch02 ------------------------------------------------------
	// ch02. user:board => 1:다 => collection
	@RequestMapping("/getBoardInfo_1")
	public String getBoardInfo_1(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getBoardInfo_1 >>>");
		
		service2.getBoardInfo_1(request, response, model);
		
		return "board/getUserBoardInfo";
	}
	
	@RequestMapping("/getBoardInfo_2")
	public String getBoardInfo_2(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getBoardInfo_2 >>>");
		
		service2.getBoardInfo_2(request, response, model);
		
		return "board/getUserBoardInfo";
	}
	
	// ch03 --------------------------------------------------------
	// ch03. 동적 SQL => 중요
	@RequestMapping("/getSearchInfo_1")
	public String getSearchInfo_1(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getSearchInfo_1 >>>");
		
		service3.getSearchInfo_1(request, response, model);
		
		return "search/getSearchInfo";
	}
	
	@RequestMapping("/getSearchInfo_2")
	public String getSearchInfo_2(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getSearchInfo_2 >>>");
		
		service3.getSearchInfo_2(request, response, model);
		
		return "search/getSearchInfo";
	}
	
	@RequestMapping("/getSearchInfo_3")
	public String getSearchInfo_3(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getSearchInfo_3 >>>");
		
		service3.getSearchInfo_3(request, response, model);
		
		return "search/getSearchInfo";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /updateUser >>>");
		
		service3.updateUser(request, response, model);
		
		return "search/getSearchInfo2";
	}
	
	@RequestMapping("/getUserSearchInfo")
	public String getUserSearchInfo(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUserSearchInfo >>>");
		
		service3.getUserSearchInfo(request, response, model);
		
		return "search/getUserSearchInfo";
	}
	
	// ch04 --------------------------------------------------------
	// ch04. 배열, List
	// 1. collection="멤버변수"인 경우
	@RequestMapping("/getUserInfo1")
	public String getUserInfo1(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUserInfo1 >>>");
		
		service4.getUserInfo1(request, response, model);
		
		return "array/array1";
	}
	
	// 2. collection="array"인 경우
	@RequestMapping("/getUserInfo2")
	public String getUserInfo2(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUserInfo2 >>>");
		
		service4.getUserInfo2(request, response, model);
		
		return "array/array2";
	}
	
	// 3. collection="list"인 경우
	@RequestMapping("/getUserInfo3")
	public String getUserInfo3(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUserInfo3 >>>");
		
		service4.getUserInfo3(request, response, model);
		
		return "array/array3";
	}
	
	
	// ch05 ------------------------------------------------------
	// 목록조회
	@RequestMapping("/getUserList")
	public String getUserList(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUserList >>>");
		
		service5.getUserList(request, response, model);
		
		return "user/getUserList";
	}
	
	// 1건조회
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /getUser >>>");
		
		service5.getUser(request, response, model);
		
		return "user/getUserList2";
	}
	
	// insert후 목록조회
	@RequestMapping("/insertUser")
	public String insertUser(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url => /insertUser >>>");
		
		service5.insertUserList(request, response, model);
		
		return "user/getUserList3";
	}
}
