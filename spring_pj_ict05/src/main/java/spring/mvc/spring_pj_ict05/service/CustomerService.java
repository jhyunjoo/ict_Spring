package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface CustomerService {
	
	// ID 중복 확인 처리
	public void idConfiremAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
		
	// 회원가입 처리
	public void signInAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
	
	// 로그인 처리 / 회원정보 인증(수정,탈퇴)
	public void loginAction(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
	
	// 회원정보 인증처리 및 탈퇴처리
	public void deleteCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
	
	//회원정보 인증처리 및 상세페이지 조회
	public void modifyDetailAtion(HttpServletRequest request, HttpServletResponse response, Model model) 
		throws ServletException, IOException;
	
	// 회원정보 수정처리
	public void modifyCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
		throws ServletException, IOException;
}
