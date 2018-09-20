package com.with.project.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.with.project.dao.PayDAO;
import com.with.project.vo.MemberVO;

@Service
public class PayService {
	
	@Autowired
	private PayDAO payDAO;
	private ModelAndView mav;

	public ModelAndView PayClick(String finalMoney, String roomId, HttpServletResponse response, HttpSession session) {
		mav = new ModelAndView();
		
		String id = (String)session.getAttribute("id");
		MemberVO memberVO = payDAO.UserPoint(id);
		
		mav.addObject("finalMoney", finalMoney);
		mav.addObject("member", memberVO);
		mav.setViewName("Pay");
		
		return mav;
	}

}
