package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import service.RepleInsertService;

public class CoureseRepleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		RepleInsertService repleInsertService = new RepleInsertService();
		boolean insertResult = false;

		int course_num = Integer.parseInt(request.getParameter("course_num"));
		String reple = request.getParameter("reple");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		//코스게시물 교유 번호 값, 고유한 아이디 값, 리플 작성 값 가져오기
		
		
		insertResult = repleInsertService.insertReple(course_num, reple,id);

		if (insertResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 삽입 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("courseView.s?course_num="+course_num);
		}

		return forward;
	}

}
