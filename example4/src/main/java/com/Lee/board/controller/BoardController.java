package com.Lee.board.controller;

import java.io.File;
import java.io.IOException;

//import java.io.IOException;
//import java.text.DateFormat;

//import java.util.Date;
/*import java.util.List;*/
//import java.util.Locale;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletResponse;

//import javax.xml.ws.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	private BoardService bs;
	private ModelAndView mav;
	
	//첫페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "redirect:/boardList";
	}
	//목록으로!
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boardList() throws IOException {
		mav = new ModelAndView();
		mav = bs.boardList();
		
		return mav;
	}
	
	//글쓰기 jsp로 가즈아~!
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite() {
		
		return "boardWrite";
	}
	//글 쓰기
	@RequestMapping(value = "/boardWritePro", method=RequestMethod.POST)
	public ModelAndView boardWritePro(@ModelAttribute BoardVO boardVO) throws IOException {
		mav = new ModelAndView();
		
		MultipartFile bfile = boardVO.getbFile();
		if(!bfile.isEmpty()) {
			String fileName = bfile.getOriginalFilename(); // 파일 이름 가져오기
			bfile.transferTo(new File("C:\\Users\\user\\git\\Spring\\example4\\src\\main\\webapp\\WEB-INF\\upload\\"+fileName)); // 파일을 관리할 경로
		}
		
		boardVO.setbFileName(bfile.getOriginalFilename());
		
		mav = bs.boardWrite(boardVO);
		return mav;
	}	
	//상세 보기
	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public ModelAndView boardView(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardView(bId);
		return mav;
	}
	//게시물 삭제
	@RequestMapping(value = "/baordDelete", method = RequestMethod.GET)
	public ModelAndView boardDel(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardDel(bId);
		return mav;
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(@RequestParam("bId") int bId) {
		mav = new ModelAndView();
		mav = bs.boardUpdate(bId);
		return mav;
	}
}
