package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.spring_pj_ict05.dao.CustomerDAO;
import spring.mvc.spring_pj_ict05.dao.CustomerDAOImpl;
import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO dao;
	
	// ID 중복 확인 처리
	@Override
	public void idConfiremAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - idConfiremAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져오기
		String strId = request.getParameter("user_id");
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5단계. 아이디 중복 확인 처리
		int selectCnt = dao.useridCheck(strId);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("strId", strId);
	}

	// 회원가입 처리
	@Override
	public void signInAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - signInAction()");
		
		// 3단계. 화면에서 입력받은 값을 가져와서 DTO의 setter를 통해 값 전달
		
		// DTO 생성 -> setter -> 멤버변수
		CustomerDTO dto = new CustomerDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setUser_password(request.getParameter("user_password"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
		
		// 주소
		String address1 = request.getParameter("user_address1");
		String address2 = request.getParameter("user_address2");
		String address = address1 + " " + address2;
		dto.setUser_address(address);
		
		// hp은 필수가 아니므로 null값이 들어올 수 있으므로 값이 존재할 때만 받아온다.
		String hp = "";
		String hp1 = request.getParameter("user_hp1"); 
		String hp2 = request.getParameter("user_hp2");
		String hp3 = request.getParameter("user_hp3");
		
		if (!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {
			hp = hp1 + "-" + hp2 + "-" + hp3;
		}
		dto.setUser_hp(hp);
		
		// 이메일 
		String email1 = request.getParameter("user_email1");
		String email2 = request.getParameter("user_email2");
		String email = email1 + "@" + email2;
		dto.setUser_email(email);
		
		// 등록일 .. 아래 문장 생략시 SYSDATE가 사용됨
		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAOImpl dao = new CustomerDAOImpl();
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5단계. 회원가입 처리
		int insertCnt = dao.insertCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("insertCnt", insertCnt);
	}

	// 로그인 처리 / 회원정보 인증(수정,탈퇴)
	@Override
	public void loginAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl -loginAction");
		
		// 3단계. 화면에서 입력받은 값을 가져와서 DTO의 setter를 통해 값 전달
		String strId = request.getParameter("user_id");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// HashMap 생성 -> key, value 추가
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("strId", strId);
		map.put("strPassword", strPassword);
		
		// 5단계. 로그인 처리
		int selectCnt = dao.idPasswordChk(map);
		
		// 로그인 성공시 세션ID를 설정(중요)
		if(selectCnt == 1) {
			// HttpSession session = request.getSession();
			// session.setAttribute("sessionID", strId);
			request.getSession().setAttribute("sessionID", strId);
		} else {
			request.getSession().setAttribute("sessionID", null);
		}
	}

	// 회원정보 인증처리 및 탈퇴처리
	@Override
	public void deleteCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - deleteCustomerAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(id)
		String sessionID = (String)request.getSession().getAttribute("sessionID");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5-1단계. 회원정보 인증처리
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("strId                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ", sessionID);
		map.put("strPassword", strPassword);
		
		int selectCnt = dao.idPasswordChk(map);
		
		int deleteCnt = 0;
		
		// 회원정보 인증성공시
		if(selectCnt == 1) {
			// 5-2단계. 탈퇴처리
			 deleteCnt = dao.deleteCustomer(sessionID);
			 if(deleteCnt == 1) {
				 // 세션 삭제 => 주의
				 request.getSession().invalidate();
			 }
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("deleteCnt", deleteCnt);
		model.addAttribute("selectCnt", selectCnt);
	}

	//회원정보 인증처리 및 상세페이지 조회
	@Override
	public void modifyDetailAtion(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - modifyDetailAtion");
		
		// 3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(id)
		String sessionID = (String)request.getSession().getAttribute("sessionID");
		String strPassword = request.getParameter("user_password");
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5-1단계. 회원정보 인증처리
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("strId", sessionID);
		map.put("strPassword", strPassword);
		int selectCnt = dao.idPasswordChk(map);
		
		CustomerDTO dto = null;
		
		// 회원정보 인증성공시
		if(selectCnt == 1) {
			// 5-2단계. 상세페이지 조회
			 dto = dao.getCustomerDetail(sessionID);
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("dto", dto);
		
	}

	// 회원정보 수정처리
	@Override
	public void modifyCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - modiryCustomerAction");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setUser_id((String)request.getSession().getAttribute("sessionID"));
		dto.setUser_password(request.getParameter("user_password"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
		dto.setUser_address(request.getParameter("user_address"));
		
		// hp은 필수가 아니므로 null값이 들어올 수 있으므로 값이 존재할 때만 받아온다.
		String hp = "";
		String hp1 = request.getParameter("user_hp1"); 
		String hp2 = request.getParameter("user_hp2");
		String hp3 = request.getParameter("user_hp3");
		
		if (!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {
			hp = hp1 + "-" + hp2 + "-" + hp3;
		}
		dto.setUser_hp(hp);
		
		// 이메일 
		String email1 = request.getParameter("user_email1");
		String email2 = request.getParameter("user_email2");
		String email = email1 + "@" + email2;
		dto.setUser_email(email);
		
		// 등록일 .. 아래 문장 생략시 SYSDATE가 사용됨
		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
		
		// 4단계. 싱글톤 방식으로 DAO 객체생성, 다형성 적용
		// CustomerDAOImpl dao = new CustomerDAOImpl();
		// CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		// 5단계. 회원가입 처리
		int updateCnt = dao.updateCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("updateCnt", updateCnt);
	}

}
