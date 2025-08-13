package com.spring.mvc_mybatis.ch05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch05.dto.UserDTO_5;

@Repository
public class UserDAOImpl_ch05 implements UserDAO_ch05 {
	
	@Autowired
	private SqlSession sqlSession;

	// 목록조회
	@Override
	public List<UserDTO_5> selectUserList() {
		System.out.println("dao - selectUserList()");
		
		UserDAO_ch05 dao = sqlSession.getMapper(UserDAO_ch05.class);
		List<UserDTO_5> dto = dao.selectUserList();
		
		return dto;
	}

	// 1건 조회
	@Override
	public UserDTO_5 selectUser(int userId) {
		System.out.println("dao - selectUser()");
		
		UserDAO_ch05 dao = sqlSession.getMapper(UserDAO_ch05.class);
		UserDTO_5 user = dao.selectUser(userId);
		
		return user;
	}

	// insert후 목록조회
	@Override
	public int insertUser(UserDTO_5 dto) {
		System.out.println("dao - insertUser()");
		
		UserDAO_ch05 dao = sqlSession.getMapper(UserDAO_ch05.class);
		int insertCnt = dao.insertUser(dto);
		
		return insertCnt;
	}

	// update후 목록조회
	@Override
	public int updateUser(UserDTO_5 dto) {
		System.out.println("dao - updateUser()");
		
		return 0;
	}

	// delete후 목록조회
	@Override
	public int deleteUser(int userId) {
		System.out.println("dao - deleteUser()");
		
		return 0;
	}

}
