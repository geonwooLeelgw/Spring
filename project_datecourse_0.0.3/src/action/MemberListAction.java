package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberListService;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("모든회원리스트 액션");
		ActionForward forward = null;
		MemberListService memberListService = new MemberListService();
		ArrayList<MemberBean> memberList = memberListService.returningToAction();
		ArrayList<MemberBean> suspendedMemberList = memberListService.returningToAction2();

		
		request.setAttribute("memberList", memberList);
		request.setAttribute("suspendedMemberList", suspendedMemberList);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("pageForAdmin.jsp");
	
		
		return forward;
	}

}



