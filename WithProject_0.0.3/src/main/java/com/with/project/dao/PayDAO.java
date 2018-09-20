package com.with.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.with.project.vo.MemberVO;

@Repository
public class PayDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public MemberVO UserPoint(String Id) {
		
		return sqlSession.selectOne("With.UserPoint", Id);
	}

}
