package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import service.UserDeletePassService;

public class UserDeletePassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//비밀번호 확인 후 회원탈퇴
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String inputPassword = request.getParameter("password");
		//usermember.setPassword(request.getParameter("password"));
		System.out.println("id : " + id);
		System.out.println("inputPass : " + inputPassword);
		
	
		ActionForward forward =null;
		
		UserDeletePassService userDeletePassService = new UserDeletePassService();
		boolean UserPassword =userDeletePassService.userPass(id, inputPassword);
	
		if(UserPassword) {
	
			session.invalidate();
			/*PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원이 정상적으로 탈퇴되었습니다.')");
			out.println("</script>");
			System.out.println("삭제gn");*/
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
			
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.')");
			out.println("history.back();</script>");
		}
		
		return forward;
	}

}
