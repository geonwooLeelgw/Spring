package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;

public class RepleDeleteService {

	public boolean repleDelete(int reple_num) {
		DAO delDAO = DAO.getInstance();
		Connection con = getConnection();
		delDAO.setConnection(con);
		
		boolean delResult = false;
		int result = delDAO.deleteReple(reple_num);
		
		if (result > 0) {
			delResult = true;
			commit(con);
		} else {
			delResult = false;
			rollback(con);
		}
		close(con);

		return delResult;
	}

}
