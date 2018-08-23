package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CourseBean;
import service.CategoryFoodService;

public class CategoryFoodAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String key = request.getParameter("key");
		//해당 카테고리 키워드 가져오기
		
		CategoryFoodService cfs = new CategoryFoodService();
		System.out.println("키값 : "+key);
		
		ArrayList<CourseBean> FoodList = cfs.foodinsert(key);
		//해당 카테고리에 해당하는 코스 정보 가져오기
		
		request.setAttribute("FoodList", FoodList);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/CategoryList.jsp");
		return forward;
	}
}
