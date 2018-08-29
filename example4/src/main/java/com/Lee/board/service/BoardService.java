package com.Lee.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.Lee.board.dao.BoardDAO;
import com.Lee.board.vo.BoardVO;



@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	private ModelAndView mav;
	
	//게시물 목록
	public ModelAndView boardList() {
		mav = new ModelAndView();
		
		List<BoardVO> boardList = boardDAO.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardList");
		return mav;
	}
	//게시물 작성
	public ModelAndView boardWrite(BoardVO boardVO) {
		mav = new ModelAndView();
		
		int result = boardDAO.boardWrite(boardVO);
		
		if(result ==0) {
			//글쓰기 실패시
			mav.setViewName("home");
		}else {
			mav.setViewName("redirect:boardList");
		}
		
		return mav;
	}
	//게시물 상세보기
	public ModelAndView boardView(int bId) {
		mav = new ModelAndView();
		
		int result = boardDAO.bHitUp(bId);
		if(result==0) {
			//조회수 올리기 실패시
			mav.setViewName("redirect:boardList");
		}else {
			//조회수 올리기 성공시
			BoardVO boardView = boardDAO.boardView(bId);
		
			mav.addObject("boardView", boardView);
			mav.setViewName("boardView");
		}
		
		
		return mav;
	}
	//게시물 삭제
	public ModelAndView boardDel(int bId) {
		
		mav = new ModelAndView();
		
		int result = boardDAO.boardDel(bId);
		if(result==0) {
			mav.setViewName("redirect:boardView?bId="+bId);
		}else {
		mav.setViewName("redirect:boardList");
		}
		
		return mav;
	}
	//게시물 수정하기전 값 불러오기
	public ModelAndView boardUpdate(int bId) {
		//여기까지함.
		return null;
	}

	
	

}
