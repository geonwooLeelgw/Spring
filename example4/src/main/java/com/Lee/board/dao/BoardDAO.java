package com.Lee.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Lee.board.vo.BoardVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<BoardVO> boardList() {
		
		return sqlSession.selectList("Board.boardList");
	}

	public int boardWrite(BoardVO boardVO) {
		
		
		return sqlSession.insert("Board.boardWrite", boardVO);
	}

	public BoardVO boardView(int bId) {
		return sqlSession.selectOne("Board.boardView", bId);
		
		
	}

	public int bHitUp(int bId) {
		return sqlSession.update("Board.bHitUp", bId);
	}

	public int boardDel(int bId) {
		return sqlSession.delete("Board.boardDel", bId);
		
	}


	

}
