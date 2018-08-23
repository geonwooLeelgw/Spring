package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdvertiseMentAction;
import action.CanceledSuspensionAction;
import action.CategoryFoodAction;
import action.CategorySearchAction;
import action.ChangedPersonalInfoAction;
import action.ChangedPersonalInfoModiAction;
import action.CoureseRepleAction;
import action.CoureseRepleDeleteAction;
import action.CourseDeleteAction;
import action.CourseEditorAction;
import action.CourseInsertAction;
import action.CourseLikeUpDownAction;
import action.CourseListRankAction;
import action.CourseViewAction;
import action.LogOutAction;
import action.MemberJoinAction;
import action.MemberListAction;
import action.MemberLoginAction;
import action.MemberSuspendedAction;
/*import action.SuspendedMemberListAction;*/
import action.UserDeletePassAction;
import action.UserLikeListAction;
import action.courseLikeNoAction;
import bean.ActionForward;

@WebServlet("*.s")
public class DateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DateContoller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println("컨트롤라 :" + command);
		
		if(command.equals("/se2/photo_uploader/popup/indexAdmin.s")){
			command = RequestURI.substring(contextPath.length()+25);
		}


		ActionForward forward = null;
		Action action = null;

		if (command.equals("/SignUp.s")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberLoginAction.s")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/LogOut.s")) {
			action = new LogOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/CategoryFoodList.s")) {
			action = new CategoryFoodAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseView.s")) {
			action = new CourseViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseLike.s")) {
			action = new CourseLikeUpDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseLikeNo.s")) {
			action = new courseLikeNoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseReple.s")) {
			action = new CoureseRepleAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseDelete.s")) {
			action = new CourseDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseRepleDelete.s")) {
			action = new CoureseRepleDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/courseListRank.s")) {
			action = new CourseListRankAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ChangedPersonalInfo.s")) {
			action = new ChangedPersonalInfoAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/ChangedPersonalInfoModi.s")) {
			action = new ChangedPersonalInfoModiAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userDeletePass.s")) {
			action = new UserDeletePassAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/allMembersList.s")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/suspendedMember.s")) {
			action = new MemberSuspendedAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/allSuspendedMembersList.s")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/canceledSuspension.s")) {
			action = new CanceledSuspensionAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/advertisement.s")) {
			action = new AdvertiseMentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CategorySearch.s")) {
			action = new CategorySearchAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/userLikeListAction.s")) {
			System.out.println("컨트롤러 좋아요 액션 보내기 전");
			action = new UserLikeListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/courseInsert.s")) {
			action = new CourseInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/se2/photo_uploader/popup/CourseEditor.s")) {
			action = new CourseEditorAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/indexAdmin.s")) {
			
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("/project_datecourse_0.0.3/index.jsp");
		}







		//
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
