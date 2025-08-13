package spring.mvc.spring_pj_ict05.dto;

import java.sql.Date;	// 주의

public class BoardDTO {

	private int b_num;				// 글번호
	private String b_title;			// 글제목
	private String b_content;		// 글내용
	private String b_writer;		// 작성자
	private String b_password;		// 수정,삭제용 비밀번호
	private int b_readCnt;			// 조회수
	private Date b_regDate;			// 작성일
	private int b_comment_count;	// 댓글갯수
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int b_num, String b_title, String b_content, String b_writer, String b_password, int b_readCnt,
			Date b_regDate, int b_comment_count) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_password = b_password;
		this.b_readCnt = b_readCnt;
		this.b_regDate = b_regDate;
		this.b_comment_count = b_comment_count;
	}

	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_password() {
		return b_password;
	}
	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public int getB_readCnt() {
		return b_readCnt;
	}
	public void setB_readCnt(int b_readCnt) {
		this.b_readCnt = b_readCnt;
	}

	public Date getB_regDate() {
		return b_regDate;
	}
	public void setB_regDate(Date b_regDate) {
		this.b_regDate = b_regDate;
	}

	public int getB_comment_count() {
		return b_comment_count;
	}
	public void setB_comment_count(int b_comment_count) {
		this.b_comment_count = b_comment_count;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer="
				+ b_writer + ", b_password=" + b_password + ", b_readCnt=" + b_readCnt + ", b_regDate=" + b_regDate
				+ ", b_comment_count=" + b_comment_count + "]";
	}
	
}


//CREATE TABLE mvc_board_tbl (
//		b_num			NUMBER(7)		PRIMARY KEY,		-- 글번호
//		b_title			VARCHAR2(50)	NOT NULL,			-- 글제목
//		b_content 		CLOB			NOT NULL,			-- 글내용
//		b_writer		VARCHAR2(30)	NOT NULL,			-- 작성자
//		b_password		VARCHAR2(30)	NOT NULL,			-- 수정,삭제용 비밀번호
//		b_readCnt		NUMBER(6)		DEFAULT 0,			-- 조회수
//		b_regDate		DATE			DEFAULT sysdate,	-- 작성일
//		b_comment_count	NUMbER(6)		DEFAULT 0			-- 댓글갯수
//	);