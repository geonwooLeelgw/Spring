package dao;
import static db.jdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;

import action.conditionAction;
import bean.Informationbean;
import bean.conditionbean;
public class InformationDAO {
	
	
	DataSource ds;
	Connection con;
	private static InformationDAO InformationDAO;
	
	int Result = 0;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private InformationDAO() {
		
	}
	
	public static InformationDAO getInstance() {
		if(InformationDAO==null) {
			InformationDAO = new InformationDAO();
		}
		return InformationDAO;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	public ArrayList<Informationbean> information() {
		String sql="select * from alba";
		ArrayList<Informationbean> list = new ArrayList<Informationbean>();
		Informationbean informationbean = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("execute까지 되냐");
			while(rs.next()) {
				informationbean = new Informationbean(); 
				informationbean.setJOB_NUMBER(rs.getString(1));
				informationbean.setCOMPANY_INFORMATION(rs.getString(2));
				informationbean.setJOB_FAMILY(rs.getString(3));
				informationbean.setJOB_GESTALT(rs.getString(4));
				informationbean.setJOB_PERIOD(rs.getString(5));
				informationbean.setJOB_DAY(rs.getString(6));
				informationbean.setJOB_TIME(rs.getString(7));
				informationbean.setJOB_MONEY(rs.getString(8));
				informationbean.setJOB_LOCATION(rs.getString(9));
				informationbean.setJOB_LOCATION1(rs.getString(10));	
				informationbean.setJOB_AREA(rs.getString(11));
				informationbean.setJOB_KINDOFPAY(rs.getString(12));
				informationbean.setJOB_HOURS(rs.getString(13));
				informationbean.setJOB_TIMEDAY(rs.getString(14));
				informationbean.setJOB_TIMEWEEK(rs.getString(15));
				list.add(informationbean);
			}
			//System.out.println(list.get(0).getJOB_LOCATION());
		}catch(Exception e){
			System.out.println("informationbean 오류!! " +e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	
	public ArrayList<Informationbean> condition(
			String[] village,
			String[] calendar,
			String[] dayofweek,
			String[] day) {
		
		conditionbean conditionbean = new conditionbean();
		String[] cho=new String[4];
		for(int i=0;i<cho.length;i++) {
			cho[i]=" ";
		}
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")"; //village 혼자 체크시 
			
		}
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_PERIOD in(";
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")"; //calendar 혼자 체크시 
			
		}
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_TIMEDAY in(";
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")"; //dayofweek 혼자 체크시 
			
		}
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_TIMEWEEK in(";
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")"; //day 혼자 체크시 
			
		}
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_PERIOD in("; 
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
		} //village와 calendar만 체크시 
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEDAY in("; 
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
		} //village와 dayofweek 체크시
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEWEEK in("; 
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		} //village와 day 체크시
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_PERIOD in(";
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEDAY in("; 
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
		} //calendar와 dayofweek 체크시
		
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_PERIOD in(";
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEWEEK in("; 
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		} //calendar와 day 체크시
		
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_TIMEDAY in(";
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEWEEK in("; 
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
				
		} //dayofweek와 day 체크시
		
		
		
		
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_PERIOD in("; 
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[2] = "AND JOB_TIMEDAY in(";
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[2];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
		}	// village , calendar, dayofweek 체크시
		
		
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_PERIOD in("; 
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[2] = "AND JOB_TIMEWEEK in(";
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[2];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		}	// village , calendar, day 체크시
		
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEDAY in("; 
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
				cho[2] = "AND JOB_TIMEWEEK in(";
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[2];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		}	// village , dayofweek, day 체크시
		
		
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_PERIOD in(";
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_TIMEDAY in("; 
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
				cho[2] = "AND JOB_TIMEWEEK in(";
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[2];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		}	// calendar , dayofweek, day 체크시
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
			cho[0]="where JOB_AREA in(";
				for(int i=0;i<village.length;i++) {
					if(i==0) {
						cho[0]+="'"+village[i]+"'";
					}else {
						cho[0]+=",'"+village[i]+"'";}
				}
				cho[0]+=")";
				cho[1] = "AND JOB_PERIOD in("; 
				for(int i=0;i<calendar.length;i++) {
					if(i==0) {
						cho[0]+=cho[1];
						cho[0]+="'"+calendar[i]+"'";
					}else {
						cho[0]+=",'"+calendar[i]+"'";}
				}
				cho[0]+=")";
				cho[2] = "AND JOB_TIMEDAY in(";
				for(int i=0;i<dayofweek.length;i++) {
					if(i==0) {
						cho[0]+=cho[2];
						cho[0]+="'"+dayofweek[i]+"'";
					}else {
						cho[0]+=",'"+dayofweek[i]+"'";}
				}
				cho[0]+=")";
				cho[3] = "AND JOB_TIMEWEEK in(";
				for(int i=0;i<day.length;i++) {
					if(i==0) {
						cho[0]+=cho[3];
						cho[0]+="'"+day[i]+"'";
					}else {
						cho[0]+=",'"+day[i]+"'";}
				}
				cho[0]+=")";
		}	
		
		
		// 모두 체크시
		
		
		
		System.out.println("village + calendar 테스트입니다."+cho[0]);
		
		
		
		
		
		System.out.println("마지막 village 테스트입니다."+cho[0]);
		
		String sqltest = " ";
		String sql = "select * from alba ";
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		}//동네 하나만 체크시
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		}//월 하나만 체크시
		
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //요일 하나만 체크시
		
		
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //오전~야간 하나만 체크시
		
		
		
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //동네와 달~년 체크시
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //동네와 요일 체크시
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //동네와 오전~야간 체크시
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //개월수와 요일 체크시 
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} //개월수와 요일 체크시 
		
		
		
		
		if(village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 요일과 시간 체크시 
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 동네, 개월수, 요일 체크시
		
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 동네, 개월수, 시간 체크시
		
		
		
		
		if(!village[0].equals("no") && calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 동네, 요일, 시간 체크시
		
		
		
		if(village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 월, 요일, 시간 체크시
		
		
		
		
		
		if(!village[0].equals("no") && !calendar[0].equals("no") && 
				!dayofweek[0].equals("no") && !day[0].equals("no")){
		sqltest+=cho[0];
		sql+=sqltest;
		} // 모두 체크시
		
		
		
		
		System.out.println("테스트입니다."+sql);
		ArrayList<Informationbean> list = new ArrayList<Informationbean>();
		Informationbean informationbean = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				informationbean = new Informationbean(); 
				informationbean.setJOB_NUMBER(rs.getString(1));
				informationbean.setCOMPANY_INFORMATION(rs.getString(2));
				informationbean.setJOB_FAMILY(rs.getString(3));
				informationbean.setJOB_GESTALT(rs.getString(4));
				informationbean.setJOB_PERIOD(rs.getString(5));
				informationbean.setJOB_DAY(rs.getString(6));
				informationbean.setJOB_TIME(rs.getString(7));
				informationbean.setJOB_MONEY(rs.getString(8));
				informationbean.setJOB_LOCATION(rs.getString(9));
				informationbean.setJOB_LOCATION1(rs.getString(10));	
				informationbean.setJOB_AREA(rs.getString(11));
				informationbean.setJOB_KINDOFPAY(rs.getString(12));
				informationbean.setJOB_HOURS(rs.getString(13));
				informationbean.setJOB_TIMEDAY(rs.getString(14));
				informationbean.setJOB_TIMEWEEK(rs.getString(15));
				list.add(informationbean);
			}
			//System.out.println(list.get(0).getJOB_LOCATION());
		}catch(Exception e){
			System.out.println("informationbean 오류!! " +e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return list;
	}
}
