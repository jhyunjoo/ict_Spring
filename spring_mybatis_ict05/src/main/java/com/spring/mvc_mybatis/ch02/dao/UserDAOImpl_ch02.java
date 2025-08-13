package com.spring.mvc_mybatis.ch02.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch02.dto.UserDTO_2;

@Repository
public class UserDAOImpl_ch02 implements UserDAO_ch02{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserDTO_2> getBoardInfo_1() {
		System.out.println("UserDAOImpl_ch02 - getBoardInfo_1()");
		
		UserDAO_ch02 dao = sqlSession.getMapper(UserDAO_ch02.class);
		List<UserDTO_2> list = dao.getBoardInfo_1();
		
		return list;
	}

	@Override
	public List<UserDTO_2> getBoardInfo_2() {
		System.out.println("UserDAOImpl_ch02 - getBoardInfo_2()");
		
		UserDAO_ch02 dao = sqlSession.getMapper(UserDAO_ch02.class);
		List<UserDTO_2> list = dao.getBoardInfo_2();
		
		return list;
	}

}
