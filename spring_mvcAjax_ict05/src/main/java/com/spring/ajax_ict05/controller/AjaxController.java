package com.spring.ajax_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ajax_ict05.HomeController;
import com.spring.ajax_ict05.service.SearchServiceImpl;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 첫페이지
	@RequestMapping("/simple.do")
	public String simple(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		logger.info("<<< url => /simple.do >>>");
		
		return "basic/simple";
	}
	
	// --------------------- News ------------------------
	// 1. 
	@RequestMapping("/responseNews.do")
	public String responseNews() {
		logger.info("<<< url => /responseNews.do >>>");
		
		return "news/responseNews";
	}
	
	// 5-1.
	@RequestMapping("/news1.do")
	public String news1() {
		logger.info("<<< url => /news1.do >>>");
		return "news/news1";
	}
	
	// 5-2.
	@RequestMapping("/news2.do")
	public String news2() {
		logger.info("<<< url => /news2.do >>>");
		
		return "news/news2";
	}
	
	// 5-3.
	@RequestMapping("/news3.do")
	public String news3() {
		logger.info("<<< url => /news3.do >>>");
		
		return "news/news3";
	}
	
	// --------------------- Book ----------------------
	// 1.
	@RequestMapping("/responseBook.do")
	public String responseBook() {
		logger.info("<<< url => /responseBook.do >>>");
		
		return "book/responseBook";
	}
	
	// 5.
	@RequestMapping("/bookInfo.do")
	public String bookInfo() {
		logger.info("<<< url => /bookInfo.do >>>");
		
		return "book/bookInfo";
	}
	
}
