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
	
	//글목록
	public List<BoardVO> boardList() {
		return sqlSession.selectList("Board.boardList");
	}
	//글쓰기
	public int boardWrite(BoardVO boardVO) {
		return sqlSession.insert("Board.boardWrite", boardVO);
	}
	//상세보기
	public BoardVO boardView(int bId) {
		return sqlSession.selectOne("Board.boardView", bId);	
	}
	
	/* 선생님이한 조회수 올리기
	 * public void increaseHit(int bId){
	 * sqlSession.update("Board.increaseHit", bId);
	 * }
	 */
	
	//조회수 올리기
	public int bHitUp(int bId) {
		return sqlSession.update("Board.bHitUp", bId);
	}
	//게시물삭제
	public int boardDel(int bId) {
		return sqlSession.delete("Board.boardDel", bId);
		
	}
	//게시물 수정 전 값 불러오기
	public BoardVO boardUpdateView(int bId) {
		
		return sqlSession.selectOne("Board.boardUpdateView", bId);
	}
	//게시물 real 수정
	public int boardUpdate(BoardVO boardVO) {
		
		return sqlSession.update("Board.boardUpdate", boardVO);
	}


	

}
