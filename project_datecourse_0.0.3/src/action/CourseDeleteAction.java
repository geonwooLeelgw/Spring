package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.CourseDeleteService;

public class CourseDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		CourseDeleteService courseDeleteService = new CourseDeleteService();
		int course_num = Integer.parseInt(request.getParameter("forDel_num"));
		//고유한 코스의 번호를 가져옴
		
		boolean delResult = false;
		delResult = courseDeleteService.returningToAction(course_num);
		
		if(delResult == true) {
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert(delete failed);");
			out.println("</script>");
		}
		
		
		return forward;
	}

	
}
