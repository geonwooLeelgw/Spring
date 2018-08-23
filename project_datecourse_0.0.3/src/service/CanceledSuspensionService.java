package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.DAO;

public class CanceledSuspensionService {
public boolean returningToAction(String forCancel) {
		
		DAO SuspendedDAO = DAO.getInstance();
		Connection con = getConnection();
		SuspendedDAO.setConnection(con);

		boolean LoginMember = false;

		int result = SuspendedDAO.CancelSuspension(forCancel);

		if (result > 0) {
			LoginMember = true;
			commit(con);
		}
		close(con);
		return LoginMember;
	}
}


