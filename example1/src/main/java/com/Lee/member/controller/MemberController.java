package com.Lee.member.controller;

import java.io.IOException;
//import java.text.DateFormat;

//import java.util.Date;
import java.util.List;
//import java.util.Locale;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.xml.ws.Response;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.Lee.member.service.MemberService;
import com.Lee.member.vo.MemberVO;


@Controller
public class MemberController {
	
	/*
	 * 별도의 객체를 생성하지 않고도 자동으로 객체를 주입하여 사용할 수 있도록 하는 어노테이션
	 * 스프링의 특징 중 하나인 의존성 주입(Dependency Injection)을 구현하는 개념
	 * @Autowired를 붙이면 스프링 컨테이너가 자동으로 관리 함.
	 */
	@Autowired
	private MemberService ms;
	private ModelAndView mav;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private HttpSession session;
	
	//프로젝트 시작했을 때 페이지 지정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "loginForm";
	}
	
	//회원가입 페이지로 이동 요청 처리
	@RequestMapping(value = "/joinForm" , method = RequestMethod.GET)
	public String joinForm() {
		//joinForm.jsp 페이지로 이동
		return "joinForm";
	}
	//회원가입 처리
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		//암호화 작업
		String encPassword = passEncoder.encode(memberVO.getPassword());
		memberVO.setPassword(encPassword);
		System.out.println("암호화 비번 확인"+memberVO.getPassword());
		
		mav = ms.memberJoin(memberVO);
		return mav;
	}	
		//아이디 중복확인
		@RequestMapping(value = "idOverlap",method=RequestMethod.POST)
		public void idOverlap(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
			ms.idOverlap(id,response);
		}
		
		//로그인
		@RequestMapping(value = "/login",method=RequestMethod.POST)
		public ModelAndView login(@ModelAttribute MemberVO memberVO,HttpServletResponse response) throws IOException{
			mav = new ModelAndView();
			mav = ms.login(memberVO, response);
			
				return mav;
			}
			
		//로그아웃
		@RequestMapping(value = "/logout" , method = RequestMethod.GET)
		public String logout() {
			session.removeAttribute("session_id");
			return "loginForm";
		}
		
		//회원목록
		@RequestMapping(value = "/userList" , method = RequestMethod.GET)
		public ModelAndView userListView(HttpSession session) throws IOException{
			mav = new ModelAndView();
			String loginMember = (String)session.getAttribute("session_id");
			if(loginMember == null || !loginMember.equals("admin")) {
				mav.setViewName("loginForm");
			}else {
				mav = ms.memberList();
			}
			
			return mav;
		}
		
		//회원정보 보기
		@RequestMapping(value = "/userView", method = RequestMethod.GET)
		public ModelAndView memberView(@RequestParam("id") String id) {
			mav = new ModelAndView();
			mav = ms.memberView(id);
			return mav;
		}
		
		//회원 삭제 하기 memberDel
		@RequestMapping(value = "/memberDel", method = RequestMethod.GET)
		public String memberDel(@RequestParam("id") String id) {
			/*mav = new ModelAndView();*/
			ms.memberDel(id);
			return "redirect:/userList";
		}
}
