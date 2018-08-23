package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.CanceledSuspensionService;

public class CanceledSuspensionAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String forCancel = request.getParameter("forCancel");
		//pageForAdmin.jsp에서 정지취소시킬 아이디 값 가져옴
		
		CanceledSuspensionService canceledSuspensionService = new CanceledSuspensionService();
		boolean result = canceledSuspensionService.returningToAction(forCancel);
		
		if (result) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("allSuspendedMembersList.s");
		}
		
		
		return forward;
	}
	
	

}



