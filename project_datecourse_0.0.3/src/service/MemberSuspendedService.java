package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.DAO;

public class MemberSuspendedService {
	
	public boolean returningToAction(String thatId) {
		
		DAO SuspendedDAO = DAO.getInstance();
		Connection con = getConnection();
		SuspendedDAO.setConnection(con);

		boolean LoginMember = false;

		int result = SuspendedDAO.SuspendedMember(thatId);

		if (result > 0) {
			LoginMember = true;
			commit(con);
		}
		close(con);
		return LoginMember;
	}
}
		



