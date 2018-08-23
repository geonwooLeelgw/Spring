package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.AdvertisementBean;
import service.AdvertisementService;



public class AdvertiseMentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int advertisement_num = (int) (Math.random()*6+1);
		//여러개의 광고를 랜덤으로 돌림
	
		AdvertisementBean AB = null;
		
		AdvertisementService advertisementService = new AdvertisementService();
		
		AB = advertisementService.returningToAction(advertisement_num);
		
		if(AB != null) {
			request.setAttribute("AB", AB);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("Advertisement.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('popup failed');");
			out.println("</script>");
		}

		return forward;
	}
	
}



