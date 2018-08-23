package service;

import java.sql.*;
import static db.JdbcUtil.*;
import bean.MemberBean;
import dao.DAO;

public class ChangedPersonalInfoService {

	public MemberBean getmember(String id) {

		DAO membDAO = DAO.getInstance();
		Connection con = getConnection();
		membDAO.setConnection(con);
		
		MemberBean mem = null;
		
		mem = membDAO.memmodify(id);
		close(con);
		return mem;
	}

}
