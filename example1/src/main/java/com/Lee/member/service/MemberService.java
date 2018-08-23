package com.Lee.member.service;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.Lee.member.dao.MemberDAO;
import com.Lee.member.vo.MemberVO;

@Service
public class MemberService {

	//어노테이션은 해당라인 밑에꺼 한줄만 적용한다.
	@Autowired
	private MemberDAO memberDAO;
	private ModelAndView mav;
	private MemberVO memberVO;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	
	//회원가입 메소드
	public ModelAndView memberJoin(MemberVO memberVO) {
		mav = new ModelAndView();
		
		int result = memberDAO.memberJoin(memberVO);
		
		if(result ==0) {
			//회원가입 실패하면 다시 joinForm으로
			mav.setViewName("joinForm");
		}else {
			//회원가입 성공하면 loginForm으로 이동
			mav.setViewName("loginForm");
		}
		return mav;
	}

	public void idOverlap(String id, HttpServletResponse response) throws IOException {
		memberVO = new MemberVO();
		memberVO = memberDAO.idOverlap(id);
		if(memberVO==null) {
			response.getWriter().print("1");
		}else {
			response.getWriter().print("0");
		}
		
	}
	
	
	public ModelAndView login(MemberVO memberVO, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		mav = new ModelAndView();
		
		MemberVO loginMember = memberDAO.login(memberVO);
		PrintWriter out = response.getWriter();
		
		//spring-security를 활용한 비밀번호 확인
		
								//사용자가 입력한 것           	 		DB에서 가져온것
		if(passEncoder.matches(memberVO.getPassword(), loginMember.getPassword())) {
			//세션에 id를 대입한다.
			session.setAttribute("session_id", memberVO.getId());
			//setAttribute쓰는 거랑 비슷
			mav.addObject("loginMember", loginMember);
			//경로 값
			mav.setViewName("main");
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			mav.setViewName("loginForm");
		}
		
		
		return mav;
}
	//로그아웃
	public ModelAndView logout() {
		session.removeAttribute("session_id");
		mav.setViewName("loginForm");
		return mav;
	}
	
	//사용자 목록보기
	public ModelAndView userListView(List<MemberVO> memberVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		mav = new ModelAndView();
		System.out.println("2");
		List<MemberVO> userList = memberDAO.userList(memberVO);
		if(userList!=null) {
			
			request.setAttribute("userList", userList);
			//mav.addObject("userList", userList);
			System.out.println("4");
			mav.setViewName("userList");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			mav.setViewName("main");
		}
		return mav;
	}
}
