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
	private BoardVO boardVO;
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		
		List<BoardVO> boardList = boardDAO.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardList");
		return mav;
	}

	public ModelAndView boardWrite(BoardVO boardVO) {
		mav = new ModelAndView();
		
		int result = boardDAO.boardWrite(boardVO);
		
		if(result ==0) {
			mav.setViewName("boardWrite");
		}else {
			mav.setViewName("index");
		}
		
		return mav;
	}

	

}
