package com.with.project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.with.project.service.WithService;
import com.with.project.vo.MemberVO;

@Controller
public class HomeController {

	@Autowired
	private WithService ws;
	private ModelAndView mav;

	@Autowired
	private HttpSession session;
	
	//서버 실행 시켰을때
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	//메인 페이지로 이동
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home2(HttpSession ssesion) {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		mav = ws.LoginMemberMain(id);

		return mav;
	}
	//유저 마이페이지 JSP로 이동
	@RequestMapping(value = "/UserMyPage", method = RequestMethod.GET)
	public String UserMyPage() {
		return "UserMyPage";

	}
	//기사 마이페이지 JSP로 이동
	@RequestMapping(value = "/DriverMyPage", method = RequestMethod.GET)
	public String DriverMyPage() {
		return "DriverMyPage";

	}
	//유저 회원가입 JSP로 이동
	@RequestMapping(value = "/UserJoin", method = RequestMethod.GET)
	public String UserJoin() {
		return "UserJoin";
	}
	//기사 회원가입 JSP로 이동
	@RequestMapping(value = "/DriverJoin", method = RequestMethod.GET)
	public String DriverJoin() {
		return "DriverJoin";
	}
	//기사 회원가입
	@RequestMapping(value = "/DriverJoinPro", method = RequestMethod.POST)
	public ModelAndView DriverJoinPro(@ModelAttribute MemberVO memberVO) throws IOException {
		mav = new ModelAndView();

		MultipartFile file = memberVO.getFile();
		if (!file.isEmpty()) {
			String FileName = file.getOriginalFilename();
			file.transferTo(new File("D:\\Spring\\WithProject_0.0.1\\src\\main\\webapp\\resources\\" + FileName));
		}

		memberVO.setCertificate(file.getOriginalFilename());
		mav = ws.DriverJoin(memberVO);

		return mav;
	}

	// 유저 회원가입
	@RequestMapping(value = "/UserJoinPro", method = RequestMethod.POST)
	public ModelAndView UserJoinPro(@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		mav = ws.UserJoin(memberVO);
		return mav;
	}

	// 로그인 jsp로 이동
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String Login() {
		return "LoginForm";
	}

	// 로그인
	@RequestMapping(value = "/Loginpro", method = RequestMethod.POST)
	public ModelAndView LoginForm(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = ws.Login(memberVO, response);

		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String Logout() {
		session.removeAttribute("id");
		return "home";
	}
	//유저 정보 변경 하기 전 비밀번호 확인 JSP
	@RequestMapping(value = "/PasswordForm", method = RequestMethod.GET)
	public String PasswordForm() {
		return "PasswordForm";
	}
	//유저 정보 변경 하기 전 비밀번호 확인 후 유저정보 가져오기!
	
	@RequestMapping(value = "/PasswordFormPro", method = RequestMethod.GET)
	public ModelAndView PasswordFormPro(@ModelAttribute MemberVO memberVO, HttpSession session,HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		String id = (String)session.getAttribute("id");
		memberVO.setId(id);
		System.out.println("아이디 : "+ memberVO.getId());
		System.out.println("비밀번호 : "+ memberVO.getId());
		mav = ws.PasswordFormPro(memberVO, response);
		return mav;
	}
	//유저정보 변경(실질적인 변경임)
	@RequestMapping(value = "/UserInfoAlter", method = RequestMethod.POST)
	public ModelAndView UserInfoAlter(HttpSession session,@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		memberVO.setId(id);
		mav = ws.UserInfoAlter(memberVO);
		
		return mav;
	}
	//운전자 정보 변경(실질적변경) 
	@RequestMapping(value = "/DriverInfoAlter", method = RequestMethod.POST)
	public ModelAndView DriverInfoAlter(HttpSession session,@ModelAttribute MemberVO memberVO) throws IOException {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		memberVO.setId(id);
		
		MultipartFile file = memberVO.getFile();
		if (!file.isEmpty()) {
			String FileName = file.getOriginalFilename();
			file.transferTo(new File("D:\\Spring\\WithProject_0.0.1\\src\\main\\webapp\\resources\\" + FileName));
		}
		memberVO.setCertificate(file.getOriginalFilename());
		
		mav = ws.DriverInfoAlter(memberVO);
		return mav;
	}
	
}
