package com.spring.mvc_mybatis.ch04.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch04.dto.SearchDTO_4;
import com.spring.mvc_mybatis.ch04.dto.UserDTO_4;

@Repository
public class UserDAOImpl_ch04 implements UserDAO_ch04 {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserDTO_4> getUserInfo1(SearchDTO_4 search) {
		System.out.println("UserDAOImpl_ch04 - getUserInfo1");
		
		UserDAO_ch04 dao = sqlSession.getMapper(UserDAO_ch04.class);
		List<UserDTO_4> list = dao.getUserInfo1(search);
		
		return list;
	}

	@Override
	public List<UserDTO_4> getUserInfo2(int[] userIds) {
		System.out.println("UserDAOImpl_ch04 - getUserInfo2");
		
		UserDAO_ch04 dao = sqlSession.getMapper(UserDAO_ch04.class);
		List<UserDTO_4> list = dao.getUserInfo2(userIds);
		
		return list;
	}

	@Override
	public List<UserDTO_4> getUserInfo3(List<String> userNames) {
		System.out.println("UserDAOImpl_ch04 - getUserInfo3");
		
		UserDAO_ch04 dao = sqlSession.getMapper(UserDAO_ch04.class);
		List<UserDTO_4> list = dao.getUserInfo3(userNames);
		
		return list;
	}

}
