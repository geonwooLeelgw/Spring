package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import bean.MemberBean;
import dao.DAO;

public class MemberJoinService {

	public boolean JoinMember(MemberBean member) {

		DAO memberDAO = DAO.getInstance();// Join
		Connection con = getConnection();
		memberDAO.setConnection(con);

		boolean joinResult = false;

		int result = memberDAO.insertMember(member); // joinDAO. 메소드(매개변수)
		if (result > 0) {
			joinResult = true;
			commit(con);
		} else {
			joinResult = false;
			rollback(con);
		}
		close(con);
		return joinResult;
	}
}
