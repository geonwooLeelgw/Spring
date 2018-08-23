package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ActionForward;
import bean.CourseBean;
import bean.MemberBean;
import service.CourseListRankService;
import service.MemberLoginService;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean member = new MemberBean();
		ActionForward forward = null;
		String pass = request.getParameter("password");
		member.setId(request.getParameter("id"));
		member.setPassword(pass);

		// MemberLoginService 객체 생성 및 호출

		MemberLoginService memberloginService = new MemberLoginService();
		MemberBean loginResult = memberloginService.MemberLogin(member);

		CourseListRankService courseListRankService = new CourseListRankService();

		ArrayList<CourseBean> RankList = courseListRankService.returningToAction();
		//코스랭크리스트 조회

		System.out.println("입력한 비밀번호 : " + pass);
		System.out.println("db비밀번호 : " + loginResult.getPassword());

		// 로그인 성공, 실패여부
		if ((pass.equals(loginResult.getPassword()))) {
			if (loginResult.getSuspendedNum() == 1) {
				if (loginResult != null) {

					HttpSession session = request.getSession();
					session.setAttribute("id", member.getId());

					request.setAttribute("RankList", RankList);
					forward = new ActionForward();
					//로그인 성공했을 때 코스랭크리스트 조회

					forward.setRedirect(false);
					forward.setPath("./index.jsp");

				}
			} else if (loginResult.getSuspendedNum() == -1) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정지된 회원입니다. 관리자에게 문의해주세요.')");
				out.println("history.back()");
				out.println("</script>");

			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 확인해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 비밀번호를 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");
			
			
		}
		return forward;

	}

}
