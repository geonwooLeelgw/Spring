package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import service.RepleDeleteService;

public class CoureseRepleDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//댓글 삭제
		
		ActionForward forward = null;
		RepleDeleteService repleDeleteService = new RepleDeleteService();
		int reple_num = Integer.parseInt(request.getParameter("reple_num"));
		int course_num = Integer.parseInt(request.getParameter("course_num"));
		//해당 코스번호와 댓글번호를 가져옴
		

		boolean delResult = false;
		delResult = repleDeleteService.repleDelete(reple_num);

		if (delResult == true) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("courseView.s?course_num="+course_num);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert(delete failed);");
			out.println("</script>");
		}

		return forward;
	}

}
