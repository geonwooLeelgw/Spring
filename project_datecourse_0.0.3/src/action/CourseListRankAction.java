package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CourseBean;
import service.CourseListRankService;

public class CourseListRankAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		CourseListRankService courseListRankService = new CourseListRankService();

		ArrayList<CourseBean> RankList = courseListRankService.returningToAction();

		request.setAttribute("RankList", RankList);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("index.jsp");

		return forward;
	}

}
