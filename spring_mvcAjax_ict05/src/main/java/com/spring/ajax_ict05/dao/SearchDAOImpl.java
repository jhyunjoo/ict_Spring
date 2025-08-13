package com.spring.ajax_ict05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ajax_ict05.dto.SearchDTO;

@Repository
public class SearchDAOImpl implements SearchDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SearchDTO> searchList(String keyword) {
		System.out.println("SearchDAOImpl - searchList()");
		
		SearchDAO dao = sqlSession.getMapper(SearchDAO.class);
		
		List<SearchDTO> list = dao.searchList(keyword);
		
		return list;
	}

}
