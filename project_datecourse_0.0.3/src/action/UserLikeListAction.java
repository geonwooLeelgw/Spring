package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.CourseBean;
import service.UserLikeListService;

public class UserLikeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//자신이 좋아요 누른 코스목록 조회
		
		ActionForward forward = null;
		UserLikeListService userLikeListService = new UserLikeListService();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("id");
		ArrayList<CourseBean> likeList = userLikeListService.likeList(id);
		
		request.setAttribute("likeList", likeList);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("likeList.jsp");
		
		return forward;
	}

}
