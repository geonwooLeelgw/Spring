package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.CourseBean;
import bean.EditorBean;
import bean.LikeBean;
import bean.RepleBean;
import service.CourseViewService;
import service.LikeViewService;
import service.RepleViewService;
import service.editorViewService;

public class CourseViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		CourseViewService courseViewService = new CourseViewService();
		LikeViewService likeViewService = new LikeViewService();
		int course_num = Integer.parseInt(request.getParameter("course_num"));
		//해당 코스에 고유한 번호 값 가져오기
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		
		//로그인이 되어있지않을 경우 뒤로가기
		if(id==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('LOGIN Please');");
			out.println("history.back()");
			out.println("</script>");
		}else {
		
		CourseBean courseView = null;
		ArrayList<RepleBean> repleBean = null;
		LikeBean likeBean = null;
		EditorBean editorBean = null;
		
		//코스에 저장된 코스, 댓글, 좋아요, 내용 값 가져오기
		courseView = courseViewService.returningToAction(course_num);
		System.out.println("1");
		repleBean = RepleViewService.Reple(course_num);
		System.out.println("2");
		likeBean = likeViewService.like(course_num,id);
		System.out.println("3");
		editorBean = editorViewService.editor(course_num);
		System.out.println("4");
		
		
		if(courseView != null) {
			response.setContentType("text/html;charset=UTF-8");
			request.setAttribute("courseView", courseView);
			request.setAttribute("RepleView", repleBean);
			request.setAttribute("likeBean", likeBean);
			request.setAttribute("editor", editorBean);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("CategoryListView.jsp");
			
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('코스뷰를 할 수 없다능!');");
			out.println("</script>");
		}
		}
		return forward;
	}

}
