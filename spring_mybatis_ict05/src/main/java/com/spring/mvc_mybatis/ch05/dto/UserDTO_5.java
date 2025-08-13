package com.spring.mvc_mybatis.ch05.dto;

import java.sql.Date;
import java.util.List;

//1:다 => UserDTO_2(부모T) : BoardDTO(자식T) => user 1명이 게시글 여러개를 가지고 있다.(1:다 관계)
public class UserDTO_5 {

	// 멤버변수
	private int userId;		// PK => mvc_user_tbl - user_id
	private String userName;	  // mvc_user_tbl - user_name
	private Date regDate;		  // mvc_user_tbl - reg_date
	
	public UserDTO_5() {
		super();
	}
	
	public UserDTO_5(int userId, String userName, Date regDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", regDate=" + regDate + "]";
	}
	
}

//CREATE TABLE mvc_user_tbl(
//		user_id 	NUMBER(2) PRIMARY KEY,
//		user_name   VARCHAR2(30),
//		reg_date    DATE
//	);