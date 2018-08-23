package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.MemberBean;
import dao.DAO;

public class MemberLoginService {

	public MemberBean MemberLogin(MemberBean member) {
		
		//DAO 객체생성
		DAO loginDAO = DAO.getInstance();
		
		Connection con = getConnection();
		//DB접속 정보를 넘겨줌
		loginDAO.setConnection(con);

		//LoginMember false
	
		
		MemberBean MB = loginDAO.SelectLoginMember(member);
	
		
		close(con);
		return MB;
	}

}
