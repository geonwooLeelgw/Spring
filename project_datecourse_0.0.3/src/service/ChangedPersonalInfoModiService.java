package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.MemberBean;
import dao.DAO;

public class ChangedPersonalInfoModiService {

	public boolean modipassword(MemberBean memberBean) {

		DAO changpasswordDAO = DAO.getInstance();
		Connection con = getConnection();
		changpasswordDAO.setConnection(con);
		boolean passwordResult = false;
		
		int passwordCount = changpasswordDAO.modiPassword(memberBean);
		
		//passwordCountrk 1이면 true, commit
		if(passwordCount>0) {
			passwordResult=true;
			commit(con);
		}else {//else false면 rollback
			passwordResult=false;
			rollback(con);
		}
		close(con);
		return passwordResult;
	}

}
