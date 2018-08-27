package com.Lee.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Lee.member.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int memberJoin(MemberVO memberVO) {
		
		
		return sqlSession.insert("Member.memberJoin", memberVO);
	}

	public MemberVO idOverlap(String id) {
		
		
		return sqlSession.selectOne("Member.idOverlap", id);
	}


	public MemberVO login(MemberVO memberVO) {
		
		return sqlSession.selectOne("Member.login", memberVO);
	}

	/*public List<MemberVO> userList(List<MemberVO> memberVO) {
		System.out.println("3");
		return sqlSession.selectList("Member.userList", memberVO);
	}*/

	public List<MemberVO> memberList() {

		return sqlSession.selectList("Member.memberList");
	}

	public MemberVO memberView(String id) {
		
		return sqlSession.selectOne("Member.memberView", id);
	}

	public int memberDel(String id) {
		
		return sqlSession.delete("Member.memberDel", id);
	}


}
