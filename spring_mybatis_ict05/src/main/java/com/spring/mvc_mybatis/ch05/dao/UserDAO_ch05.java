package com.spring.mvc_mybatis.ch05.dao;

import java.util.List;

import com.spring.mvc_mybatis.ch05.dto.UserDTO_5;

public interface UserDAO_ch05 {

	// 목록조회
	public List<UserDTO_5> selectUserList();
	
	// 1건 조회
	public UserDTO_5 selectUser(int userId);
	
	// insert후 목록조회
	public int insertUser(UserDTO_5 dto);
	
	// update후 목록조회
	public int updateUser(UserDTO_5 dto);
	
	// delete후 목록조회
	public int deleteUser(int userId);
	
}
