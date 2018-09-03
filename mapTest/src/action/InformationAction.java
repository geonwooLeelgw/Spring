package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.Informationbean;
import service.InformationService;

public class InformationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		 InformationService  Information = new InformationService();
	
		ArrayList<Informationbean> information = Information.information();
		
		System.out.println("사이즈 테스트:"+information.size());
		
		request.setAttribute("InfoResult", information);
		
		forward = new ActionForward();
		forward.setPath("./googlemaps.jsp");
			
		  return forward;

}
}
