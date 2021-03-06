package com.with.project.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.with.project.dao.WithDAO;
import com.with.project.vo.MemberVO;

@Service
public class WithService {

	@Autowired
	private WithDAO withDAO;
	private ModelAndView mav;

	@Autowired
	private HttpSession session;

	// 기사 회원가입
	public ModelAndView DriverJoin(MemberVO memberVO) {
		mav = new ModelAndView();
		int result = withDAO.DriverJoin(memberVO);

		if (result == 0) {
			mav.setViewName("home");
		} else {
			mav.setViewName("home");
		}
		return mav;
	}

	// 유저 회원가입
	public ModelAndView UserJoin(MemberVO memberVO) {
		mav = new ModelAndView();

		int result = withDAO.UserJoin(memberVO);

		if (result == 0) {
			mav.setViewName("home");
		} else {
			mav.setViewName("home");
		}
		return mav;
	}

	// 로그인
	public ModelAndView Login(MemberVO memberVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		mav = new ModelAndView();

		MemberVO loginMember = withDAO.Login(memberVO);

		if (loginMember != null) {
			session.setAttribute("id", memberVO.getId());
			mav.addObject("LoginMember", loginMember);
			mav.setViewName("home");

		} else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			mav.setViewName("LoginForm");
		}
		return mav;
	}

	// 로그인 한 후 메인 으로 갈때
	public ModelAndView LoginMemberMain(String id) {
		mav = new ModelAndView();
		MemberVO member = withDAO.MemberMain(id);
		mav.addObject("LoginMember", member);
		mav.setViewName("home");
		return mav;
	}

	// 비밀번호 확인 후 정보로가기
	public ModelAndView PasswordFormPro(MemberVO memberVO,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberVO UserAlterInfo = withDAO.UserAlterInfo(memberVO);
		if(UserAlterInfo != null) {
			mav.addObject("UserAlterInfo", UserAlterInfo);
			mav.setViewName("UserMyPageInfo");
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			mav.setViewName("PasswordForm");
		}
		return mav;
	}
	//유저 정보 수정
	public ModelAndView UserInfoAlter(MemberVO memberVO) {
		mav = new ModelAndView();
		int result = withDAO.UserInfoUpdate(memberVO);
		if(result==0) {
			mav.setViewName("redirect:PasswordFormPro?Password="+memberVO.getPassword());
		}else {
			mav.setViewName("redirect:UserMyPage");
		}
		return mav;
	}
	//운전자 정보 수정
	public ModelAndView DriverInfoAlter(MemberVO memberVO) {
		mav = new ModelAndView();
		int result = withDAO.DriverInfoUpdate(memberVO);
		if(result==0) {
			mav.setViewName("redirect:PasswordFormPro?Password="+memberVO.getPassword());
			}else {
				mav.setViewName("redirect:DriverMyPage");
			}
		return mav;
	}

}
