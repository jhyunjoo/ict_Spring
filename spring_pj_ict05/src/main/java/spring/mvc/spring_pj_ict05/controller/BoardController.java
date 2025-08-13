package spring.mvc.spring_pj_ict05.controller;

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

import spring.mvc.spring_pj_ict05.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private BoardServiceImpl service;
	
	// [게시글 목록]
	@RequestMapping("/board_list.bc")
	public String board_list(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /board_list.bc >>>");
		
		service.boardListAction(request, response, model);
		
		return "admin/csCenter/board_list";
	}
	
	// [게시글 상세 화면 처리]
	@RequestMapping("/board_detailAction.bc")
	public String board_detailAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /board_detailAction.bc");
		
		service.boardDetailAction(request, response, model);
		
		return "admin/csCenter/board_detailAction";
	}
		
	// [게시글 수정삭제 버튼] 클릭시 - 비밀번호 인증처리
	@RequestMapping("/password_chkAction.bc")
	public String password_chkAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /password_chkAction.bc >>>");
		
		int result = service.password_chkAction(request, response, model);
		
		if(result != 0) {
			return "admin/csCenter/board_edit";
		} else {
			logger.info("<<< 비밀번호 불일치 >>>");
			
			int b_num = Integer.parseInt(request.getParameter("hidden_b_num"));
			
			String viewPage= request.getContextPath() + "/board_detailAction.bc?b_num=" + b_num + "&message=error";
			response.sendRedirect(viewPage);
			return null;	
		}
	}
	
	// [게시글 수정 처리]
	@RequestMapping("/board_updateAction.bc")
	public void board_updateAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /board_updateAction.bc >>>");
		
		int b_num = service.boardUpdateAction(request, response);
		
		String viewPage = request.getContextPath() +  "/board_detailAction.bc?b_num="+b_num;
		response.sendRedirect(viewPage);
	}
	
	// [게시글 삭제 처리]
	@RequestMapping("/board_deleteAction.bc")
	public void board_deleteAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /board_deleteAction.bc >>>");
		
		service.boardDeleteAction(request, response);
		
		String viewPage = request.getContextPath() +  "/board_list.bc";
		response.sendRedirect(viewPage);
	}
	
	// [게시글 작성 화면]
	@RequestMapping("/board_insert.bc")
	public String board_insert() {
		logger.info("<<< url => /board_insert.bc >>>");
		
		return "admin/csCenter/board_insert";
	}
	
	// [게시글 작성 처리]
	@RequestMapping("/board_insertAction.bc")
	public void board_insertAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /board_insertAction.bc >>>");
		
		int b_num = service.boardInsertAction(request, request);
		
		String viewPage=request.getContextPath() + "/board_detailAction.bc?b_num=" + b_num;
		response.sendRedirect(viewPage);
	}
	
	// [댓글 작성 처리(4)]
	@RequestMapping("/comment_insert.bc")
	public void comment_insert(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /comment_insert.bc >>>");
		
		service.commentAddAction(request, response);
		// viewPage="/admin/csCenter/board_detailAction.jsp"; 로 이동안함
		// board_detailAction.jsp의 comment_add()로 복귀 => $.ajax의 콜백함수로 리턴
	}
	
	// [댓글 목록(10)]
	@RequestMapping("/comment_list.bc")
	public String comment_list(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url => /comment_list.bc >>>");
		
		service.commentListAction(request, response, model);	// (11)
		
		return "admin/csCenter/comment_list";	// (12) 결과페이지이며, $.ajax(success)의 result에 해당
		// board_detailAction.jsp의 comment_list()로 복귀 => $.ajax의 콜백함수로 리턴
	}
	
}
