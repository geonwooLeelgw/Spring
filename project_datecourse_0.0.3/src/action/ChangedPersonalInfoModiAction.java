package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.MemberBean;
import service.ChangedPersonalInfoModiService;

public class ChangedPersonalInfoModiAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ActionForward  forward =null;
		MemberBean memberBean = new MemberBean();
		HttpSession session = request.getSession();		
		//session에 저장된 id값
		//개인정보 수정을 하기위해 memberBean 값을 가져옴
		memberBean.setId((String)session.getAttribute("id"));
		memberBean.setPassword(request.getParameter("password"));
		memberBean.setName(request.getParameter("name"));
		memberBean.setNickname(request.getParameter("nickname"));
		memberBean.setEmail(request.getParameter("email"));
		
		System.out.println(request.getParameter("id"));
		System.out.println(memberBean.getId());
		System.out.println(memberBean.getEmail());
		
		ChangedPersonalInfoModiService changedPersonalInfoModiService = new ChangedPersonalInfoModiService();
	
		boolean modifypassword = changedPersonalInfoModiService.modipassword(memberBean);
		
		if(modifypassword) {
			//modifypassword가 true면 index.jsp
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		}else {//else false면 alert창
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back();</script>");
		}
		
		return forward;
	}

}
