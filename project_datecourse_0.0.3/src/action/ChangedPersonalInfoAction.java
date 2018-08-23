package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MemberBean;
import service.ChangedPersonalInfoService;

public class ChangedPersonalInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward  forward = null;
		//개인정보 값을 가져오기 위해 
		String id = request.getParameter("id");
		System.out.println("개인정보 아이디 : "+id);
		
		ChangedPersonalInfoService changedPersonalInfoService = new ChangedPersonalInfoService();
		MemberBean memberBean = changedPersonalInfoService.getmember(id);
		
		//memberBean이 null이 아니면
		if(memberBean !=null) {
		forward = new ActionForward();
		//modifyView에 memberBean값을 넣어둠
		request.setAttribute("modifyView", memberBean);
		forward.setRedirect(false);
		//ChangedPersonalInfo.jsp
		forward.setPath("/ChangedPersonalInfo.jsp");
		}
		
		
		
		
		return forward;
	}

}
