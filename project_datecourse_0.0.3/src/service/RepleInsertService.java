package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DAO;

public class RepleInsertService {

	public boolean insertReple(int course_num, String reple, String id) {
		DAO insertDAO = DAO.getInstance();
		Connection con = getConnection();
		insertDAO.setConnection(con);

		boolean RepleResult = false;

		int insertResult = insertDAO.insertReple(course_num, reple,id);

		if (insertResult > 0) {
			RepleResult = true;
			commit(con);
		} else {
			RepleResult = false;
			rollback(con);
		}
		close(con);
		return RepleResult;
	}

}
