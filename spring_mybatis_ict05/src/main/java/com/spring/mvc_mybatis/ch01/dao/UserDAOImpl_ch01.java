package com.spring.mvc_mybatis.ch01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch01.dto.UserDTO;

@Repository
public class UserDAOImpl_ch01 implements UserDAO_ch01{
	
	@Autowired
	SqlSession sqlSession;
	

	
	@Override
	public List<UserDTO> getAddressInfo_1() {
		System.out.println("DAO - getAddressInfo_1()");
		
		UserDAO_ch01 dao = sqlSession.getMapper(UserDAO_ch01.class);
		
		List<UserDTO> list = dao.getAddressInfo_1();
		
		return list;
	}

	@Override
	public List<UserDTO> getAddressInfo_2() {
		System.out.println("DAO - getAddressInfo_2()");
		
		UserDAO_ch01 dao = sqlSession.getMapper(UserDAO_ch01.class);
		
		List<UserDTO> list = dao.getAddressInfo_2();
		
		return list;
	}

}
