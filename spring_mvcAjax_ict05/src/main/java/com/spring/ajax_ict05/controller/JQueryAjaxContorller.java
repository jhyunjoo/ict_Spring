package com.spring.ajax_ict05.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ajax_ict05.dto.ProductDTO;
import com.spring.ajax_ict05.service.SearchServiceImpl;

@Controller
public class JQueryAjaxContorller {
	
	private static final Logger logger = LoggerFactory.getLogger(JQueryAjaxContorller.class);

	@Autowired
	private SearchServiceImpl service;
	
	// 첫페이지
	// 1. dataType: 'text' 인 경우
	@RequestMapping("/basic1.jq")
	public String basic1() {
		logger.info("<<< url => /basic1.jq >>>");
		
		return "jquery/basic1";
	}
	
	// 4.
	@RequestMapping("/basic1_next.jq")
	public String basic1_next() {
		logger.info("<<< url => /basic1_next.jq >>>");
		
		return "jquery/basic1_next";
	}
	
	// 2. data: 'param'인 경우 (주의 : dataType 아님)
	@RequestMapping("/basic2.jq")
	public String basic2() {
		logger.info("<<< url => /basic2.jq >>>");
		
		return "jquery/basic2";
	}
	
	// 4.
	@RequestMapping("/baisc2_next.jq")
	public String basic2_next() {
		logger.info("<<< url => /basic2_next.jq >>>");
		
		return "jquery/basic2_next";
	}
	
	// 3. dataType: 'xml'인 경우
	@RequestMapping("/basic3.jq") 
	public String basic3() {
		logger.info("<<< url => /basic.jq >>>");
		
		return "jquery/basic3";
	}
	
	// 4. dataType: 'json'인 경우 => 매우 중요
	// 1.
	@RequestMapping("/basic4.jq")
	public String basic4() {
		logger.info("<<< url => /basic4.jq >>>");
		
		return "jquery/basic4"; 
	}
	
	@RequestMapping("/basic5.jq")
	public String basic5() {
		logger.info("<<< url => /basic5.jq >>>");
		
		return "jquery/basic5";
	}
	
	@RequestMapping("/basic5_next.jq")
	public String basic5_next(HttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException {
		logger.info("<<< url => /basic5_next >>>");
		
		String jsonInfo = request.getParameter("jsonInfo");
		
		// http://mvnrepository.com/ 접속 => json.simple 검색 => 1.1.1 선택 -> pom.xml에 추가
		// http://mvnrepository.com/ 접속 => jackson-databind검색 => 2.14.1 선택 -> pom.xml에 추가
		JSONParser jsonParser = new JSONParser();
		
		try {
			// import org.json.simple.JSONObject;
			JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonInfo);
			System.out.println("--- 회원 정보 ---");
			
			// 콘솔에 출력
			System.out.println("이름 : " + jsonObject.get("name"));
			System.out.println("전화번호 : " + jsonObject.get("tel"));
			System.out.println("주소 : " + jsonObject.get("address"));
			System.out.println("이메일 : " + jsonObject.get("email"));
			
			model.addAttribute("name", jsonObject.get("name"));
			model.addAttribute("tel", jsonObject.get("tel"));
			model.addAttribute("address", jsonObject.get("address"));
			model.addAttribute("email", jsonObject.get("email"));
		
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		return "jquery/basic5_next";
	}
	
	// ------------------------ 실시간 검색(중요) ----------------------------
	@RequestMapping("/search.jq")
	public String search() {
		logger.info("<<< url => /search.jq >>>");
		
		return "search/search";
	}
	
	@RequestMapping("/search_next.jq")
	public String search_next(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /search_next.jq >>>");
		
		service.searchList(request, response);
		
		return "search/search_next";
	}
	
	// ---------------------------------------------------------------------
	
	@RequestMapping("/product.jq")
	public @ResponseBody ProductDTO product(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /product.jq >>>");
		
		// @ResponseBody 생략시 에러 => 파일 [/WEB-INF/views/product.jsp]을(를) 찾을 수 없습니다.
		// @ResponseBody 추가시 출력결과는 json 타입 => {"product_id":"P_001","product_name":"LG GrAM","product_price":2000000}
		ProductDTO dto = new ProductDTO("P_001", "LG GrAM", 2000000);	// 매개변수 생성자 호출
		
		return dto;		
	}
	
	@RequestMapping("/basic6.jq")
	public String basic6(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /basic6.jq >>>");
		
		return "jquery/basic6";		// 1.
	}
	
	@RequestMapping("/basic6_next.jq")
	public @ResponseBody String basic6_next(@RequestBody Map<String, Object> map) 
			throws ServletException, IOException {
		logger.info("<<< url => /basic6_next.jq >>>");
		
		String id = map.get("id").toString();	// Object -> String
		String pwd = map.get("pwd").toString();
		String name = map.get("name").toString();
		
		
		return id + "," + pwd + "," + name;		// 6.
	}
	
	@RequestMapping("/basic7.jq")
	public String basic7(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("<<< basic7.jq >>>");

		return "jquery/basic7"; // 1.
	}

	@RequestMapping("/basic7_next.jq")
	public @ResponseBody String basic7_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("<<< basic7_next.jq >>>");

		String mode = request.getParameter("mode");
		mode += " hyunjoo";
		return mode; // 6.
	}

}
