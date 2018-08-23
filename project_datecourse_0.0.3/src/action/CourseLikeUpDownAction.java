
package action;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import service.CourseLikeService;

public class CourseLikeUpDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//좋아요 선택
		
		ActionForward forward = null;

		int course_num = Integer.parseInt(request.getParameter("course_num"));
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		System.out.println(id);
		CourseLikeService courseLike = new CourseLikeService();
		boolean result = courseLike.LikeUp(course_num,id);

		if (result) {
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("courseView.s?course_num="+course_num);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('좋아요 이미 한번누르심')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
