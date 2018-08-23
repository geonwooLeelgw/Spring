package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MemberBean;
import service.MemberJoinService;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberBean member = new MemberBean(); // JoinBean필드값을 가져오기 위한 객체 생성

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String recommendation = request.getParameter("recommendation");
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setNickname(nickname);
		member.setEmail(email);
		member.setRecommendation(recommendation);
		//입력받은 회원정보값 저장

		boolean joinResult = false; // servic클래스에

		MemberJoinService mjs = new MemberJoinService();
		joinResult = mjs.JoinMember(member);

		ActionForward forward = null;
		if (joinResult == false) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입을 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.jsp");
		}

		return forward;
	}

}
