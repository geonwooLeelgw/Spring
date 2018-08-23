package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;

import service.MemberSuspendedService;

public class MemberSuspendedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//회원정지
		
		ActionForward forward = null;
		String thatId = request.getParameter("thatId");
		System.out.println("아이디 : " + thatId);

	


		MemberSuspendedService memberSuspendedService = new MemberSuspendedService();
		boolean result = memberSuspendedService.returningToAction(thatId);

		if (result) {
			
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("allSuspendedMembersList.s");
	
		}

		return forward;

	}

}



