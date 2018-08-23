package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;

public class LogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ActionForward forward = null;

		forward = new ActionForward();
		HttpSession session = request.getSession();
		
		//세션값 초기화
		session.invalidate();
		
		
		forward.setRedirect(true);
		forward.setPath("./index.jsp");
		
		return forward;
	}

}
