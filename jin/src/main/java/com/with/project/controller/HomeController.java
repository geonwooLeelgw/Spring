package com.with.project.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.with.project.service.MemberService;
import com.with.project.vo.MemberVO;

import java.util.Properties;



@Controller
public class HomeController {
	
	/*HttpServletResponse response;
	response.setContentType("text/html;charset=UTF-8");
	*/
	@Autowired
	private MemberService ms;
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
		mav = ms.LoginMemberMain(id);

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
	@RequestMapping(value = "/DriverJoinPro", method = RequestMethod.GET)
	public ModelAndView DriverJoinPro(@ModelAttribute MemberVO memberVO) throws IOException {
		mav = new ModelAndView();
		mav = ms.DriverJoin(memberVO);
		return mav;
	}
	//회원가입 id 중복확인
	@RequestMapping(value = "idOverlap",method=RequestMethod.POST)
	public void idOverlap(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
		ms.idOverlap(id,response);
	}
	
	//이메일 인증
	@RequestMapping(value = "SelectFindId",method=RequestMethod.POST)
	public void SelectFindId(HttpServletResponse response, @ModelAttribute MemberVO selectmemberVO) throws IOException {
		System.out.println("테스트1"+selectmemberVO.getName());
		ms.SelectFindId(selectmemberVO,response);
	}

	//이메일 인증
		@RequestMapping(value = "SelectFindPs",method=RequestMethod.POST)
		public void SelectFindPs(HttpServletResponse response, @ModelAttribute MemberVO selectmemberVO) throws IOException {
			System.out.println("테스트1"+selectmemberVO.getId());
			ms.SelectFindPs(selectmemberVO,response);
		}
	
	// 유저 회원가입
	@RequestMapping(value = "/UserJoinPro", method = RequestMethod.GET)
	public ModelAndView UserJoinPro(@ModelAttribute MemberVO memberVO, HttpServletResponse response) {
	response.setContentType("text/html;charset=UTF-8");
		System.out.println("첫번째 테스트:"+memberVO.getName());
		mav = new ModelAndView();
		mav = ms.UserJoin(memberVO, response);
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
		mav = ms.Login(memberVO, response);

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
		mav = ms.PasswordFormPro(memberVO, response);
		return mav;
	}
	//유저정보 변경(실질적인 변경임)
	@RequestMapping(value = "/UserInfoAlter", method = RequestMethod.POST)
	public ModelAndView UserInfoAlter(HttpSession session,@ModelAttribute MemberVO memberVO) {
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		memberVO.setId(id);
		mav = ms.UserInfoAlter(memberVO);
		
		return mav;
	}
	
	
	//테스트
		@RequestMapping(value = "/FindIdPro", method = RequestMethod.GET)
		public ModelAndView mailSender(HttpSession session, HttpServletRequest request, @ModelAttribute MemberVO memberVO) throws MessagingException {	
			mav = new ModelAndView();
			mav = ms.mailSender(memberVO);	  	    
			return mav;
		}
		
		
		@RequestMapping(value = "/FindPsPro", method = RequestMethod.GET) 
		public ModelAndView FindPsPro(HttpSession session, HttpServletRequest request, @ModelAttribute MemberVO memberVO) throws MessagingException {	
			mav = new ModelAndView();	
			mav = ms.FindPsPro(memberVO);	  	   
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
			file.transferTo(new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\WithProject_0.0.3\\src\\main\\webapp\\resources\\"+FileName));
		}
		memberVO.setCertificate(file.getOriginalFilename());
		
		mav = ms.DriverInfoAlter(memberVO);
		return mav;
	}
	
	@RequestMapping(value = "/LicenseUpload", method = RequestMethod.POST)
	public ModelAndView LicenseUpload(HttpSession session,@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		mav = new ModelAndView();
		String id = (String) session.getAttribute("id");
		memberVO.setId(id);	
		MultipartFile file = memberVO.getFile();
		if (!file.isEmpty()) {
			String FileName = file.getOriginalFilename();
			file.transferTo(new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\WithProject_0.0.3\\src\\main\\webapp\\resources\\"+FileName));
		}
		memberVO.setCertificate(file.getOriginalFilename());
		
		mav = ms.LicenseUpload(memberVO, response);
		return mav;
	}
	
	//비밀번호 바꾸기	
	@RequestMapping(value = "/ChangePsPro", method = RequestMethod.GET)
	public ModelAndView ChangePsPro(HttpSession session,@ModelAttribute MemberVO memberVO) throws IOException {
		mav = new ModelAndView();
		mav = ms.ChangePsPro(memberVO);
		return mav;
	}
	
	//관리자가 보는 멤버들
	@RequestMapping(value ="/MemberInfomation", method = RequestMethod.GET)
	public ModelAndView MemberInfomation(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = ms.MemberInformaion(memberVO);
		
		return mav;	
	}
	
	//멤버 상세보기
	@RequestMapping(value = "/MemberDetail", method = RequestMethod.GET)
	public ModelAndView MemberDetail(@RequestParam("id") String id) {
		System.out.println("memberdelete String값"+id);
		mav = new ModelAndView();
		mav = ms.MemberDetail(id);
		return mav;
	}
	
	//멤버 삭제
	@RequestMapping(value = "/MemberDelete", method = RequestMethod.GET)
	public ModelAndView MemberDelete(@RequestParam("id") String id) {
		System.out.println("memberdelete String값"+id);
		mav = new ModelAndView();
		mav = ms.MemberDelete(id);
		return mav;
	}
	
	//승인 대기중인 기사보기
	@RequestMapping(value = "/DriverApproval", method = RequestMethod.GET)
	public ModelAndView DriverApproval(@ModelAttribute MemberVO memberVO, HttpServletResponse response) throws IOException {
		mav = new ModelAndView();
		mav = ms.DriverApproval(memberVO);	
		
		return mav;
	}
	
	@RequestMapping(value = "/DriverDetail", method = RequestMethod.GET)
	public ModelAndView DriverDetail(@RequestParam("id") String id) {
		System.out.println("DriverDetail String값"+id);
		mav = new ModelAndView();
		mav = ms.DriverDetail(id);
		return mav;
	}
	@RequestMapping(value = "/DriverAuthorityApproval", method = RequestMethod.GET)
	public ModelAndView DriverAuthorityApproval(@RequestParam("id") String id) {
		System.out.println("DriverDetail String값"+id);
		mav = new ModelAndView();
		mav = ms.DriverAuthorityApproval(id);
		return mav;
	}
	
	@RequestMapping(value = "/DriverCheck",method=RequestMethod.POST)
	public void DriverCheck(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
		System.out.println("드라이버 체크"+id);
		ms.DriverCheck(id,response);
		
	}
	@RequestMapping(value = "/EmailCheck", method = RequestMethod.GET)
	public ModelAndView MailJoin(HttpSession session, HttpServletRequest request, @ModelAttribute MemberVO memberVO) throws MessagingException {	
		mav = new ModelAndView();
		mav = ms.MailJoin(memberVO);	  	    
		return mav;
	}
	
	@RequestMapping(value = "/CheckDriver", method = RequestMethod.GET)
	public ModelAndView EmailCheckDriver(HttpSession session, HttpServletRequest request, @ModelAttribute MemberVO memberVO) throws MessagingException {	
		mav = new ModelAndView();
		mav = ms.EmailCheckDriver(memberVO);	
		return mav;
	}
	

	//지도가기
		@RequestMapping(value = "/maps", method = RequestMethod.GET)
		public String maps() {
			return "Maps";

		}
		//SearchMap
		@RequestMapping(value = "/SearchMap", method = RequestMethod.GET)
		public String SearchMap() {
			return "SearchMap";

		}
		//Search2Map
		@RequestMapping(value = "/Search2Map", method = RequestMethod.GET)
		public String Search2Map() {
			return "Search2Map";

		}
		
		//맵다시띄우기ReStart
		@RequestMapping(value = "/ReStart", method = RequestMethod.GET)
		public String ReStart() {
			return "Maps";

		}
		
		@RequestMapping(value = "/test1", method = RequestMethod.GET)
		public String test1() {
			return "test1";

		}
		
		//아이디 찾기 페이지 이동
		@RequestMapping(value = "/findid", method = RequestMethod.GET)
		public String findid() {
			return "FindId";

		} 
		
		//비밀번호 찾기 페이지 이동
		@RequestMapping(value = "/findps", method = RequestMethod.GET)
		public String findps() {
			return "Findps";

		} 
		
		@RequestMapping(value = "/CodeSuccess", method = RequestMethod.GET)
		public String CodeSuccess() {
			return "ChangePs";

		} 
		
		
		//관리자페이지
		
		@RequestMapping(value = "/AdminHome", method = RequestMethod.GET)
		public String AdminHome() {
			return "AdminHome";
		}
		
		@RequestMapping(value = "/License", method = RequestMethod.GET)
		public String License() {
			return "License";
		}
		
		}

