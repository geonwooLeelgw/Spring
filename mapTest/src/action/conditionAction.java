package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.Informationbean;
import bean.conditionbean;
import service.conditionService;
public class conditionAction implements Action {
	
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("테스트입니다1.");
		ActionForward forward = null;
		 response.setContentType("text/html;charset=UTF-8");
	     request.setCharacterEncoding("UTF-8");
		
		
		String[] village; //동네
		String[] calendar; //개월~년
		String[] dayofweek; //요일
		String[] day; //시간 (오전, 오후, 새벽) 
		
		if((request.getParameterValues("village")) == null){
			village=new String[1];
			village[0] = "no";
		}else {
			village = request.getParameterValues("village");	
		}
		for(int i=0;i<village.length;i++) {
			System.out.println("village값"+i+"="+village[i]);
			}
		
		

		if((request.getParameterValues("calendar")) == null){
			calendar=new String[1];
			calendar[0] = "no";
		}else {
			calendar = request.getParameterValues("calendar");	
		}
		for(int i=0;i<calendar.length;i++) {
		System.out.println("calendar값"+i+"="+calendar[i]);
		}
		
		
		
		if((request.getParameterValues("dayofweek")) == null){
			dayofweek=new String[1];
			dayofweek[0] = "no";
		}else {
			dayofweek = request.getParameterValues("dayofweek");	
		}
		for(int i=0;i<dayofweek.length;i++) {
		System.out.println("dayofweek값"+i+"="+dayofweek[i]);
		}
		
	
		
		if((request.getParameterValues("day")) == null){
			day=new String[1];
			day[0] = "no";
		}else {
			day = request.getParameterValues("day");	
		}
		for(int i=0;i<day.length;i++) {
		System.out.println("day값"+i+"="+day[i]);
		}
		
		
		
		conditionService condition = new conditionService();
		
		ArrayList<Informationbean> Condition = condition.condition(village,calendar,dayofweek,day);
			
		request.setAttribute("InfoResult", Condition);
			
		forward = new ActionForward();
		forward.setPath("./googlemaps.jsp");

		return forward;

}
}