package spring.mvc.spring_pj_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.spring_pj_ict05.service.ProductServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	// 상품 등록 화면
	@RequestMapping("/ad_product_add.pd")
	public String ad_product_add(HttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException {
		logger.info("<<< url => /ad_product_add.pd >>>");
		
		return "admin/product/ad_product_add";
	}
	
	// MultipartHttpServletRequest => 매개변수에 등록처리의 컨트롤러, 수정처리의 컨트롤러, 서비스까지
	// pom.xml에 commons-fileupload, commons-io 를 추가
	// servlet-context.xml에 MultipartResolver 설정 추가
	// 상품 등록 처리 => 등록
	@RequestMapping("/ad_product_addAction.pd")
	public String ad_product_addAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException {
		logger.info("<<< url => /ad_product_addAction.pd >>>");
		
		service.productAddAction(request, response, model);
		
		return "admin/product/ad_product_addAction";
	}
	
	// 상품 목록
	@RequestMapping("/ad_product_list.pd")
	public String ad_product_list(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /ad_product_list.pd >>>");
		
		service.productListAction(request, response, model);
		
		return "admin/product/ad_product_list";
	}
	
	// 상품 상세페이지
	@RequestMapping("/ad_product_detailAction.pd")
	public String ad_product_detailAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /ad_product_detailAction.pd >>>");
		
		service.productDetailAction(request, response, model);
		
		return "admin/product/ad_product_detailAction";
	}
	
	// 상품 수정 처리
	@RequestMapping("/ad_product_updateAction.pd")
	public String ad_product_updateAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException {
		logger.info("<<< url => /ad_product_updateAction.pd >>>");
		
		service.productUpdateAction(request, response, model);
		
		return "admin/product/ad_product_updateAction";
	}
	
	// 상품 삭제 처리 
	@RequestMapping("/ad_product_deleteAction.pd")
	public String ad_product_deleteAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /ad_product_deleteAction.pd >>>");
		
		service.productDeleteAction(request, response, model);
		
		return "admin/product/ad_product_deleteAction";
	}
}
