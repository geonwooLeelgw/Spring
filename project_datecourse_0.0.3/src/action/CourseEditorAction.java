package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.EditorBean;
import service.CourseEditorService;


public class CourseEditorAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//코스 삽입-2
		
		request.setCharacterEncoding("UTF-8");
		
		String filename1 = request.getParameter("filename1");
		String filename2 = request.getParameter("filename2");
		String filename3 = request.getParameter("filename3");
		String filename4 = request.getParameter("filename4");
		String filename5 = request.getParameter("filename5");
		//사진 이름
		
		String ir1 = request.getParameter("ir1");
		//내용
		
		System.out.println(request.getParameter("ir1"));
		EditorBean ed = new EditorBean();
		
		ed.setImage1(filename1);
		ed.setImage2(filename2);
		ed.setImage3(filename3);
		ed.setImage4(filename4);
		ed.setImage5(filename5);
		ed.setContent(ir1);
		
		HttpSession session = request.getSession();
		session.removeAttribute("ir1");
		session.removeAttribute("filename1");
		session.removeAttribute("filename2");
		session.removeAttribute("filename3");
		session.removeAttribute("filename4");
		session.removeAttribute("filename5");
		
		ActionForward forward = null;
		CourseEditorService courseEditorService = new CourseEditorService();
		boolean insertResult = false;
		
		insertResult = courseEditorService.insertEditor(ed);
		
		if (insertResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('에디터삽입 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			
			forward.setPath("indexAdmin.s");
		}

		return forward;
	}

}
