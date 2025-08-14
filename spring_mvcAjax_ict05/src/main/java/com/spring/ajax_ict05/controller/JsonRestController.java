package com.spring.ajax_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ajax_ict05.dto.ProductDTO;

@RestController		// ajax 처리 전용 컨트롤러(스프링 4.0 이상부터 작동) => url이 아닌 데이터를 리턴 
public class JsonRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonRestController.class);

	
	@RequestMapping("/product2.jq")
	public ProductDTO product(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /product2.jq >>>");
		
		// @ResponseBody 추가 결과와 동일, json 타입 => {"product_id":"P_001","product_name":"LG GrAM","product_price":2000000}
		ProductDTO dto = new ProductDTO("P_001", "LG GrAM", 2000000);	// 매개변수 생성자 호출
		
		return dto;		
	}

}
