package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.CourseBean;
import service.CategorySearchService;

public class CategorySearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String key = request.getParameter("KeywordSearch");
		//검색한 값 가져오기
		
		CategorySearchService css = new CategorySearchService();

		ArrayList<CourseBean> searchlist = css.foodinsert(key);
		//검색 결과값을 가져옴
		
		request.setAttribute("FoodList", searchlist);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CategoryList.jsp");
		return forward;
		
	}

}
