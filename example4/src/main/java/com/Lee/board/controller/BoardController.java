package com.Lee.board.controller;

import java.io.IOException;

//import java.io.IOException;
//import java.text.DateFormat;

//import java.util.Date;
/*import java.util.List;*/
//import java.util.Locale;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.xml.ws.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.Lee.board.service.BoardService;
import com.Lee.board.vo.BoardVO;


@Controller
public class BoardController {
	
	/*
	 * 별도의 객체를 생성하지 않고도 자동으로 객체를 주입하여 사용할 수 있도록 하는 어노테이션
	 * 스프링의 특징 중 하나인 의존성 주입(Dependency Injection)을 구현하는 개념
	 * @Autowired를 붙이면 스프링 컨테이너가 자동으로 관리 함.
	 */
	@Autowired
	private BoardService ms;
	private ModelAndView mav;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private HttpSession session;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView boardList() throws IOException {
		mav = new ModelAndView();
		mav = ms.boardList();
		
		return mav;
	}
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList2() throws IOException {
		mav = new ModelAndView();
		mav = ms.boardList();
		
		return mav;
	}
	
	//글쓰기로 넘어오기
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite() {
		
		return "boardWrite";
	}
	//글쓰기
	@RequestMapping(value = "/boardWritePro", method=RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute BoardVO boardVO) {
		mav = new ModelAndView();
		
		mav = ms.boardWrite(boardVO);
		return mav;
	}	

}
