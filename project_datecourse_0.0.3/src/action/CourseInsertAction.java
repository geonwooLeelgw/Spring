package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.CourseBean;
import service.CourseInsertService;

public class CourseInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CourseBean course = new CourseBean();
		ActionForward forward = null;
		CourseInsertService courseInsertService = new CourseInsertService();
		boolean insertResult = false;

		String course_name = request.getParameter("course_name");
		String course_location = request.getParameter("course_location");
		String course_place_name = request.getParameter("course_place_name");
		int course_place_tel = Integer.parseInt(request.getParameter("course_place_tel"));
		String course_search_keyword = request.getParameter("course_search_keyword");
		//입력받은 정보 저장

		course.setCourse_name(course_name);
		course.setCourse_location(course_location);
		course.setCourse_place_name(course_place_name);
		course.setCourse_place_tel(course_place_tel);
		course.setCourse_search_keyword(course_search_keyword);
		
		
		insertResult = courseInsertService.insertCourse(course);
		
		if (insertResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('코스삽입에 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./se2/SmartEditor2.html.svntmp");
		}

		return forward;
	}

}

